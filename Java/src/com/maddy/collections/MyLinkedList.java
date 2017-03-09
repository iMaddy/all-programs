package com.maddy.collections;

import com.sun.org.apache.bcel.internal.generic.LNEG;

/**
 * Created by madhukar.b on 16/10/16.
 */
public class MyLinkedList
{
    private LNode head;
    public MyLinkedList()
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
            head = new LNode(data);
            return;
        }

        LNode temp = head;
        while(temp.next != null)
        {
            temp = temp.next;
        }

        temp.next = new LNode(data);
    }

    public void addAtBeginning(int data)
    {
        LNode temp = new LNode(data);
        temp.next = head;
        head = temp;
    }

    public void print()
    {
        LNode temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    /**
     * Find element in list
     * @param data
     * @return index of element in list if element is present else returns -1
     */
    public int find(int data)
    {
        return findInternal(head,data,0);
    }

    private int findInternal(LNode head, int data, int index)
    {
        if(head == null)
            return -1;

        index++;
        if(head.data == data)
            return index;

        return findInternal(head.next, data, index);
    }

    public LNode findNode(int data)
    {
        return findNodeInternal(head,data,0);
    }

    private LNode findNodeInternal(LNode head, int data, int index)
    {
        if(head == null)
            return null;

        if(head.data == data)
            return head;

        return findNodeInternal(head.next, data, index);
    }

    /**
     * Function to swap node of linked list
     * @param x element to be swapped
     * @param y element to be swapped
     */
    public void swap(int x, int y)
    {
        if(head == null || x==y)
            return;

        LNode prevX = null;
        LNode _x = null;
        LNode prevY = null;
        LNode _y = null;
        LNode temp = head;

        if(head.data == x)
            _x = head;

        if(head.data == y)
            _y = head;

        while(temp.next != null)
        {
            if(_x == null && temp.next.data == x)
            {
                prevX = temp;
                _x = temp.next;
            }

            if(_y == null && temp.next.data == y)
            {
                prevY = temp;
                _y = temp.next;
            }

            if(_x != null && _y != null)
                break;

            temp = temp.next;
        }



        if(_x == null || _y == null)
            return;

        if(prevX == null) // x is at head
        {
            head = _y;
        }
        else
        {
            prevX.next = _y;
        }

        if(prevY == null) // y is at head
        {
            head = _x;
        }
        else
        {
            prevY.next = _x;
        }

        LNode temp1 = _x.next;
        _x.next = _y.next;
        _y.next = temp1;
    }

    public void reverse()
    {
        LNode current = head;
        LNode prev = null;

        while(current != null)
        {
            LNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
    }

    public void reverseKNode(int k)
    {
        head = reverseKNodeUtil(head,k);
    }

    private LNode reverseKNodeUtil(LNode cHead, int k)
    {
        LNode current = cHead;
        LNode prev = null, next = null;

        int count =0;

        while(count<k && current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if(next != null)
            cHead.next = reverseKNodeUtil(next, k);

        return prev; //new head
    }


    public static LNode mergePoint(MyLinkedList l1, MyLinkedList l2)
    {
        LNode mergePoint = null, longer = null, shorter = null;
        int length1 = l1.size();
        int length2 = l2.size();

        if(length1 > length2)
        {
            longer = l1.head;
            shorter = l2.head;
        }
        else
        {
            longer = l2.head;
            shorter = l1.head;
        }

        int diff = Math.abs(length1-length2);

        while(diff-- > 0)
        {
            longer = longer.next;
        }

        while(longer != null && shorter != null)
        {
            if(longer == shorter)
            {
                mergePoint = longer;
                break;
            }

            longer = longer.next;
            shorter = shorter.next;
        }

        return mergePoint;
    }

    public int size()
    {
        return sizeInternal(head);
    }

    private int sizeInternal(LNode head)
    {
        if(head == null)
            return 0;

        return 1 + sizeInternal(head.next);
    }

    public static void main(String[] args)
    {
        MyLinkedList list = new MyLinkedList();
        list.add(1);list.add(2);list.add(3);
        list.add(4);list.add(5);list.add(6);
        list.add(7);list.add(8);list.add(9);
        list.add(10);list.add(11);list.add(12);
        list.add(13);list.add(14);list.add(15);
        list.reverseKNode(3);
        list.print();
    }
}
