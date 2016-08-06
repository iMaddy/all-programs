package com.maddy.binarytree;

/**
 * Created by madhukar.b on 07/08/16.
 */
public class BinaryTree
{
    private Node root;

    private static void inOrderTraversalInternal(Node root)
    {
        if (null == root)
            return;

        inOrderTraversalInternal(root.leftChild());
        System.out.println(root);
        inOrderTraversalInternal(root.rightChild());
    }

    private static void preOrderTraversalInternal(Node root)
    {
        if (null == root)
            return;

        System.out.println(root);
        preOrderTraversalInternal(root.leftChild());
        preOrderTraversalInternal(root.rightChild());
    }

    private static void postOrderTraversalInternal(Node root)
    {
        if (null == root)
            return;

        postOrderTraversalInternal(root.leftChild());
        postOrderTraversalInternal(root.rightChild());
        System.out.println(root);
    }

    private static Node findInternal(int key, Node root)
    {
        if (null == root)
        {
            return root;
        }

        if (key == root.getKey())
        {
            return root;
        } else if (key < root.getKey())
        {
            return findInternal(key, root.leftChild());
        } else
        {
            return findInternal(key, root.rightChild());
        }
    }

    public void addNode(int key)
    {
        if (null == root)
        {
            root = new Node(key);
            return;
        }
        addNodeInternal(key, root);
    }

    private void addNodeInternal(int key, Node root)
    {
        if (key <= root.getKey())
        {
            if(null == root.leftChild())
            {
                root.setLeftChild(new Node(key));
                return;
            }
            addNodeInternal(key, root.leftChild());
        } else
        {
            if(null == root.rightChild())
            {
                root.setRightChild(new Node(key));
                return;
            }
            addNodeInternal(key, root.rightChild());
        }
    }

    public void inOrderTraversal()
    {
        inOrderTraversalInternal(root);
    }

    public void preOrderTraversal()
    {
        preOrderTraversalInternal(root);
    }

    public void postOrderTraversal()
    {
        postOrderTraversalInternal(root);
    }

    /*
    @return: returns node with key if key is present, else returns null
     */
    public Node find(int key)
    {
        return findInternal(key, root);
    }
}
