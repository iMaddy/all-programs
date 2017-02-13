package com.maddy.test;

import com.maddy.collections.MyLinkedList;
import com.maddy.collections.UniDirectionalNode;

/**
 * Created by gitanjali on 12/02/17.
 */
public class Demo
{
    public static void main(String[] args)
    {
        listMergePointDemo();
    }

    private static void listMergePointDemo()
    {
        MyLinkedList l1 = new MyLinkedList();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add(5);
        l1.add(6);
        l1.add(7);
        l1.add(8);
        l1.add(9);

        MyLinkedList l2 = new MyLinkedList();
        l2.add(1);
        l2.add(2);
        l2.add(3);
        l2.add(4);
        UniDirectionalNode l2node = l2.findNode(4);
        //l2node.next = l1.findNode(6);

        l2.add(10);

        System.out.println(l1.findNode(6)  + " " + l2.findNode(6));

        System.out.println(MyLinkedList.mergePoint(l1,l2));
    }


}
