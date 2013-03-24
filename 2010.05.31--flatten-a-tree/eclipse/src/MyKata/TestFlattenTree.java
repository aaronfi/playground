package MyKata;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestFlattenTree  {
    
    @Test
    public void test() { 
        TreeNode myTree = new TreeNode(0, new TreeNode[] { new TreeNode(1, new TreeNode[] { new TreeNode(4), new TreeNode(5)                  }), 
                                                           new TreeNode(2, new TreeNode[] { new TreeNode(6), new TreeNode(7), new TreeNode(8) }),
                                                           new TreeNode(3, new TreeNode[] { new TreeNode(9)                                   }),
            });
        
        List<List<TreeNode>> expected = new ArrayList<List<TreeNode>>();
        expected.add(Arrays.asList(new TreeNode(0)));
        expected.add(Arrays.asList(new TreeNode(1), new TreeNode(2), new TreeNode(3)));
        expected.add(Arrays.asList(new TreeNode(4), new TreeNode(5), new TreeNode(6), new TreeNode(7), new TreeNode(8), new TreeNode(9)));
        
        List<List<TreeNode>> actual = FlattenTree.flatten(myTree);
        
        assertArrayEquals(expected, actual);
    }
    
    private static void assertArrayEquals(List<List<TreeNode>> expected, List<List<TreeNode>> actual) {
        if (expected.size() != actual.size()) {
            throw new AssertionError("No!  Not Equal!  No soup for you!");
        }
        
        for(int i=0; i <= expected.size()-1; i++) {
            List<TreeNode> lhs = expected.get(i);
            List<TreeNode> rhs = actual.get(i);
            
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
