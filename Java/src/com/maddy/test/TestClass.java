package com.maddy.test;

import com.maddy.collections.BinarySearchTree;
import com.maddy.collections.BinaryTree;

import java.util.ArrayList;

/**
 * Created by madhukar.b on 07/08/16.
 */
public class TestClass
{
    public static void main(String[] args)
    {
        BinarySearchTreeTest();
    }

    private static void BinarySearchTreeTest()
    {
        BinarySearchTree bTree = new BinarySearchTree();
        bTree.addNode(4);
        bTree.addNode(2);
        bTree.addNode(1);
        bTree.addNode(3);
        bTree.addNode(6);
        bTree.addNode(5);

//        bTree.inOrderTraversal();
//        System.out.println();
//        bTree.postOrderTraversal();
//        System.out.println();
        bTree.printTreeRotated();

//        ArrayList<Integer> inOrder = new ArrayList<>();
//        inOrder.add(1);
//        inOrder.add(2);
//        inOrder.add(3);
//        inOrder.add(4);
//        inOrder.add(5);
//        inOrder.add(6);
//
//        ArrayList<Integer> postOrder = new ArrayList<>();
//        postOrder.add(1);
//        postOrder.add(3);
//        postOrder.add(2);
//        postOrder.add(5);
//        postOrder.add(6);
//        postOrder.add(4);
//
//        System.out.println("\n");
//        BinarySearchTree constructedTree = BinarySearchTree.constructTreeFromInOrderAndPostOrder(inOrder,postOrder);
//        if(constructedTree != null)
//            constructedTree.printTreeRotated();
//
//
//        bTree.printAncestors(3);
//        System.out.println();
//        bTree.printAncestors(5);
//        System.out.println();
//        bTree.printAncestors(6);
//        System.out.println();
//        bTree.printAncestors(4);
//        System.out.println();
//        bTree.printAncestors(-1);
//        System.out.println();

//        bTree.delete(10);
//        System.out.println();
//        bTree.printTreeRotated();

//        bTree.root.right.right = new Node(10);
//        bTree.root.right.right.left = new Node(3);
//        bTree.root.right.right.right = new Node(11);
//        System.out.println("\n");
//        bTree.printTreeRotated();
//        System.out.println(bTree.isBST());


        BinaryTree tree = new BinaryTree();

        /*
         */
    }
}