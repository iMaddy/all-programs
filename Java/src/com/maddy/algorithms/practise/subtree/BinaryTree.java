package com.maddy.algorithms.practise.subtree;

import com.maddy.util.WrapInt;

// Java program to check if binary tree is subtree of another binary tree
class Node {

    char data;
    Node left, right;

    Node(char item) {
        data = item;
        left = right = null;
    }
}

class StringWrap
{
    String str = "";

    public void addChar(char ch)
    {
        str = str + ch;
    }
}
class BinaryTree {

    static Node root;

    String strstr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return null;
        }
        int hLength = haystack.length();
        int nLength = needle.length();
        if (hLength < nLength) {
            return null;
        }
        if (nLength == 0) {
            return haystack;
        }
        for (int i = 0; i <= hLength - nLength; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                int j = 0;
                for (; j < nLength; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                }
                if (j == nLength) {
                    return haystack.substring(i);
                }
            }
        }
        return null;
    }

    // A utility function to store inorder traversal of tree rooted
    // with root in an array arr[]. Note that i is passed as reference
    void storeInorder(Node node, StringWrap str) {
        if (node == null) {
            return;
        }
        storeInorder(node.left, str);
        str.addChar(node.data);
        storeInorder(node.right, str);
    }

    // A utility function to store preorder traversal of tree rooted
    // with root in an array arr[]. Note that i is passed as reference
    void storePreOrder(Node node, StringWrap str) {
        if (node == null) {
            return;
        }
        str.addChar(node.data);
        storePreOrder(node.left, str);
        storePreOrder(node.right, str);
    }

    /* This function returns true if S is a subtree of T, otherwise false */
    boolean isSubtree(Node T, Node S) {
        /* base cases */
        if (S == null) {
            return true;
        }
        if (T == null) {
            return false;
        }

        // Store Inorder traversals of T and S in inT[0..m-1]
        // and inS[0..n-1] respectively
        StringWrap op1 = new StringWrap();
        StringWrap op2 = new StringWrap();
        storeInorder(T, op1);
        storeInorder(S, op2);

        // If inS[] is not a substring of preS[], return false
        if (!op1.str.contains(op2.str)) {
            return false;
        }

        // Store Preorder traversals of T and S in inT[0..m-1]
        // and inS[0..n-1] respectively
        StringWrap op3 = new StringWrap();
        StringWrap op4 = new StringWrap();
        storePreOrder(T, op3);
        storePreOrder(S, op4);

        // If inS[] is not a substring of preS[], return false
        // Else return true
        return op3.str.contains(op4.str);
    }

    public boolean duplicateSubtree(Node root)
    {
        if(root == null)
            return false;

        if(root.left == null || root.right == null)
            return false;

        if(isSubtree(root.left, root.right) || isSubtree(root.right, root.left))
            return true;

        if(duplicateSubtree(root.left) || duplicateSubtree(root.right))
            return true;

        return false;
    }

    //Driver program to test above functions
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();
        Node T = new Node('e');
        T.left = new Node('a');
        T.left.left = new Node('b');
        T.left.right = new Node('d');
        T.left.left.left = new Node('c');
//        T.left.right.right = new Node('e');

        Node S = new Node('a');
        S.left = new Node('b');
        S.right = new Node('d');
        S.left.left = new Node('c');

        if (tree.isSubtree(T, S)) {
            System.out.println("Yes , S is a subtree of T");
        } else {
            System.out.println("No, S is not a subtree of T");
        }


        T.right = new Node('c');
        T.right.left = S;

        if (tree.duplicateSubtree(T)) {
            System.out.println("found");
        } else {
            System.out.println("not found");
        }
    }
}