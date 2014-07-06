package CodingKata;

import org.junit.Test;
import static org.junit.Assert.*;

public class FindSubsequenceSummingToNTest
{
    @Test public void TestEmptyArray() {
        assertArrayEquals(FindSubsequenceSummingToN.find(new int[] {}, 100), null);
    }

    @Test public void TestForExistingSequence() {
        assertArrayEquals(FindSubsequenceSummingToN.find(new int[] { 10, 5, 1, 1, 2, 6, 5 }, 9), new int[] { 5, 1, 1, 2 });
    }

    @Test public void TestForImpossibleSequence() {
        assertArrayEquals(FindSubsequenceSummingToN.find(new int[] { 10, 5, 1, 1, 2, 6, 5 }, 100), null);
    }

    @Test public void TestNullArray() {
        assertArrayEquals(FindSubsequenceSummingToN.find(null, 100), null);
    }
}
