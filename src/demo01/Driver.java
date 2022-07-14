package demo01;

import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {

        Lost[] lostArray = new Lost[6];

        Lost lost1 = new Lost("Book1",2022,6,2,7,0);
        Lost lost2 = new Lost("Book2",2022,7,7 ,22,15);
        Lost lost3 = new Lost("Book3",2022,3,3 ,23,25);
        Lost lost4 = new Lost("Card1",2022,7,26,13,15);
        Lost lost5 = new Lost("Card2",2022,4,11,10,10);
        Lost lost6 = new Lost("Card3",2022,11,3,16,35);

       lostArray[0] = lost1;
       lostArray[1] = lost2;
       lostArray[2] = lost3;
       lostArray[3] = lost4;
       lostArray[4] = lost5;
       lostArray[5] = lost6;

        Solution solution = new Solution();

        System.out.println("-----失物列表-----");
        solution.sortLost(lostArray);

        Scanner scan = new Scanner(System.in);

        System.out.println("");

        System.out.println("请输入您丢失的物品关键词");
        String keyword = scan.next();

        solution.selectByKeyword(lostArray,keyword);



        scan.close();
    }
}



class Solution{
    /**
     * 失物排序方法
     * @param lostArray 待排序的失物数组
     */
    public void sortLost(Lost[] lostArray){
        for (int j = 0; j < lostArray.length -  1; j++) {
            for (int i = 0; i < lostArray.length - 1 - j; i++) {
                if (lostArray[i].getYear() > lostArray[i + 1].getYear()) {
                    Lost temp = lostArray[i];
                    lostArray[i] = lostArray[i + 1];
                    lostArray[i + 1] = temp;
                } else if (lostArray[i].getYear() == lostArray[i + 1].getYear()) {
                    if (lostArray[i].getMonth() > lostArray[i + 1].getMonth()) {
                        Lost temp = lostArray[i];
                        lostArray[i] = lostArray[i + 1];
                        lostArray[i + 1] = temp;
                    } else if (lostArray[i].getMonth() == lostArray[i + 1].getMonth()) {
                        if (lostArray[i].getDay() > lostArray[i + 1].getDay()) {
                            Lost temp = lostArray[i];
                            lostArray[i] = lostArray[i + 1];
                            lostArray[i + 1] = temp;
                        } else if (lostArray[i].getDay() == lostArray[i + 1].getDay()) {
                            if (lostArray[i].getHour() > lostArray[i + 1].getHour()) {
                                Lost temp = lostArray[i];
                                lostArray[i] = lostArray[i + 1];
                                lostArray[i + 1] = temp;
                            } else if (lostArray[i].getHour() == lostArray[i + 1].getHour()) {
                                if (lostArray[i].getMin() > lostArray[i + 1].getMin()){
                                    Lost temp = lostArray[i];
                                    lostArray[i] = lostArray[i + 1];
                                    lostArray[i + 1] = temp;
                                }
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < lostArray.length; i++) {
            System.out.println((1 + i) + ": "  + lostArray[i]);
        }
    }

    /**
     * 按关键字搜索失物的方法，这里假设按照失物的领取地点进行搜索
     * @param lostArray 失物数组
     * @param keyword 用户输入的关键字
     * @return 返回查找到的失物
     */
    public Lost[] selectByKeyword(Lost[] lostArray,String keyword){
        Lost[] aimLost = new Lost[1];


        for (int i = 0; i < lostArray.length; i++) {
            if (lostArray[i].getName().equals(keyword)){
                aimLost[0] = lostArray[i];
                System.out.println("你的丢失的物品在失物招领处," + "序号为" + (i + 1));
            }
        }



        return aimLost;
    }



}

class Lost{
    
    private String name;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int min;


    public Lost() {
    }

    public Lost(String name,int year,int month,int day,int hour,int min){
            this.name = name;
            this.year = year;
            this.month = month;
            this.day = day;
            this.hour = hour;
            this.min =min;
    }







    public boolean equals(Object obj){
        if(!(obj instanceof Lost)){
            return false;
        }
        Lost other = (Lost) obj;
        return this.name == other.name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", hour=" + hour +
                ", min=" + min ;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay(){
        return day;
    }

    public void setDay(int day){
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}

class CardLost extends Lost{
    private String name;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int min;


    public CardLost() {
    }

    public CardLost(String name,int year,int month,int day,int hour,int min){
        this.name = name;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.min =min;
    }

    public boolean equals(Object obj){
        if(!(obj instanceof CardLost)){
            return false;
        }
        CardLost other = (CardLost) obj;
        return this.name == other.name;
    }


}

class BookLost extends Lost{
    private String name;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int min;


    public BookLost() {
    }

    public BookLost(String name,int year,int month,int day,int hour,int min){
        this.name = name;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.min =min;
    }


    public boolean equals(Object obj){
        if(!(obj instanceof BookLost)){
            return false;
        }
        BookLost other = (BookLost) obj;
        return this.name == other.name;
    }


}