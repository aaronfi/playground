package CodingKata;

import org.junit.Test;
import static org.junit.Assert.*;

public class UtilsTest
{
    @Test
    public void TestMalformed() {
        assertEquals(0, Utils.FillHistogramWithWater( new int[] { 2 } ));
    }

    @Test
    public void TestFlat() {
        assertEquals(0, Utils.FillHistogramWithWater( new int[] { 2, 2 } ));
    }

    @Test
    public void TestSimple() {
        assertEquals(1, Utils.FillHistogramWithWater( new int[] { 2, 1, 2 } ));
    }

    @Test
    public void TestPyramid() {
        assertEquals(0, Utils.FillHistogramWithWater( new int[] { 1, 2, 3, 2, 1 } ));
    }

    @Test
    public void TestLongAndShallow() {
        assertEquals(4, Utils.FillHistogramWithWater( new int[] { 2, 0, 0, 1, 0, 0, 3 } ));
    }

    @Test
    public void TestTwoPools() {
        assertEquals(4, Utils.FillHistogramWithWater(new int[]{2, 0, 0, 3, 2, 1, 0}));
    }
}
