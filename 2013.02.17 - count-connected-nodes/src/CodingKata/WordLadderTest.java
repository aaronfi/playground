package CodingKata;

import org.junit.Test;

import static org.junit.Assert.*;
import static CodingKata.WordLadder.Node;

public class WordLadderTest
{
    @Test public void TestGraphGeneration() {
        Node junk = new Node("junk");
        Node funk = new Node("funk");
        Node bunk = new Node("bunk");
        Node sunk = new Node("sunk");
        Node dunk = new Node("dunk");
        Node bunt = new Node("bunt");

        junk.neighbors.put("funk", funk);
        junk.neighbors.put("bunk", bunk);
        junk.neighbors.put("sunk", sunk);
        junk.neighbors.put("dunk", dunk);

        funk.neighbors.put("junk", junk);
        funk.neighbors.put("bunk", bunk);
        funk.neighbors.put("sunk", sunk);
        funk.neighbors.put("dunk", dunk);

        bunk.neighbors.put("junk", junk);
        bunk.neighbors.put("funk", funk);
        bunk.neighbors.put("sunk", sunk);
        bunk.neighbors.put("dunk", dunk);
        bunk.neighbors.put("bunt", bunt);

        sunk.neighbors.put("junk", junk);
        sunk.neighbors.put("bunk", bunk);
        sunk.neighbors.put("funk", funk);
        sunk.neighbors.put("dunk", dunk);

        dunk.neighbors.put("junk", junk);
        dunk.neighbors.put("bunk", bunk);
        dunk.neighbors.put("funk", funk);
        dunk.neighbors.put("sunk", sunk);

        bunt.neighbors.put("bunk", bunk);

        Node[] expected = new Node[] { bunk, bunt, dunk, funk, junk, sunk };

        WordLadder ladder = new WordLadder();
        Node[] actual = ladder.GenerateGraph("junk");

        assertArrayEquals(actual, expected);
    }
}