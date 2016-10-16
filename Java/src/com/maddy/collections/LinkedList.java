package com.maddy.collections;

/**
 * Created by madhukar.b on 16/10/16.
 */
public class LinkedList
{
    private UniDirectionalNode head;
    public LinkedList()
    {
        this.head = null;
    }

    /**
     * Add element to list at the end
     * @param data element to be inserted
     */
    public void add(int data)
    {
        if(head == null)
        {
            head = new UniDirectionalNode(data);
            return;
        }

        UniDirectionalNode temp = head;
        while(temp.next != null)
        {
            temp = temp.next;
        }

        temp.next = new UniDirectionalNode(data);
    }

    public void addAtBeginning(int data)
    {
        UniDirectionalNode temp = new UniDirectionalNode(data);
        temp.next = head;
        head = temp;
    }

    public void print()
    {
        UniDirectionalNode temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }
}
