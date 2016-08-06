package com.maddy.binarytree;/**
 * Created by madhukar.b on 07/08/16.
 */
public class TestClass
{
    public static void main(String[] args)
    {
        BinaryTree bTree = new BinaryTree();
        bTree.addNode(5);
        bTree.addNode(512);
        bTree.addNode(15);
        bTree.addNode(35);
        bTree.addNode(53);
        bTree.addNode(1);
        bTree.addNode(3);
        bTree.addNode(121);

        bTree.inOrderTraversal();

        Node node = bTree.find(121);
        if(null != node)
        {
            System.out.print(node);
            System.out.println(" Key found in tree");
        }
        else
        {
            System.out.println("Key does not found in tree");
        }

        node = bTree.find(12331);
        if(null != node)
        {
            System.out.print(node);
            System.out.println(" Key found in tree");
        }
        else
        {
            System.out.println("Key does not found in tree");
        }


    }
}
