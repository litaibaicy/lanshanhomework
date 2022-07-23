package demo02;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

class FormulaException extends Exception{
    public FormulaException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "输入错误!错误信息[" + getMessage() + "]";
    }
}

public class Calculator {
    public static Map pro=new HashMap();
    public static void init()
    {
        pro.put('+', 1);
        pro.put('-', 1);
        pro.put('*', 2);
        pro.put('/', 2);
    }
    public static int getIndex(String str)
    {
        int index1=(str.indexOf('+')==-1?str.length():str.indexOf('+'));
        int index2=(str.indexOf('-')==-1?str.length():str.indexOf('-'));
        int index3=(str.indexOf('*')==-1?str.length():str.indexOf('*'));
        int index4=(str.indexOf('/')==-1?str.length():str.indexOf('/'));
        int index=index1<index2?index1:index2;
        index=index<index3?index:index3;
        index=index<index4?index:index4;
        return index;
    }
    public static double cal(char op,double num1,double num2) throws FormulaException
    {
        switch(op)
        {
            case '+':
                return num1+num2;
            case '-':
                return num1-num2;
            case '*':
                return num1*num2;
            default:
                if (num2 == 0) throw new FormulaException("被除数不能为0");
                return num1/num2;
        }
    }
    public static double fun1(String str) throws FormulaException
    {
        init();
        Stack st1=new Stack();
        Stack st2=new Stack();
        int fop=0;
        while(str.length()>0)
        {
            int index=getIndex(str);
            String doubleStr = str.substring(0,index);
            Pattern pattern = Pattern.compile("[0-9]*\\.?[0-9]+");
            if (!pattern.matcher(doubleStr).matches()){
                throw new FormulaException("您输入有误！");
            }
            st1.push(Double.parseDouble(doubleStr));
            if(index!=str.length())
            {
                char op=str.charAt(index);
                str=str.substring(index+1);
                while(true)
                {
                    if((int)pro.get(op)>fop)
                    {
                        st2.push(op);
                        fop=(int)pro.get(op);
                        break;
                    }
                    else
                    {
                        double num2= (double) st1.pop();
                        double num1=(double) st1.pop();
                        double result=cal((char)st2.pop(),num1,num2);
                        st1.push(result);
                        if(st2.size()==0)
                        {
                            st2.push(op);
                            fop=(int)pro.get(op);
                            break;
                        }
                        char cop=(char) st2.pop();
                        fop=(int)pro.get(cop);
                        st2.push(cop);
                    }
                }
            }
            else
            {
                break;
            }
        }
        while(st2.size()!=0)
        {
            double num2=(double) st1.pop();
            double num1=(double) st1.pop();
            char op=(char) st2.pop();
            st1.push(cal(op,num1,num2));
        }
        double result=(double) st1.pop();
        return result;
    }
    public static double fun2(String str) throws FormulaException
    {
        while(str.indexOf('(')!=-1)
        {
            int left=0;
            int right=str.length();
            char op;
            for(int i=0;i<str.length();i++)
            {
                if(str.charAt(i)=='(')
                {
                    left=i;
                }
                if(str.charAt(i)==')')
                {
                    right=i;
                    break;
                }
            }
            str=str.substring(0,left)+fun1(str.substring(left+1,right))+str.substring(right+1);
        }

        return fun1(str);

    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入式子");
        String str = scanner.next();
        double result = 0;
        try{
            result = fun2(str);
            System.out.println(result);
        }catch (FormulaException e){
            e.printStackTrace();
        }

    }
}

