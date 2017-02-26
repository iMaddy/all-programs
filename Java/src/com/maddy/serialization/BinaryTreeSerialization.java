package com.maddy.serialization;

import com.maddy.collections.tree.BinarySearchTree;

import java.io.*;

/**
 * Created by madhukar.b on 04/09/16.
 */
public class BinaryTreeSerialization
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        //serialize();
        deserialize();
    }

    private static void deserialize() throws IOException, ClassNotFoundException
    {
        ObjectInputStream io = new ObjectInputStream(new FileInputStream("f.txt"));
        BinarySearchTree bTree = (BinarySearchTree) io.readObject();
        bTree.printTree();
    }

    private static void serialize() throws IOException
    {
        BinarySearchTree bTree = new BinarySearchTree();

        bTree.addNode(30);
        bTree.addNode(20);
        bTree.addNode(15);
        bTree.addNode(25);
        bTree.addNode(40);
        bTree.addNode(35);
        bTree.addNode(45);

        bTree.printTree();

        FileOutputStream fo = new FileOutputStream("f.txt");
        ObjectOutputStream out = new ObjectOutputStream(fo);

        out.writeObject(bTree);
        out.flush();
        System.out.println("Done...");
    }


}