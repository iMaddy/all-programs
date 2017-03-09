package com.maddy.collections;

import java.util.Scanner;

/**
 * Created by madhukar on 06/03/17.
 */
class RNode
{
    public int data;
    public RNode next;
    public RNode random;

    public RNode(int d)
    {
        data = d;
        next = random = null;
    }
}

public class RandomList
{
    RNode head;

    public RandomList()
    {
        head = null;
    }

    public void print()
    {
        RNode temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public void printRandom()
    {
        RNode temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.random;
        }

        System.out.println();
    }

    public void add(int data)
    {
        if(head == null)
        {
            head = new RNode(data);
            return;
        }

        if(data<=head.data)
        {
            RNode temp = head;
            head = new RNode(data);
            head.next = temp;
            head.random = temp;
            return;
        }

        //insert at the end
        RNode temp = head;
        RNode random = head;

        while(temp.next != null)
        {
            if(random.random != null && random.random.data < data)
            {
                random = random.random;
            }

            temp = temp.next;
        }

        RNode newNode = new RNode(data);
        temp.next = newNode;

        newNode.random = random.random;
        random.random = newNode;
    }

    public static void main(String[] args)
    {
        RandomList rlist = new RandomList();
        Scanner sc = new Scanner(System.in);

        int data;

        while ((data = sc.nextInt()) != -999)
        {
            rlist.add(data);
            rlist.print();
            rlist.printRandom();
        }
    }
}