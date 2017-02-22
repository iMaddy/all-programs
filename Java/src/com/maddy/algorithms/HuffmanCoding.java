package com.maddy.algorithms;

import java.util.Hashtable;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by gitanjali on 22/02/17.
 */
public class HuffmanCoding
{
    public class MinHeapNode implements Comparable
    {
        public char data;
        public int frequency;
        public MinHeapNode left, right;

        public MinHeapNode(char ch, int f)
        {
            data = ch;
            frequency = f;
            left = right = null;
        }

        @Override
        public int compareTo(Object obj)
        {
            return this.frequency - ((MinHeapNode) obj).frequency;
        }
    }

    PriorityQueue<MinHeapNode> minHeap;

    public HuffmanCoding()
    {
        minHeap = new PriorityQueue<>();
    }

    public void add(char ch, int frequency)
    {
        minHeap.add(new MinHeapNode(ch,frequency));
    }

    /*
    * returns set with two maps
    * 1. map of char to huffman code
    * 2. map of huffman code to char
     */
    public Map<String,String> buildHuffmanTree()
    {

        while(minHeap.size() > 1)
        {
            MinHeapNode left = minHeap.poll();
            MinHeapNode right = minHeap.poll();

            MinHeapNode node = new MinHeapNode('$',left.frequency+right.frequency);
            node.left = left;
            node.right = right;

            minHeap.add(node);
        }

        Map<String, String> charToCode = new Hashtable<>();
        HuffmanCoding.generateCodes(minHeap.peek(),charToCode,"");
        
        return charToCode;
    }

    private static void generateCodes(MinHeapNode root, Map<String, String> charToCode, String str)
    {
        if(root == null)
            return;

        if(root.data != '$')
            charToCode.put(""+root.data, str);

        generateCodes(root.left, charToCode,str+"0");
        generateCodes(root.right, charToCode,str+"1");
    }

    public static void main(String[] args)
    {
        /*
        char arr[] = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int freq[] = { 5, 9, 12, 13, 16, 45 };
         */
        HuffmanCoding huffmanCoding = new HuffmanCoding();

        huffmanCoding.add('a',5);
        huffmanCoding.add('b',9);
        huffmanCoding.add('c',12);
        huffmanCoding.add('d',13);
        huffmanCoding.add('e',16);
        huffmanCoding.add('f',45);

        System.out.println(huffmanCoding.buildHuffmanTree());
        
        
    }
}
