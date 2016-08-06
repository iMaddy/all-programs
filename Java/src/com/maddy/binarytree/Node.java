package com.maddy.binarytree;

/**
 * Created by madhukar.b on 07/08/16.
 */
public class Node
{
    private int key;
    private Node leftChild;
    private Node rightChild;

    Node(int key)
    {
        this.key = key;
        this.rightChild = null;
        this.leftChild = null;
    }

    public int getKey()
    {
        return key;
    }

    public Node leftChild()
    {
        return leftChild;
    }

    public Node rightChild()
    {
        return rightChild;
    }

    public void setLeftChild(Node node)
    {
        leftChild = node;
    }

    public void setRightChild(Node node)
    {
        rightChild = node;
    }

    @Override
    public String toString()
    {
        return String.valueOf(key);
    }
}
