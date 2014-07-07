package CodingKata;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static CodingKata.LevelOrderTreeConversion.Node;

public class LevelOrderTreeConversionTest {
    @Test
    public void test() {

        //
        //               8
        //             /   \
        //            5     14
        //          /  \   /  \
        //         2   6  13   17

        Node node17 = new Node(17);
        Node node13 = new Node(13);
        Node node6 = new Node(6);
        Node node2 = new Node(2);
        Node node14 = new Node(14, node13, node17);
        Node node5 = new Node(5, node2, node6);
        Node root = new Node(8, node5, node14);

        List<List<Node>> expected = new ArrayList<List<Node>>();
        expected.add(Arrays.asList(root));
        expected.add(Arrays.asList(node5, node14));
        expected.add(Arrays.asList(node2, node6, node13, node17));

        List<List<Node>> actual = LevelOrderTreeConversion.process(root);

        assertArrayEquals(expected, actual);
    }

    private static void assertArrayEquals(List<List<Node>> expected, List<List<Node>> actual) {
        if (expected.size() != actual.size()) {
            throw new AssertionError("No!  Not Equal!  No soup for you!");
        }

        for (int i = 0; i <= expected.size() - 1; i++) {
            List<Node> lhs = expected.get(i);
            List<Node> rhs = actual.get(i);

            if (lhs.size() != rhs.size()) {
                throw new AssertionError("No!  Not Equal!  No soup for you!");
            }

            for (int j = 0; j <= lhs.size() - 1; j++) {
                if (!lhs.get(j).equals(rhs.get(j))) {
                    throw new AssertionError("No!  Not Equal!  No soup for you!");
                }
            }
        }
    }
}