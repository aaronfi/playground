package MyKata;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class InterviewTest {

    @Test
    public void TestMalformedHistogram() {
        int count = Interview.FillHistogramWithWater(new int[]{2});
        assertTrue("Expected 0 but found: " + count, 0 == count);
    }

    @Test
    public void TestFlat() {
        int count = Interview.FillHistogramWithWater(new int[]{2, 2});
        assertTrue("Expected 0 but found: " + count, 0 == count);

        assertEquals(0, Interview.FillHistogramWithWater( new int[] { 2, 2 } ));
    }

    @Test
    public void TestSimple() {
        int count = Interview.FillHistogramWithWater(new int[]{ 2, 1, 2 });
        assertTrue("Expected 0 but found: " + count, 0 == count);
    }

    @Test
    public void TestPyramid() {
        int count = Interview.FillHistogramWithWater(new int[]{1, 2, 3, 2, 1 });
        assertTrue("Expected 0 but found: " + count, 0 == count);
    }

    @Test
    public void TestLongAndShallow() {
        int count = Interview.FillHistogramWithWater(new int[]{2, 0, 0, 1, 0, 0, 3 });
        assertTrue("Expected 0 but found: " + count, 0 == count);
    }

    @Test
    public void TestTwoPools() {
        int count = Interview.FillHistogramWithWater(new int[] { 2, 0, 0, 3, 2, 1, 0 });
        assertTrue("Expected 0 but found: " + count, 0 == count);
    }
}