package com.maddy.collections.graph;

import com.maddy.exceptions.TypeValidationException;

/**
 * Created by gitanjali on 17/02/17.
 */
public abstract class UndirectedGraph implements Graph
{
    @Override
    public void addEdge(int src, int dest)
    {
        addEdgeInternal(src,dest);
        addEdgeInternal(dest,src);
    }

    public abstract void addEdgeInternal(int src, int dest);

    @Override
    public void addEdge(int src, int dest, int weight)
    {
        addEdgeInternal(src,dest,weight);
        addEdgeInternal(dest,src,weight);
    }

    public abstract void addEdgeInternal(int src, int dest, int weight);

    public boolean isCyclic() // to be implemented by concrete classes
    {
        return true;
    }

    public int[] topologicalSorting() //to be implemented by concrete classes
    {
        return null;
    }

    public int[] longestDistanceFromSource(int source) throws TypeValidationException //to be implemented by concrete classes
    {
        return null;
    }
}
