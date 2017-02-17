package com.maddy.collections.tree;

import com.maddy.collections.Node;

/**
 * Created by gitanjali on 05/02/17.
 */
public class BinaryTree
{
    public Node root;

    public BinaryTree()
    {
        root = null;
    }

    public void toBST()
    {
        toBSTInternal(root);
    }

    public void inOrder()
    {
        inOrder(root);
        System.out.println("\n");
    }

    private void inOrder(Node root)
    {
        if(root == null)
            return;

        inOrder(root.left);
        System.out.println(root.key);
        inOrder(root.right);
    }

    private void toBSTInternal(Node root)
    {
        if(root == null)
            return;

        if(root.left == null && root.right == null)
            return;

        if(root.left != null)
        {
            int rootKey = root.key;
            root.key = root.left.key <= root.key ? root.key : root.left.key;

            if(rootKey != root.key) //keys are swapped
                root.left.key = rootKey;
        }

        if(root.right != null)
        {
            int rootKey = root.key;
            root.key = root.right.key > root.key ? root.key : root.right.key;

            if(rootKey != root.key) //keys are swapped
                root.right.key = rootKey;
        }

        toBSTInternal(root.left);
        toBSTInternal(root.right);
    }
}
