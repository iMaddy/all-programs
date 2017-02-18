package com.maddy.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by gitanjali on 11/02/17.
 */

 class TreeNode
{
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
public class Solution
{
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode a)
    {
        if (a == null)
            return null;

        ArrayList<ArrayList<Integer>> outerArray = new ArrayList<>();
        Queue<TreeNode> activeQueue = new LinkedList<>();
        Queue<TreeNode> passiveQueue = null;
        activeQueue.add(a);

        while (!activeQueue.isEmpty())
        {
            passiveQueue = activeQueue;
            activeQueue = new LinkedList<>();
            ArrayList<Integer> innerArray = new ArrayList<>();
            while(!passiveQueue.isEmpty())
            {
                TreeNode node = passiveQueue.poll();
                innerArray.add(node.val);
                if(node.left != null)
                    activeQueue.add(node.left);

                if(node.right != null)
                    activeQueue.add(node.right);
            }

            outerArray.add(innerArray);
        }

        return outerArray;
    }
}