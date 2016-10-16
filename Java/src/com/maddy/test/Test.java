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
        list.addAtBeginning(10);
        list.addAtBeginning(20);
        list.print();
    }
}
