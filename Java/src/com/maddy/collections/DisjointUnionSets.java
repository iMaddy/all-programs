package com.maddy.collections;

import com.maddy.exceptions.InvalidInputException;

/**
 * Created by gitanjali on 21/02/17.
 */
public class DisjointUnionSets
{
    int n;
    int[] rank;
    int[] parent;

    public DisjointUnionSets(int n)
    {
        this.n = n;
        rank = new int[n];
        parent = new int[n];
        makeSet();
    }

    private void makeSet()
    {
        for(int i=0; i<n; i++)
        {
            parent[i] = i;
        }
    }

    // Returns representative of x's set
    public int find(int x) throws InvalidInputException
    {
        if(x>n)
            throw new InvalidInputException(x + " is greater than disjoint set size: " + n);

        if(parent[x] != x)
            parent[x] = find(parent[x]);

        return parent[x];
    }

    public void union(int x, int y) throws InvalidInputException
    {
        if(x>n || y>n)
            throw new InvalidInputException(x + "or" + y + "or both are greater than disjoint set size: " + n);

        int repX = find(x);
        int repY = find(y);

        if(repX == repY)
            return;

        if(rank[repX] > rank[repY])
        {
            parent[repY] = repX;
        }
        else if(rank[repY] > rank[repY])
        {
            parent[repX] = repY;
        }
        else // rank[repX] == rank[repY]
        {
            parent[repY] = repX;
            rank[repX]++;
        }
    }
}
