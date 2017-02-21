package com.maddy.collections.graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by gitanjali on 16/02/17.
 */
public class AdjListUndirectedGraph extends UndirectedGraph
{
    int V;
    LinkedList<AdjNode>[] adjList;

    public AdjListUndirectedGraph(int v)
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

    }

    @Override
    public void DSF(int source)
    {

    }


    @Override
    public boolean isCyclic()
    {
        boolean[] visited = new boolean[V];
        for(int i=0; i<V; i++)
        {
            if(isCyclicInternal(i,visited,-1))
                return true;
        }

        return false;
    }

    private boolean isCyclicInternal(int v, boolean[] visited, int parent)
    {
        if(!visited[v])
        {
            visited[v] = true;

            Iterator<AdjNode> iterator = adjList[v].listIterator();
            while(iterator.hasNext())
            {
                AdjNode node = iterator.next();
                if(!visited[node.vertex])
                {
                    if(isCyclicInternal(node.getVertex(), visited, v))
                        return true;
                }
                else if (node.getVertex() != parent)
                {
                    return true;
                }
            }
        }

        return false;
    }


}
