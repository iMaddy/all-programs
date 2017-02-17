package com.maddy.collections.graph.factory;

import com.maddy.collections.graph.AdjListDirectedGraph;
import com.maddy.collections.graph.Graph;

/**
 * Created by gitanjali on 17/02/17.
 */
public class AdjListDirectedGraphFactory extends AbstractGraphFactory
{
    @Override
    public Graph createGraph(int v)
    {
        return new AdjListDirectedGraph(v);
    }
}
