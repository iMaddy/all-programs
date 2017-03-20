package com.maddy.collections.tree;

import com.maddy.collections.Node;
import com.maddy.util.UtilBox;
import com.maddy.util.WrapInt;

import java.io.Serializable;
import java.util.*;

/**
 * Created by madhukar.b on 07/08/16.
 */
class Height
{
    int height = 0;
}

class CustomNode
{
    Node node;
    int hd;
    public CustomNode(Node n, int h)
    {
        node = n;
        hd = h;
    }
}
public class BinarySearchTree implements Serializable
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

    /*
     *  comlexity:
     *  time: O(h) - height of the tree, for balanced tree is less than O(log n)
     *               for skewed tree it is O(n) - worst case
     */
    public void delete(int key)
    {
        root = deleteInternal(root, key);
    }

    private Node deleteInternal(Node root, int key)
    {
        if(root == null)
            return null;

        if(key < root.key)
        {
            root.left = deleteInternal(root.left, key);
        }
        else if(key > root.key)
        {
            root.right = deleteInternal(root.right, key);
        }
        else //matched key
        {
            if(root.left == null)
            {
                return root.right;
            }
            else if(root.right == null)
            {
                return root.left;
            }

            // replace value with min value in right sub tree (i.e. inorder successor)
            root.key = minValue(root.right);

            // delete inorder successor
            root.right = deleteInternal(root.right, root.key);
        }

        return root;
    }

    private int minValue(Node root)
    {
        if(root == null)
            return Integer.MIN_VALUE;

        int minVal = root.key;

        while(root.left != null)
        {
            minVal = root.left.key;
            root = root.left;
        }

        return minVal;
    }

    public void inOrderTraversal()
    {
        inOrderTraversalInternal(root);
        System.out.println();
    }

    public void preOrderTraversal()
    {
        preOrderTraversalInternal(root);
        System.out.println();
    }

    public void postOrderTraversal()
    {
        postOrderTraversalInternal(root);
        System.out.println();
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
     * Inorder traversal without using extra memory or function stack
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
			    /* Find the inorder predecessor of current */
				Node pre = current.left;

				while(pre.right != null && pre.right != current /* this condition where thread pointing to inorder predecessor*/)
				{
					pre = pre.right;
				}

				if(pre.right == null) //use this unused thread to point inorder predecessor
                {
                    pre.right = current;
                    current = current.left;
                }
                else // this is condition where we reached inorder predecessor of 'pre' i.e. pre.right != current
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
    
    private static int heightInternal(Node root)
    {
    	if(root == null)
    		return 0;
    	else
    		return 1 + 
    				Math.max(BinarySearchTree.heightInternal(root.left), BinarySearchTree.heightInternal(root.right));
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

        Node tNode = new Node((int) postOrder.get(postIndex.n--));

        if(inStart == inEnd)
            return tNode;

        int indexInOrder = UtilBox.find(inOrder,tNode.key);

        tNode.right = constructTreeFromInOrderAndPostOrderInternal(inOrder, postOrder, postIndex, indexInOrder + 1, inEnd);
        tNode.left = constructTreeFromInOrderAndPostOrderInternal(inOrder, postOrder, postIndex, inStart, indexInOrder - 1);

        return tNode;
    }

    public void printAncestors(int key)
    {
        printAncestorsInternal(root, key);
    }

    private boolean printAncestorsInternal(Node root, int key)
    {
        if(root == null)
            return false;

        if(root.key == key)
            return true;

        if(printAncestorsInternal(root.left, key) || printAncestorsInternal(root.right, key))
        {
            System.out.print(root.key + " ");
            return true;
        }

        return false;
    }

    /*
     * complexity: O(n)
     */
    public boolean isBST()
    {
        Node prev = null;
        return isBSTInternal(root, prev);
    }

    private static boolean isBSTInternal(Node root, Node prev)
    {
        if(root == null)
            return true;

        if(!isBSTInternal(root.left,prev))
            return false;

        if(prev != null && prev.key > root.key)
            return false;
        prev = root;

        return isBSTInternal(root.right,prev);

    }


    private void leftViewUtil(Node node, int level, WrapInt max_level)
    {
        // Base Case
        if (node==null) return;

        // If this is the first node of its level
        if (max_level.n < level)
        {
            System.out.print(" " + node.key);
            max_level.n = level;
        }

        // Recur for left and right subtrees
        leftViewUtil(node.left, level+1, max_level);
        leftViewUtil(node.right, level+1, max_level);
    }

    // A wrapper over leftViewUtil()
    public void leftView()
    {
        leftViewUtil(root, 1, new WrapInt(0));
        System.out.println();
    }

    public void rightView()
    {
        rightViewUtil(root, 1, new WrapInt(0));
        System.out.println();
    }

    private void rightViewUtil(Node node, int level, WrapInt max_level)
    {
        // Base Case
        if (node==null) return;

        // If this is the first node of its level
        if (max_level.n < level)
        {
            System.out.print(" " + node.key);
            max_level.n = level;
        }

        // Recur for right and left subtrees
        rightViewUtil(node.right, level+1, max_level);
        rightViewUtil(node.left, level+1, max_level);
    }

    public void topView()
    {
        if(root == null)
            return;
        Map<Integer, Integer> map = new Hashtable<>();
        Queue<CustomNode> queue = new LinkedList<>();
        queue.add(new CustomNode(root,0));
        int minHd =0;
        int maxHd =0;
        while (!queue.isEmpty())
        {
            CustomNode cNode = queue.poll();
            Node node = cNode.node;
            int hd = cNode.hd;

            if(map.get((Integer)hd) == null)
            {
                map.put(hd, node.key);
            }

            if(minHd > hd) minHd = hd;
            if(maxHd < hd) maxHd = hd;

            if(node.left != null)
                queue.add(new CustomNode(node.left, hd-1));

            if(node.right != null)
                queue.add(new CustomNode(node.right, hd+1));
        }

        for(int i=minHd; i<=maxHd; i++)
        {
            System.out.print(map.get(i) + " ");
        }
        System.out.println();
    }

    public void bottomView()
    {
        if(root == null)
            return;
        Map<Integer, Integer> map = new Hashtable<>();
        Queue<CustomNode> queue = new LinkedList<>();
        queue.add(new CustomNode(root,0));
        int minHd =0;
        int maxHd =0;
        while (!queue.isEmpty())
        {
            CustomNode cNode = queue.poll();
            Node node = cNode.node;
            int hd = cNode.hd;

            map.put(hd, node.key);

            if(minHd > hd) minHd = hd;
            if(maxHd < hd) maxHd = hd;

            if(node.right != null)
                queue.add(new CustomNode(node.right, hd+1));

            if(node.left != null)
                queue.add(new CustomNode(node.left, hd-1));
        }

        for(int i=minHd; i<=maxHd; i++)
        {
            System.out.print(map.get(i) + " ");
        }
        System.out.println();
    }

    public void kthDistanceFromLeaf(int k)
    {
        kthDistanceFromLeafUtil(root,new Height(),k);
    }

    private void kthDistanceFromLeafUtil(Node root, Height h, int k)
    {
        if(root == null)
        {
            h.height =0;
            return;
        }

        Height lh = new Height();
        Height rh = new Height();

        kthDistanceFromLeafUtil(root.left, lh, k);
        kthDistanceFromLeafUtil(root.right, rh, k);

        h.height = 1 + Math.max(lh.height, rh.height);

        if(k == lh.height || k == rh.height)
        {
            System.out.print(root.key +" ");
        }
    }

    public int distanceBetweenNode(int n1, int n2)
    {
        //assumption nodes are present in tree
        return distanceBetweenNodeUtil(root, n1, n2,0);
    }

    public int distanceBetweenNodeUtil(Node root, int n1, int n2, int level)
    {
        if(root == null)
            return -1;

        if(root.key == n1 || root.key == n2)
        {
            return level;
        }

        int leftLevel = distanceBetweenNodeUtil(root.left, n1,n2,level+1);
        int rightLevel = distanceBetweenNodeUtil(root.right, n1,n2,level+1);

        if(leftLevel!=-1 && rightLevel!=-1)
        {
            return leftLevel + rightLevel;
        }

        if(leftLevel != -1)
            return leftLevel;
        else
            return rightLevel;
    }

    public int nodesInRange(int min, int max)
    {
        return nodesInRange(root,min, max);
    }

    private int nodesInRange(Node root, int min, int max)
    {
        if(min > max)
            return -1;

        if(root == null)
            return 0;

        if(max < root.key)
            return nodesInRange(root.left,min,max);
        else if(min > root.key)
            return nodesInRange(root.right, min,max);
        else
        {
            return nodesInRange(root.left,min,root.key) +
                    nodesInRange(root.right,root.key,max) + 1;
        }
    }

    public static void main(String[] args)
    {
        BinarySearchTree bTree = new BinarySearchTree();
//        bTree.addNode(20);
//        bTree.addNode(12);
//        bTree.addNode(5);
//        bTree.addNode(9);
//        bTree.addNode(13);
//        bTree.addNode(19);
//        bTree.addNode(1);
//        bTree.addNode(3);
//        bTree.addNode(27);
//        bTree.addNode(23);
//        bTree.addNode(30);
//        bTree.addNode(31);
//        bTree.addNode(21);
//        bTree.addNode(21);
//        bTree.addNode(32);
//        bTree.addNode(33);

        bTree.addNode(5);
        bTree.addNode(3);
        bTree.addNode(2);
        bTree.addNode(4);
        bTree.addNode(9);
        bTree.addNode(10);
        bTree.addNode(7);
        bTree.addNode(8);


        bTree.printTree();
//        bTree.kthDistanceFromLeaf(2);
//        System.out.println(bTree.distanceBetweenNode(3,21));
        System.out.println(bTree.nodesInRange(0,1));
    }
}

