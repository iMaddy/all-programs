package com.maddy.collections.graph;

/**
 * Created by gitanjali on 17/02/17.
 */
public abstract class DirectedGraph implements Graph
{
    @Override
    public void addEdge(int src, int dest)
    {
        addEdgeInternal(src,dest);
    }

    public abstract void addEdgeInternal(int src, int dest);

    @Override
    public void addEdge(int src, int dest, int weight)
    {
        addEdgeInternal(src,dest,weight);
    }

    public abstract void addEdgeInternal(int src, int dest, int weight);
}
