package CodingKata;

import org.junit.Test;
import static org.junit.Assert.*;

public class LongestUniqueWordsTest {
    
    @Test public void test() { 
        assertArrayEquals( new String[] {"abc"},     LongestUniqueWords.count("abc de") );
        assertArrayEquals( new String[] {"abc"},     LongestUniqueWords.count("abc de de de de de") );
        assertArrayEquals( new String[] {"a", "b"},  LongestUniqueWords.count("a b c d") );
        assertArrayEquals( new String[] {"a", "b"},  LongestUniqueWords.count("a b c d") );
        assertArrayEquals( new String[] {"a"},       LongestUniqueWords.count("a b c") );
        assertArrayEquals( new String[] {},          LongestUniqueWords.count("") );
        assertArrayEquals( new String[] {"xy", "e"}, LongestUniqueWords.count("e f f f f g g e e xy") );		
    }
}
