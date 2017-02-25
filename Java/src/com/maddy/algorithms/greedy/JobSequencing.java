package com.maddy.algorithms.greedy;

import com.maddy.collections.DisjointUnionSets;
import com.maddy.exceptions.InvalidInputException;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by gitanjali on 22/02/17.
 */
public class JobSequencing
{
    public class Job implements Comparable
    {
        char id;
        int deadline;
        int profit;

        public Job(char id, int deadline, int profit)
        {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }

        @Override
        public int compareTo(Object obj)
        {
            return ((Job)obj).profit - this.profit; // sort on-increasing
        }
    }

    int n;
    ArrayList<Job> jobs;
    boolean[] slot;

    public JobSequencing(int n)
    {
        this.n = n;
        jobs = new ArrayList<>(n);
        slot = new boolean[n];
    }

    public void addJob(char id, int deadline, int profit)
    {
        if(jobs.size() >= n) //exhausted capacity - limiting only upto n tasks
            return;

        Job job = new Job(id, deadline, profit);
        jobs.add(job);
    }

    public ArrayList<Job> maximumProfitTasks() throws InvalidInputException
    {
        Collections.sort(jobs);

        int maxDeadline = findMaxDeadline();
        DisjointUnionSets ds = new DisjointUnionSets(Math.min(maxDeadline+1, n)); //represents disjoint set of available slots

        ArrayList<Job> result = new ArrayList<>(jobs.size());
        for(Job j: jobs)
        {
            int availableSlot = ds.find(Math.min(j.deadline, n));

            if(availableSlot>0)
            {
                result.add(j);
                ds.merge(availableSlot-1, availableSlot);
            }
        }

        return result;
    }

    private int findMaxDeadline()
    {
        int max = Integer.MIN_VALUE;

        for(Job j: jobs)
            max = Math.max(max, j.deadline);


        return max;
    }


    public static void main(String[] args) throws InvalidInputException
    {
        JobSequencing jobSeqEngine = new JobSequencing(10);

        jobSeqEngine.addJob('b',1,19);
        jobSeqEngine.addJob('a',1,100);
        jobSeqEngine.addJob('c',2,27);
        jobSeqEngine.addJob('d',1,25);
        jobSeqEngine.addJob('e',3,15);


        ArrayList<Job> jobList = jobSeqEngine.maximumProfitTasks();
        for(Job j: jobList)
        {
            System.out.println(j.id);
        }
    }
}
