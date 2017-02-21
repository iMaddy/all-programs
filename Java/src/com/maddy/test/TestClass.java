package com.maddy.test;

import com.maddy.collections.DisjointUnionSets;
import com.maddy.collections.graph.*;
import com.maddy.collections.graph.factory.*;
import com.maddy.collections.tree.BinarySearchTree;
import com.maddy.collections.tree.BinaryTree;
import com.maddy.exceptions.InvalidInputException;
import com.maddy.exceptions.TypeValidationException;

/**
 * Created by madhukar.b on 07/08/16.
 */
public class TestClass
{
    public static void main(String[] args) throws InvalidInputException
    {
        //BinarySearchTreeTest();
        //DirecteGraphTest();
        //UndirectedGraphTest();
        DisjointSetTest();
    }

    private static void DisjointSetTest() throws InvalidInputException
    {
        DisjointUnionSets ds = new DisjointUnionSets(5);
        printDisjointSet(ds);

        ds.union(0, 1);
        printDisjointSet(ds);

        ds.union(4, 3);
        printDisjointSet(ds);

        ds.union(1, 2);
        printDisjointSet(ds);

        ds.union(0, 4);
        printDisjointSet(ds);
    }


    private static void printDisjointSet(DisjointUnionSets ds) throws InvalidInputException
    {
        for (int i=0; i<5; i++)
            System.out.print(ds.find(i) + " ");

        System.out.println();
    }

    private static void DirecteGraphTest()
    {
        AbstractGraphFactory graphFactory =
                new AdjListDirectedGraphFactory();

        Graph graph = graphFactory.createGraph(6);
//        graph.addEdge(0, 1);
//        graph.addEdge(0, 4);
//        graph.addEdge(1, 2);
//        graph.addEdge(1, 3);
//        graph.addEdge(1, 4);
//        graph.addEdge(2, 3);
//        graph.addEdge(3, 4);
//        graph.addEdge(3, 0);

        graph.addEdge(5,0,-1);
        graph.addEdge(5,2, 3);
        graph.addEdge(4,1, 4);
        graph.addEdge(4,0, 5);
        graph.addEdge(2,3, -2);
        graph.addEdge(3,1,2);
        graph.addEdge(1,0,2);
        graph.addEdge(5,4,10);

        // print the adjacency list representation of the above graph
        //graph.printGraph();
        //graph.BSF(0);
        //graph.DSF(3);
        System.out.println(graph.isCyclic());
        try
        {
            int[] result = graph.topologicalSorting();
            for(int item: result)
                System.out.print(item + " ");

        } catch (TypeValidationException e)
        {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }

        System.out.println();

        try
        {
            int[] result = graph.longestDistanceFromSource(5);
            for(int i=0; i<result.length; i++)
                System.out.print("["+i+"]="+result[i] + " ");

        } catch (TypeValidationException e)
        {
            System.out.println(e.getMessage());
            //e.printStackTrace();
        }

        System.out.println();
    }

    private static void BinarySearchTreeTest()
    {
        BinarySearchTree bTree = new BinarySearchTree();
        bTree.addNode(4);
        bTree.addNode(2);
        bTree.addNode(1);
        bTree.addNode(3);
        bTree.addNode(6);
        bTree.addNode(5);

//        bTree.inOrderTraversal();
//        System.out.println();
//        bTree.postOrderTraversal();
//        System.out.println();
        bTree.printTreeRotated();

//        ArrayList<Integer> inOrder = new ArrayList<>();
//        inOrder.add(1);
//        inOrder.add(2);
//        inOrder.add(3);
//        inOrder.add(4);
//        inOrder.add(5);
//        inOrder.add(6);
//
//        ArrayList<Integer> postOrder = new ArrayList<>();
//        postOrder.add(1);
//        postOrder.add(3);
//        postOrder.add(2);
//        postOrder.add(5);
//        postOrder.add(6);
//        postOrder.add(4);
//
//        System.out.println("\n");
//        BinarySearchTree constructedTree = BinarySearchTree.constructTreeFromInOrderAndPostOrder(inOrder,postOrder);
//        if(constructedTree != null)
//            constructedTree.printTreeRotated();
//
//
//        bTree.printAncestors(3);
//        System.out.println();
//        bTree.printAncestors(5);
//        System.out.println();
//        bTree.printAncestors(6);
//        System.out.println();
//        bTree.printAncestors(4);
//        System.out.println();
//        bTree.printAncestors(-1);
//        System.out.println();

//        bTree.delete(10);
//        System.out.println();
//        bTree.printTreeRotated();

//        bTree.root.right.right = new Node(10);
//        bTree.root.right.right.left = new Node(3);
//        bTree.root.right.right.right = new Node(11);
//        System.out.println("\n");
//        bTree.printTreeRotated();
//        System.out.println(bTree.isBST());


        BinaryTree tree = new BinaryTree();

        /*
         */
    }

    private static void UndirectedGraphTest()
    {
        AbstractGraphFactory graphFactory =
                new AdjListUndirectedGraphFactory();

        Graph graph = graphFactory.createGraph(5);


        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(0,4);
        graph.addEdge(4,3);

//        graph.addEdge(0,3);

        System.out.println(graph.isCyclic());

    }
}