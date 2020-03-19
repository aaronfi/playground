package DistributedStats;

// 2010.07.03:  Daniel Suskin's Google interview question:
// You are given a distributed system having one master and many slaves.
// This system stores a very large set of integers spread across the slaves.
// That is, each slave stores some subset of the overall set of integers.
// Each slave's subset is strictly nonoverlapping with those of the other slaves.
//
// Write an algorithm for calculating the mean, mode, median, and rank(x).
// The master should be used primarily for coordination across the slaves.
//
// For this exercise, I (aaronfi@) use threads to simulate both the master and slave servers.

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Master 
{
    private List<Slave> slaves;
    
	public Master(final int[][] datasets) {
		slaves = new ArrayList<Slave>(datasets.length);
		
		for(int[] dataset : datasets) {
			slaves.add( new Slave(dataset) );
		}
		
		Set x = new TreeSet();
		Collections.sort(new ArrayList(x));
	}

	public float getMean() {
		int numThreads = Math.max(slaves.size(), 50);
		ExecutorService threadExecutor = Executors.newFixedThreadPool(numThreads);
		
		final AtomicInteger sum = new AtomicInteger(0);
		final AtomicInteger count = new AtomicInteger(0);
		
		for(final Slave s : slaves) {
            threadExecutor.submit( new Runnable() {
            	public void run() {
            		Pair<Integer, Integer> sumAndCount = s.getSumAndCount();
        			sum.getAndAdd( sumAndCount.first() );
        			count.getAndAdd( sumAndCount.second() );			
            	}
            });			
		}

        threadExecutor.shutdown();
        try {
        	threadExecutor.awaitTermination(2, TimeUnit.HOURS);
        } catch (InterruptedException ex) {
        	// TODO should never get here;  log an error
        } 
        
		return sum.get() / count.get();
	}
	
	public int getMedian() {
		// TODO:  wiki research all suggests QuickSelect as O(n) algorithm
		// the whole "get the median" is really the Selection Problem
		// find the kth largest/smallest element in an unordered set.
		//
		// http://pine.cs.yale.edu/pinewiki/QuickSelect
		// still, QuickSelect (as with QuickSort) involves partitioning
		// and re-ordering array elements;  i can't exactly do that here
		// in distributed land.
		
		int val = 0;
		return val;
	}

	public int getMode() {
		int val = 0;
		return val;
	}	

	public int getRank() {
		int val = 0;
		return val;
	}	
	
	public String toString() {
		return "TODO";
	}
}
