package MyKata;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestLongestIncreasingSubsequence {   

    @Test 
    public void test() {       
        assertArrayEquals( LongestIncreasingSubsequence.findIt(new int[] { 1,2,3,-10,4,5,-20    }), new int[] { 1,2,3,4,5 } );
        assertArrayEquals( LongestIncreasingSubsequence.findIt(new int[] { -9,1,2,3,-10,4,5,-20 }), new int[] { 1,2,3,4,5 } );
        assertArrayEquals( LongestIncreasingSubsequence.findIt(new int[] { -9                   }), new int[] { -9        } );
    }

}
