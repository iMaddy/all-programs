package com.maddy.algorithms.graphalgorithm;

import java.util.Hashtable;
import java.util.Map;

public class BinaryMinHeap
{
    int V;
    Vertex[] heap;
    Map<Integer,Integer> position;

    public BinaryMinHeap(int[] array)
    {
        if(array == null)
            return;

        V = array.length;
        heap = new Vertex[V];
        position = new Hashtable<>(V);

        for(int i=0; i<V; i++)
        {
            heap[i] = new Vertex(i,array[i]);
            position.put(i,i);
        }

        buildHeap();
    }

    private int parent(int i)
    {
        return (i-1)/2;
    }

    private int left(int i)
    {
        return 2*i+1;
    }

    private int right(int i)
    {
        return 2*i+2;
    }

    private void buildHeap()
    {
        for(int i = V/2-1; i>=0; i--)
            heapify(i);
    }
    public Vertex extractMin()
    {
        Vertex v = new Vertex(heap[0].vertex, heap[0].value);
        heap[0].value = Integer.MAX_VALUE;
        swap(0,V-1);
        V--;
        position.remove(v.vertex);
        heapify(0);
        return v;
    }

    public boolean contains(int vertex)
    {
        return position.containsKey(vertex);
    }

    public void decreaseValue(int vertex, int value)
    {
        if(!contains(vertex))
            return;

        int i = position.get(vertex);
        if(i>=V)
            return;

        if(heap[i].value < value)
            return;

        heap[i].value = value;

        reverseHeapify(i);
    }

    public int getValue(int vertex)
    {
        if(!contains(vertex))
            return Integer.MIN_VALUE;
        int i = position.get(vertex);
        if(i>=V)
            return Integer.MIN_VALUE;

        return heap[i].value;
    }

    public void reverseHeapify(int i)
    {
        int current = i;
        int parent = parent(i);

        while(parent>=0)
        {
            if(heap[parent].value > heap[current].value)
            {
                swap(parent,current);
                current = parent;
                parent = parent(parent);
            }
            else
            {
                break;
            }
        }
    }

    public void heapify(int i)
    {
        int min = i;
        int l = left(i);
        int r = right(i);

        if(l<V && heap[l].value < heap[min].value)
            min = l;

        if(r<V && heap[r].value < heap[min].value)
            min = r;

        if(min != i)
        {
            swap(i,min);
            heapify(min);
        }

    }

    public boolean isEmpty()
    {
        return V<1;
    }
    private void swap(int i, int j)
    {
        position.put(heap[i].vertex,j);
        position.put(heap[j].vertex,i);

        Vertex temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;

    }

    public static void main(String[] args)
    {
        int[] array = {2,10,5,8,1,7,9,4,3,2};
        for(int i=0; i<array.length; i++)
            System.out.print(i+" ");
        System.out.println();
        for(int item: array)
            System.out.print(item+ " ");
        System.out.println();


        BinaryMinHeap minHeap = new BinaryMinHeap(array);
        minHeap.extractMin();
        minHeap.decreaseValue(1,1);
        for(int i=0; i<minHeap.V; i++)
        {
            System.out.print(minHeap.heap[i].value+ " ");
        }
        System.out.println();
        for(int i=0; i<minHeap.V; i++)
        {
            System.out.print(minHeap.heap[i].vertex+ " ");
        }

        System.out.println("\n"+minHeap.position);
        int x =10;
    }
}
