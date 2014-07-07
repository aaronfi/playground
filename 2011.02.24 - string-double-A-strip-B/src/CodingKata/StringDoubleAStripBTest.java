package CodingKata;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringDoubleAStripBTest
{
    @Test public void test() { 
    	assertEquals(StringDoubleAStripB.doIt("abxyba"),                 "aaxyaa");
        assertEquals(StringDoubleAStripB.doIt("bbbb"),                   "----");
        assertEquals(StringDoubleAStripB.doIt("a-"),                     "aa");
        assertEquals(StringDoubleAStripB.doIt("b"),                      "-");
        assertEquals(StringDoubleAStripB.doIt(""),                       "");
        assertEquals(StringDoubleAStripB.doIt("aabthisaabisaabtest---"), "aaaathisaaaaisaaaatest");
    }    
}
