package com.maddy.test;

import com.maddy.collections.BinaryTree;

/**
 * Created by madhukar.b on 07/08/16.
 */
public class TestClass
{
    public static void main(String[] args)
    {
        BinaryTree bTree = new BinaryTree();
        bTree.addNode(20);
        bTree.addNode(9);
        bTree.addNode(8);
        bTree.addNode(9);
        bTree.addNode(11);
        bTree.addNode(6);
        bTree.addNode(5);
        bTree.addNode(12);
        bTree.addNode(512);
        bTree.addNode(511);
        bTree.addNode(513);
        bTree.addNode(515);

        bTree.inOrderTraversal();
        
        System.out.println(bTree.height()+"\n");
        
        bTree.printTreeRotated();
        System.out.println("\n"+bTree.isBalanced());
    }
}