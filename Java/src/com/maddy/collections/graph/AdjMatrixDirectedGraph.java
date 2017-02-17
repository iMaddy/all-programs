package com.maddy.collections.graph;

/**
 * Created by gitanjali on 17/02/17.
 */
public class AdjMatrixDirectedGraph extends DirectedGraph
{
    int V;
    int adj[][];
    private static final int defaultValue = 0;

    public AdjMatrixDirectedGraph(int v)
    {
        V = v;
        adj = new int[V][V];
        for(int i=0; i<V; i++)
        {
            for(int j=0; j<V; j++)
            {
                adj[i][j] = defaultValue;
            }
        }
    }

    @Override
    public void printGraph()
    {
        for (int i = 0; i < V; i++)
        {
            System.out.print("vertex [" + i + "] --> ");
            for(int j=0; j<V; j++)
            {
                if(adj[i][j] != defaultValue)
                System.out.print("[" + j + "," + adj[i][j] + "] ");
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
    public void addEdgeInternal(int src, int dest)
    {
        adj[src][dest] = 1;
    }

    @Override
    public void addEdgeInternal(int src, int dest, int weight)
    {
        adj[src][dest] = weight;
    }
}
