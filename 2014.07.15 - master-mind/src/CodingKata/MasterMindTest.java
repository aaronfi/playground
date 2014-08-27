package CodingKata;

import org.junit.Test;
import static org.junit.Assert.*;


public class MasterMindTest
{
    @Test 
    public void TestCool1() {
        MasterMind.Result r = MasterMind.printMatches(new int[]{5, 3, 2, 9},
                new int[]{1, 2, 8, 9});

        assertEquals(r.weakCount, 1 );
        assertEquals(r.strongCount, 1);
    }

    @Test
    public void TestCool2() {
        MasterMind.Result r = MasterMind.printMatches(new int[]{1, 2, 5, 2},
                new int[]{1, 0, 2, 5});

        assertEquals(r.weakCount, 2 );
        assertEquals(r.strongCount, 1);
    }


    @Test
    public void TestAwesomePlayer() {
        MasterMind.Result r = MasterMind.printMatches(new int[]{1, 2, 3, 4, 5},
                new int[]{1, 2, 3, 4, 5});

        assertEquals(r.weakCount, 0 );
        assertEquals(r.strongCount, 5);
    }
}
