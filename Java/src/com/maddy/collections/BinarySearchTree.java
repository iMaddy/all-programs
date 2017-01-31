package com.maddy.collections;

import com.maddy.util.UtilBox;
import com.maddy.util.WrapInt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by madhukar.b on 07/08/16.
 */
class Height
{
    int height = 0;
}

public class BinarySearchTree
{
    private Node root;

    public BinarySearchTree(Node root)
    {
        this.root = root;
    }

    public BinarySearchTree()
    {
        this.root = null;
    }

    private static void inOrderTraversalInternal(Node root)
    {
        if (null == root)
            return;

        inOrderTraversalInternal(root.leftChild());
        System.out.print(root + " ");
        inOrderTraversalInternal(root.rightChild());
    }

    private static void preOrderTraversalInternal(Node root)
    {
        if (null == root)
            return;

        System.out.print(root + " ");
        preOrderTraversalInternal(root.leftChild());
        preOrderTraversalInternal(root.rightChild());
    }

    private static void postOrderTraversalInternal(Node root)
    {
        if (null == root)
            return;

        postOrderTraversalInternal(root.leftChild());
        postOrderTraversalInternal(root.rightChild());
        System.out.print(root + " ");
    }

    private static Node findInternal(int key, Node root)
    {
        if (null == root)
        {
            return null;
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

    public void levelOrderTraversal() 
    {
    	Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) 
        {
            Node tempNode = queue.poll();
            System.out.print(tempNode.key + " ");
 
            /*Enqueue left child */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
 
            /*Enqueue right child */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

    /*
     * Inorder traversal without using extra memory or function stack using function stack
     * complexity - time O(n), space - O(1)
     */
    public void morrisTraversal()
	{
		Node current = root;
		while(current != null)
		{
			if(current.left == null)
			{
				System.out.print(current.key + " ");
				current = current.right;
			}
			else
			{
				Node pre = current.left;

				while(pre.right != null && pre.right != current /* this condition where thread pointing to preorder successor*/)
				{
					pre = pre.right;
				}

				if(pre.right == null) //use this unused thread to point preorder successor
                {
                    pre.right = current;
                    current = current.left;
                }
                else // this is condition where we reached preorder sucessor of 'pre' i.e. pre.right != current
                {
                    pre.right = null; //revert the links to restore tree to thread free structure
                    System.out.print(current.key + " ");
                    current = current.right;
                }
			}
		}
	}
    /*
    @return: returns node with key if key is present, else returns null
     * complexity: 
     */
    public Node find(int key)
    {
        return findInternal(key, root);
    }

    /*
     * complexity: time - O(n), space - O(n) - function stack
     */
    public int height()
    {
    	return BinarySearchTree.heightInternal(root);
    }
    
    private static int heightInternal(Node lRoot)
    {
    	if(lRoot == null)
    		return 0;
    	else
    		return 1 + 
    				Math.max(BinarySearchTree.heightInternal(lRoot.left), BinarySearchTree.heightInternal(lRoot.right));
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
			return new StringBuilder(root.key + "");
		int slashes = getSlashCount(totalHeight - currentHeight + 1);
		sb.append(String.format("%" + (spaces + 1) + "s%" + spaces + "s", root.key + "", ""));
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

	/* print tree (rotated -90 degree)
	 *  1 --- 3
	 *   |--- 2--- 5
	 *        |--- 4
	 */
	public void printTreeRotated()
	{
		BinarySearchTree.printTreeRotatedInternal(root, 1);
	}
	
	private static void printTreeRotatedInternal(Node root, int level)
	{
		if (root == null)
			return;
		printTreeRotatedInternal(root.right, level + 1);
		if (level != 0)
		{
			for (int i = 0; i < level - 1; i++)
				System.out.print("|\t");
			System.out.println("|-------" + root.key);
		} 
		else
			System.out.println(root.key);
		
		printTreeRotatedInternal(root.left, level + 1);
	}

	public boolean isBalanced()
	{
		return isBalancedInternal(root,new Height());
	}

	/*
	 * complexity: time - O(n) space - O(n) - function call stack
	 */
	private boolean isBalancedInternal(Node root, Height h)
	{
		if(root == null)
		{
			h.height = 0;
			return true;
		}
		
		Height lh = new Height();
		Height rh = new Height();
		
		boolean l = isBalancedInternal(root.left, lh);
		boolean r = isBalancedInternal(root.right, rh);
		
		h.height = (lh.height > rh.height ? lh.height:rh.height) + 1;
		
		if(Math.abs(lh.height-rh.height) > 1)
			return false;
		
		return l&&r;
	}

	public int diameter()
	{
		return diameterInternal(root, new Height());
	}

	private int diameterInternal(Node root, Height h)
	{
		if(root == null)
		{
			h.height = 0;
			return 0; // diameter is zero for null node
		}
		
		Height lh = new Height();
		Height rh = new Height();
		
		int ld = diameterInternal(root.left, lh);
		int rd = diameterInternal(root.right, rh);
		
		h.height = Math.max(lh.height, rh.height) + 1;
		
		return Math.max(lh.height+rh.height+1, Math.max(ld, rd));
	}

	public static BinarySearchTree constructTreeFromInOrderAndPostOrder(ArrayList<Integer> inOrder, ArrayList<Integer> postOrder)
    {
        Node tNode = constructTreeFromInOrderAndPostOrderInternal(inOrder, postOrder, new WrapInt(postOrder.size()-1), 0, inOrder.size()-1);
        return new BinarySearchTree(tNode);
    }

    private static Node constructTreeFromInOrderAndPostOrderInternal(ArrayList<Integer> inOrder, ArrayList<Integer> postOrder, WrapInt postIndex, int inStart, int inEnd)
    {
        if(inStart > inEnd)
            return null;

        Node tNode = new Node((int) postOrder.get(postIndex.getValueAndDecreament()));

        if(inStart == inEnd)
            return tNode;

        int indexInOrder = UtilBox.find(inOrder,tNode.key);

        tNode.right = constructTreeFromInOrderAndPostOrderInternal(inOrder, postOrder, postIndex, indexInOrder + 1, inEnd);
        tNode.left = constructTreeFromInOrderAndPostOrderInternal(inOrder, postOrder, postIndex, inStart, indexInOrder - 1);

        return tNode;
    }

    /*
    IN - 123456
    PR - 421365
    PO - 132564

         4
       /   \
     /      \
    2         6
   / \        /
 /    \     /
1      3  5


     */
}
