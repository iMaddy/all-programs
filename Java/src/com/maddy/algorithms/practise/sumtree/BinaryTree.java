package com.maddy.algorithms.practise.sumtree;

import com.maddy.util.WrapInt;

import java.util.Scanner;

// Java program to check if binary tree is subtree of another binary tree
class Node
{

    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}

class BinaryTree
{
    Node root;


    public int height()
    {
        return BinaryTree.heightInternal(root);
    }

    private static int heightInternal(Node root)
    {
        if(root == null)
            return 0;
        else
            return 1 +
                    Math.max(BinaryTree.heightInternal(root.left), BinaryTree.heightInternal(root.right));
    }

    /* print tree
 *      1
 *     / \
 *    2   3
 *   / \
 *   4  5
 */
    public void printTree()
    {
        System.out.println(printTreeInternal(root, 1, height()));
    }

    private StringBuilder printTreeInternal(Node root, int currentHeight, int totalHeight)
    {
        StringBuilder sb = new StringBuilder();
        int spaces = getSpaceCount(totalHeight - currentHeight + 1);
        if (root == null)
        {
            // create a 'spatial' block and return it
            String row = String.format("%" + (2 * spaces + 1) + "s%n", "");
            // now repeat this row space+1 times
            String block = new String(new char[spaces + 1]).replace("\0", row);
            return new StringBuilder(block);
        }
        if (currentHeight == totalHeight)
            return new StringBuilder(root.data + "");
        int slashes = getSlashCount(totalHeight - currentHeight + 1);
        sb.append(String.format("%" + (spaces + 1) + "s%" + spaces + "s", root.data + "", ""));
        sb.append("\n");
        // now print / and \
        // but make sure that left and right exists
        char leftSlash = root.left == null ? ' ' : '/';
        char rightSlash = root.right == null ? ' ' : '\\';
        int spaceInBetween = 1;
        for (int i = 0, space = spaces - 1; i < slashes; i++, space--, spaceInBetween += 2)
        {
            for (int j = 0; j < space; j++)
                sb.append(" ");
            sb.append(leftSlash);
            for (int j = 0; j < spaceInBetween; j++)
                sb.append(" ");
            sb.append(rightSlash + "");
            for (int j = 0; j < space; j++)
                sb.append(" ");
            sb.append("\n");
        }
        // sb.append("\n");

        // now get string representations of left and right subtrees
        StringBuilder leftTree = printTreeInternal(root.left, currentHeight + 1, totalHeight);
        StringBuilder rightTree = printTreeInternal(root.right, currentHeight + 1, totalHeight);
        // now line by line print the trees side by side
        Scanner leftScanner = new Scanner(leftTree.toString());
        Scanner rightScanner = new Scanner(rightTree.toString());
        // spaceInBetween+=1;
        while (leftScanner.hasNextLine())
        {
            if (currentHeight == totalHeight - 1)
            {
                sb.append(String.format("%-2s %2s", leftScanner.nextLine(), rightScanner.nextLine()));
                sb.append("\n");
                spaceInBetween -= 2;
            } else
            {
                sb.append(leftScanner.nextLine());
                sb.append(" ");
                sb.append(rightScanner.nextLine() + "\n");
            }
        }
        leftScanner.close();
        rightScanner.close();
        return sb;

    }

    private int getSpaceCount(int height)
    {
        return (int) (3 * Math.pow(2, height - 2) - 1);
    }

    private int getSlashCount(int height)
    {
        if (height <= 3)
            return height - 1;
        return (int) (3 * Math.pow(2, height - 3) - 1);
    }

    public boolean isLeafNode(Node root)
    {
        return root.left == null && root.right == null;
    }
    public boolean isSumTree(Node root)
    {
        if(root == null || isLeafNode(root))
            return true;

        if(isSumTree(root.left) && isSumTree(root.right))
        {
            int ls=0,rs=0;

            if(root.left == null)
                ls = 0;
            else if(isLeafNode(root.left))
                ls = root.left.data;
            else
                ls = 2*root.left.data;

            if(root.right == null)
                rs = 0;
            else if(isLeafNode(root.right))
                rs = root.right.data;
            else
                rs = 2*root.right.data;

            if(root.data == ls + rs)
                return true;
        }

        return false;
    }


    //Driver program to test above functions
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();

        tree.root = new Node(62);

        tree.root.left = new Node(7);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(1);
        tree.root.left.right.left = new Node(4);
        tree.root.left.right.right = new Node(-3);

        tree.root.right = new Node(24);
        tree.root.right.right = new Node(12);
        tree.root.right.right.left = new Node(6);
        tree.root.right.right.left.left = new Node(3);
        tree.root.right.right.left.right = new Node(3);

//        tree.root = new Node(26);
//        tree.root.left = new Node(10);
//        tree.root.left.left = new Node(4);
//        tree.root.left.right = new Node(6);
//        tree.root.right = new Node(3);
//        tree.root.right.right = new Node(3);


        tree.printTree();
        System.out.println(tree.isSumTree(tree.root));
    }
}