package CodingKata;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlattenTreeTest {
    
    @Test
    public void test() { 
        Node myTree = new Node(0, new Node[] { new Node(1, new Node[] { new Node(4), new Node(5)              }),
                                               new Node(2, new Node[] { new Node(6), new Node(7), new Node(8) }),
                                               new Node(3, new Node[] { new Node(9)                           }),
            });
        
        List<List<Node>> expected = new ArrayList<List<Node>>();
        expected.add(Arrays.asList(new Node(0)));
        expected.add(Arrays.asList(new Node(1), new Node(2), new Node(3)));
        expected.add(Arrays.asList(new Node(4), new Node(5), new Node(6), new Node(7), new Node(8), new Node(9)));
        
        List<List<Node>> actual = FlattenTree.flatten(myTree);
        
        assertArrayEquals(expected, actual);
    }
    
    private static void assertArrayEquals(List<List<Node>> expected, List<List<Node>> actual) {
        if (expected.size() != actual.size()) {
            throw new AssertionError("No!  Not Equal!  No soup for you!");
        }
        
        for(int i=0; i <= expected.size()-1; i++) {
            List<Node> lhs = expected.get(i);
            List<Node> rhs = actual.get(i);
            
            if (lhs.size() != rhs.size()) {
                throw new AssertionError("No!  Not Equal!  No soup for you!");
            }
            
            for(int j=0; j <= lhs.size()-1; j++) {
                if (! lhs.get(j).equals(rhs.get(j))) {
                    throw new AssertionError("No!  Not Equal!  No soup for you!");
                }
            }
        }
    }
}
