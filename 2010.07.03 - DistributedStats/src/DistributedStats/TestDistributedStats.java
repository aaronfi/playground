package DistributedStats;

import junit.framework.TestCase;

public class TestDistributedStats extends TestCase {
	
    public void test_run1() { 
    	
    	Master ds = new Master( new int[][] { 
    		{1, 2, 3}, 
    		{4, 5, 6}, 
    		{7, 8, 9}, 
    	});

    	float x = ds.getMean();
    	assertEquals(5.0F, x);	
    }
}
