package com.maddy.test;

import com.maddy.collections.LinkedList;

/**
 * Created by madhukar.b on 04/09/16.
 */
public class Test
{
    public static void main(String[] args)
    {
        LinkedList list =new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.addAtBeginning(0);
        list.addAtBeginning(-1);
        list.print();
////        System.out.println(list.find(2));
//        //list.swap(32,13);
//        list.swap(32,13);
//        list.print();
//        list.swap(13,32);
//        list.swap(13,32);
//        list.print();

        list.reverse();
        list.print();

    }
}
