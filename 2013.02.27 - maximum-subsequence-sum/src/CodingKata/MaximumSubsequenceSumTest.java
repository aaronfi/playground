package CodingKata;

import org.junit.Test;
import static org.junit.Assert.*;

public class MaximumSubsequenceSumTest
{
    @Test 
    public void TestAllPositiveSequence() {
        assertArrayEquals(MaximumSubsequenceSum.find(new int[]{1, 2, 3, 4, 5}), new int[] {0, 4, 15});
    }

    @Test
    public void TestNestedPositiveSequence() {
        assertArrayEquals(MaximumSubsequenceSum.find(new int[]{1, 2, -5, 3, 4, -5, 4}), new int[] {3, 4, 7});
    }
}
