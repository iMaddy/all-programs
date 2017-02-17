package com.maddy.collections.graph;

import java.util.LinkedList;

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
}
