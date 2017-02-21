package com.maddy.algorithms.graphalgorithm;

import com.maddy.collections.DisjointUnionSets;
import com.maddy.exceptions.InvalidInputException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by gitanjali on 21/02/17.
 */
public class UndirectedGraph
{
    public class Edge implements Comparable
    {
        public int src;
        public int dest;
        public int weight;

        public Edge(int s, int d)
        {
            src = s;
            dest = d;
            weight = 1;
        }

        public Edge(int s, int d, int w)
        {
            src = s;
            dest = d;
            weight = w;
        }

        @Override
        public int compareTo(Object obj)
        {
            return this.weight - ((Edge)obj).weight;
        }
    }

    int V;
    ArrayList<Edge> edges;

    public UndirectedGraph(int v)
    {
        V = v;
        edges = new ArrayList<>(V-1);
    }

    public void addEdge(int src, int dest) throws InvalidInputException
    {
        if(src > V-1 || dest > V-1)
            throw new InvalidInputException("vertex value is beyond capacity");
        Edge e = new Edge(src,dest);

        edges.add(e);
    }

    public void addEdge(int src, int dest, int weight) throws InvalidInputException
    {
        if(src > V-1 || dest > V-1)
            throw new InvalidInputException("vertex value is beyond capacity");
        Edge e = new Edge(src,dest, weight);

        edges.add(e);
    }

    public boolean isCyclic() throws InvalidInputException
    {
        DisjointUnionSets ds = new DisjointUnionSets(V);

        for(int i=0; i<edges.size(); i++)
        {
            int x = ds.find(edges.get(i).src);
            int y = ds.find(edges.get(i).dest);

            if(x==y)
                return true;

            ds.union(edges.get(i).src, edges.get(i).dest);
        }

        return false;
    }

    public Edge[] kruskalMST() throws InvalidInputException
    {
        DisjointUnionSets ds = new DisjointUnionSets(V);
        Collections.sort(edges);
        Edge[] result = new Edge[V-1];

        int i =0;
        int numberOfEdges =0;
        while(numberOfEdges<V-1) // MST has V-1 edges
        {
            int x = ds.find(edges.get(i).src);
            int y = ds.find(edges.get(i).dest);

            if(x!=y)
            {
                result[numberOfEdges++] = edges.get(i);
                ds.union(x,y);
            }

            i++;
        }

        return result;

    }
    public static void main(String[] args) throws InvalidInputException
    {
        UndirectedGraph graph = new UndirectedGraph(5);
        graph.addEdge(0,1,2);
        graph.addEdge(1,2, -1);
        graph.addEdge(0,4, 5);
        graph.addEdge(4,3,7);
        graph.addEdge(4,1,11);
        graph.addEdge(0,3,1);
        graph.addEdge(2,4,3);
        graph.addEdge(2,3,2);


        System.out.println(graph.isCyclic());
        Edge[] mst = graph.kruskalMST();

        for(int i=0; i<mst.length; i++)
        {
            System.out.println(mst[i].src + " ---> " + mst[i].dest + " : " + mst[i].weight);
        }
    }
}
