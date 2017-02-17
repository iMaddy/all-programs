package com.maddy.collections.graph.factory;

import com.maddy.collections.graph.AdjListUndirectedGraph;
import com.maddy.collections.graph.Graph;

/**
 * Created by gitanjali on 17/02/17.
 */
public class AdjListUndirectedGraphFactory extends AbstractGraphFactory
{
    @Override
    public Graph createGraph(int v)
    {
        return new AdjListUndirectedGraph(v);
    }
}
