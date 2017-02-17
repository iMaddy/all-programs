package com.maddy.collections.graph;

/**
 * Created by gitanjali on 17/02/17.
 */
public class AdjNode
{
    public int vertex;
    public int weight;

    public AdjNode(int v, int w)
    {
        vertex = v;
        weight = w;
    }

    public AdjNode(int v)
    {
        vertex = v;
        weight = 1;
    }

    public int getVertex()
    {
        return vertex;
    }

    public int getWeight()
    {
        return weight;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(obj != null && obj instanceof AdjNode)
        {
            return ((AdjNode) obj).vertex == vertex;
        }

        return false;
    }

    @Override
    public int hashCode()
    {
        return vertex;
    }
}

