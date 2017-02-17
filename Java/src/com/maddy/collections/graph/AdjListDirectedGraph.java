package com.maddy.collections.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gitanjali on 16/02/17.
 */
public class AdjListDirectedGraph extends DirectedGraph
{
    int V;
    LinkedList<AdjNode>[] adjList;

    public AdjListDirectedGraph(int v)
    {
        V = v;
        adjList = new LinkedList[V];

        for (int i = 0; i < V; i++)
        {
            adjList[i] = new LinkedList<>();
        }
    }

    @Override
    public void addEdgeInternal(int src, int dest)
    {
        if (src > getMaxVertexValue() || dest > getMaxVertexValue())
            return;

        AdjNode node = new AdjNode(dest);

        if (!adjList[src].contains(node))
        {
            adjList[src].add(node);
        }
    }

    @Override
    public void addEdgeInternal(int src, int dest, int weight)
    {
        if (src > getMaxVertexValue() || dest > getMaxVertexValue())
            return;

        AdjNode node = new AdjNode(dest, weight);

        if (!adjList[src].contains(node))
        {
            adjList[src].add(node);
        }
    }

    private int getMaxVertexValue()
    {
        return V - 1;
    }

    @Override
    public void printGraph()
    {
        for (int i = 0; i < V; i++)
        {
            LinkedList<AdjNode> list = adjList[i];
            System.out.print("vertex [" + i + "] --> ");
            for (AdjNode item : list)
            {
                System.out.print("[" + item.getVertex() + "," + item.getWeight() + "] ");
            }
            System.out.println();
        }
    }

    @Override
    public void BSF(int source)
    {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        visited[source] = true;
        queue.add(source);
        while (!queue.isEmpty())
        {
            int vertex = queue.poll();
            System.out.print( vertex + " ");

            //get all adjacent vertexes
            Iterator<AdjNode> iterator = adjList[vertex].listIterator();

            while (iterator.hasNext())
            {
                AdjNode node = iterator.next();
                if(!visited[node.getVertex()])
                {
                    queue.add(node.getVertex());
                    visited[node.getVertex()] = true;
                }
            }
        }
        System.out.println();
    }

    @Override
    public void DSF(int source)
    {
        if(source > getMaxVertexValue())
            return;
        boolean[] visited = new boolean[V];
        DSFIneternal(source, visited);
        System.out.println();
    }

    private void DSFIneternal(int v, boolean[] visited)
    {
        visited[v] = true;
        System.out.print(v + " ");
        Iterator<AdjNode> iterator = adjList[v].listIterator();
        while (iterator.hasNext())
        {
            AdjNode node = iterator.next();
            if(!visited[node.getVertex()])
                DSFIneternal(node.getVertex(), visited);
        }
    }
}
