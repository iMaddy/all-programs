package com.maddy.collections.graph;

import com.maddy.exceptions.TypeValidationException;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by gitanjali on 16/02/17.
 */
public class AdjListDirectedGraph extends DirectedGraph
{
    int V;
    LinkedList<AdjNode>[] adjList;

    public AdjListDirectedGraph(int v)
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
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        visited[source] = true;
        queue.add(source);
        while (!queue.isEmpty())
        {
            int vertex = queue.poll();
            System.out.print( vertex + " ");

            //get all adjacent vertexes
            Iterator<AdjNode> iterator = adjList[vertex].listIterator();

            while (iterator.hasNext())
            {
                AdjNode node = iterator.next();
                if(!visited[node.getVertex()])
                {
                    queue.add(node.getVertex());
                    visited[node.getVertex()] = true;
                }
            }
        }
        System.out.println();
    }

    @Override
    public void DSF(int source)
    {
        if(source > getMaxVertexValue())
            return;
        boolean[] visited = new boolean[V];
        DSFInternal(source, visited);
        System.out.println();
    }

    private void DSFInternal(int v, boolean[] visited)
    {
        visited[v] = true;
        System.out.print(v + " ");
        Iterator<AdjNode> iterator = adjList[v].listIterator();
        while (iterator.hasNext())
        {
            AdjNode node = iterator.next();
            if(!visited[node.getVertex()])
                DSFInternal(node.getVertex(), visited);
        }
    }


    @Override
    public boolean isCyclic()
    {
        // using DFS and store vertex which are in stack call
//        boolean[] visited = new boolean[V];
//        boolean[] revisitStack = new boolean[V];
//
//        for(int i=0; i<=getMaxVertexValue(); i++)
//        {
//            if(isCyclicInternal(i,visited, revisitStack))
//                return true;
//        }

        //using graph coloring
        Color[] color = new Color[V];
        for(int i=0; i<V; i++)
        {
            color[i] = Color.WHITE;
        }
        for(int i=0; i<V; i++)
        {
            if(isCyclicUsingColoring(i,color))
                return true;
        }

        return false;
    }

    private boolean isCyclicUsingColoring(int v, Color[] color)
    {
        if(color[v] == Color.WHITE)
        {
            color[v] = Color.GRAY;
            Iterator<AdjNode> iterator = adjList[v].listIterator();
            while(iterator.hasNext())
            {
                AdjNode node = iterator.next();
                if(color[node.getVertex()] == Color.GRAY)
                    return true;

                if(color[node.getVertex()] == Color.WHITE && isCyclicUsingColoring(node.getVertex(), color))
                {
                    return true;
                }
            }
        }

        color[v] = Color.BLACK;
        return false;
    }

    private boolean isCyclicInternal(int v, boolean[] visited, boolean[] revisitStack)
    {
        if(!visited[v])
        {
            visited[v] = true;
            revisitStack[v] = true;

            Iterator<AdjNode> iterator = adjList[v].listIterator();
            while(iterator.hasNext())
            {
                AdjNode node = iterator.next();
                if(!visited[node.getVertex()] && isCyclicInternal(node.getVertex(), visited, revisitStack))
                {
                    return true;
                }
                else if(revisitStack[node.getVertex()])
                {
                    return true;
                }
            }
        }

        revisitStack[v] = false;
        return false;
    }


    @Override
    public int[] topologicalSorting() throws TypeValidationException
    {
        if(isCyclic())
        {
            throw new TypeValidationException("Not an Directed Acyclic Graph");
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        // using DSF

        for(int i=0; i<V; i++)
        {
            if(!visited[i])
                topologicalSortUtil(i,visited, stack);
        }

        int[] result = new int[V];
        for(int i= 0; i<V; i++)
        {
            if(!stack.isEmpty())
                result[i] = stack.pop();
        }

        return result;
    }

    private void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack)
    {
        visited[v] = true;

        Iterator<AdjNode> iterator = adjList[v].listIterator();
        while (iterator.hasNext())
        {
            AdjNode node = iterator.next();
            if(!visited[node.getVertex()])
                topologicalSortUtil(node.getVertex(), visited, stack);
        }
        stack.push(v);
    }


    @Override
    public int[] longestDistanceFromSource(int source) throws TypeValidationException
    {
        int[] result = topologicalSorting();

        int[] dist = new int[V];
        for(int u=0; u<V; u++)
            dist[u] = Integer.MIN_VALUE;

        dist[source] = 0;
        for(int i=0; i<V; i++)
        {
            int u = result[i];
            if(dist[u] != Integer.MIN_VALUE)
            {
                Iterator<AdjNode> iterator = adjList[u].listIterator();
                while (iterator.hasNext())
                {
                    AdjNode node = iterator.next();
                    if (dist[node.getVertex()] < dist[u] + node.getWeight())
                    {
                        dist[node.getVertex()] = dist[u] + node.getWeight();
                    }
                }
            }
        }

        return dist;
    }
}
