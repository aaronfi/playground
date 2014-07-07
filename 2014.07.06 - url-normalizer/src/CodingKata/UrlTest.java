package CodingKata;

import org.junit.Test;
import static org.junit.Assert.*;

public class UrlTest
{
    @Test public void TestSOneingleDot() {
        assertEquals("http://foo.com/a/b/c.html", Url.Normalize("http://foo.com/a/b/./c.html"));
    }

    @Test public void TestMultipleSingleDots() {
        assertEquals("http://foo.com/a/b/c.html", Url.Normalize("http://foo.com/a/b/./././c.html"));
    }

    @Test public void TestOneDoubleDot() {
        assertEquals("http://foo.com/a/c.html", Url.Normalize("http://foo.com/a/b/../c.html"));
    }

    @Test public void TestMultipleDoubleDots() {
        assertEquals("http://foo.com/c.html", Url.Normalize("http://foo.com/a/b/../../c.html"));
    }

    @Test public void TestNoDots() {
        assertEquals("http://foo.com/a/b/c.html", Url.Normalize("http://foo.com/a/b/c.html"));
    }

    @Test public void TestEmpty() {
        assertEquals("", Url.Normalize(""));
    }

    @Test public void TestNull() {
        assertEquals(null, Url.Normalize(null));
    }

    @Test public void TestTooManyDoubleDots() {
        assertEquals(null, Url.Normalize("http://foo.com/a/b/../../../c.html"));
    }

    @Test public void TestMixedDots() {
        assertEquals("http://foo.com/d.html", Url.Normalize("http://foo.com/a/b/../././../d.html"));
    }
}
