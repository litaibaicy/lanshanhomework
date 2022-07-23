package demo02;

import java.util.Iterator;
import java.util.LinkedList;
public class LinkListTest {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        //插入
        list.add("AA");
        list.add("ZZ");
        list.add("PP");
        list.add("HH");
        list.add(1,"SS");
        System.out.println(list);
        System.out.println("");

        //删除
        if (list.contains("AA") == true){
            list.remove("AA");
        }
        System.out.println(list);
        System.out.println("");

        //查找
        list.get(2);
        System.out.println(list);
        System.out.println("");

        //遍历
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println(list);


    }
//反转链表
    public static class Node {

        private long data;
        private Node nextNode;

        public Node(long value)
        {
            this.data = value;
        }

        public long getData() {
            return data;
        }

        public void setData(long data) {
            this.data = data;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

    }
    public static class linkList {

        private Node firstNode;//头结点

        public linkList()
        {
            firstNode = null;
        }

        /**
         * 头插法建立链表
         */
        public void insertBegin(long value)
        {
            Node node = new Node(value);
            if (firstNode != null) {
                node.setNextNode(firstNode);
            }
            firstNode = node;
        }
        /**
         * reverseList反转列表
         */
        public Node  reverseList(){
            if(firstNode == null )
                return null;
            else if( firstNode.getNextNode() == null){
                return firstNode;
            }
            Node first = firstNode;
            Node second = firstNode.getNextNode();
            Node third = firstNode.getNextNode().getNextNode();

            first.setNextNode(null);
            while(third != null){
                second.setNextNode(first);
                first = second;
                second = third;
                third = third.getNextNode();
            }
            second.setNextNode(first);
            return second;
        }
        //first node为列表翻转后的头结点
        public void printReverse(Node firstnode){
            if(firstnode== null)
            {
                System.out.println("链表为空");
                return;
            }
            Node currNode = firstnode;
            while(currNode != null)
            {
                System.out.print(currNode.getData()+" ");

                currNode = currNode.getNextNode();

            }
        }
    }
}
