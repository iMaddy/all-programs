package com.maddy.test;

import com.maddy.collections.tree.BinarySearchTree;

import java.io.*;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by madhukar.b on 04/09/16.
 */
public class Test
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        //serialize();
//        deserialize();
        System.out.println(Thread.currentThread().getName());
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            String str = sc.next();
            String substr = sc.next();
            if(str.equalsIgnoreCase("break"))
                break;

            Test.printAnagramIndex(str,substr);
        }
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

    public static void printAnagramIndex(String str, String substr)
    {
        int len = str.length();
        int sublen = substr.length();

        if(len<sublen)
            return;

        Map<String,Integer> map = new Hashtable<>(sublen);

        for(int i=0; i<sublen; i++)
        {
            map.put(String.valueOf(substr.charAt(i)),-1);
        }

        for(int i=0; i<len; i++)
        {
            boolean isAnagram = true;
            for(int j=i; j<i+sublen; j++)
            {
                if(j>len-1) // overflow
                {
                    isAnagram = false;
                    break;
                }

                if(map.get(String.valueOf(str.charAt(j))) != null && map.get(String.valueOf(str.charAt(j))) < i)
                {
                    map.put(String.valueOf(str.charAt(j)),i);
                }
                else
                {
                    isAnagram = false;
                    break;
                }
            }

            if(isAnagram)
                System.out.print(i+", ");
        }
        System.out.println("Done...!!");
    }

}
