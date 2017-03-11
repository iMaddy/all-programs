package com.maddy.collections.graph;

import com.maddy.algorithms.graphalgorithm.BinaryMinHeap;
import sun.security.provider.certpath.Vertex;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

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

    public Map<Integer,Integer> dijkstraShortestPath(int source)
    {
        //build minheap with source distance as 0, rest of distance as Integer.Max
        int[] array = new int[V];
        for(int i=0; i<V; i++)
        {
            if(i==source)
            {
                array[i] =0;
            }
            else
            {
                array[i] = Integer.MAX_VALUE;
            }
        }

        BinaryMinHeap minHeap = new BinaryMinHeap(array);
        Map<Integer,Integer> minDistanceMap = new Hashtable<>(V);
        Map<Integer,Integer> parentMap = new Hashtable<>(V);
        parentMap.put(source,source);

        while (!minHeap.isEmpty())
        {
            com.maddy.algorithms.graphalgorithm.Vertex currentVertex = minHeap.extractMin();

            minDistanceMap.put(currentVertex.vertex, currentVertex.value);

            LinkedList<AdjNode> adjNodes = adjList[currentVertex.vertex];

            for(AdjNode adjNode: adjNodes)
            {
                if(!minHeap.contains(adjNode.vertex))
                    continue;

                int newDistance = minDistanceMap.get(currentVertex.vertex) + adjNode.weight;

                if(newDistance < minHeap.getValue(adjNode.vertex))
                {
                    minHeap.decreaseValue(adjNode.vertex,newDistance);
                    parentMap.put(adjNode.vertex, currentVertex.vertex);
                }
            }

        }

        return minDistanceMap;
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

    public static void main(String[] args)
    {
        AdjListUndirectedGraph graph = new AdjListUndirectedGraph(6);
        graph.addEdge(0,1,3);
        graph.addEdge(0,2, 4);
        graph.addEdge(0,3, 1);
        graph.addEdge(1,3,1);
        graph.addEdge(1,5,3);
        graph.addEdge(2,3,2);
        graph.addEdge(2,4,7);
        graph.addEdge(4,5,3);

        Map<Integer,Integer> map = graph.dijkstraShortestPath(0);

        System.out.println(map);
    }
}
