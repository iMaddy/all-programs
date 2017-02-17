package com.maddy.collections.graph;

/**
 * Created by gitanjali on 16/02/17.
 */
public interface Graph
{
    public void addEdge(int src, int dest);
    public void addEdge(int src, int dest, int weight);
    public void printGraph();
}
