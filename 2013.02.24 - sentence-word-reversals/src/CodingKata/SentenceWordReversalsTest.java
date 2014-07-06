package CodingKata;

import org.junit.Test;
import static org.junit.Assert.*;

public class SentenceWordReversalsTest {
    
    @Test 
    public void test() { 
        assertEquals(SentenceWordReversals.reverseEachWord("Hello how Are you"), "olleH woh erA uoy");
        assertEquals(SentenceWordReversals.reverseEachWord("Hello"), "olleH");
        assertEquals(SentenceWordReversals.reverseEachWord("H"), "H");
        assertEquals(SentenceWordReversals.reverseEachWord(""), "");
        assertEquals(SentenceWordReversals.reverseEachWord(null), null);
        
        assertEquals(SentenceWordReversals.reverseWordOrder("Hello how Are you"), "you Are how Hello");
        assertEquals(SentenceWordReversals.reverseWordOrder("Hello how"), "how Hello");
        assertEquals(SentenceWordReversals.reverseWordOrder("Hello"), "Hello");
        assertEquals(SentenceWordReversals.reverseWordOrder(null), null);

        assertEquals(SentenceWordReversals.reverseWordOrder2("Hello how Are you"), "you Are how Hello");
        assertEquals(SentenceWordReversals.reverseWordOrder2("Hello how"), "how Hello");
        assertEquals(SentenceWordReversals.reverseWordOrder2("Hello"), "Hello");
        assertEquals(SentenceWordReversals.reverseWordOrder2(null), null);
    }
}
