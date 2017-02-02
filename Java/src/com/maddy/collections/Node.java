package com.maddy.collections;

/**
 * Created by madhukar.b on 07/08/16.
 */
public class Node
{
    public int key;
    public Node left;
    public Node right;

    public Node(int key)
    {
        this.key = key;
        this.right = null;
        this.left = null;
    }

    public int getKey()
    {
        return key;
    }

    public Node leftChild()
    {
        return left;
    }

    public Node rightChild()
    {
        return right;
    }

    public void setLeftChild(Node node)
    {
        left = node;
    }

    public void setRightChild(Node node)
    {
        right = node;
    }

    @Override
    public String toString()
    {
        return String.valueOf(key);
    }
}
