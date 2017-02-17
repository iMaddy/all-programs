package com.maddy.collections.graph.factory;

import com.maddy.collections.graph.AdjMatrixUndirectedGraph;
import com.maddy.collections.graph.Graph;

/**
 * Created by gitanjali on 17/02/17.
 */
public class AdjMatrixUndirectedGraphFactory extends AbstractGraphFactory
{
    @Override
    public Graph createGraph(int v)
    {
        return new AdjMatrixUndirectedGraph(v);
    }
}
