package com.maddy.collections.graph;

import com.maddy.exceptions.TypeValidationException;

/**
 * Created by gitanjali on 16/02/17.
 */
public interface Graph
{
    public void addEdge(int src, int dest);
    public void addEdge(int src, int dest, int weight);
    public void printGraph();
    public void BSF(int source);
    public void DSF(int source);
    public boolean isCyclic();
    public int[] topologicalSorting() throws TypeValidationException;
    public int[] longestDistanceFromSource(int source) throws TypeValidationException;
}
