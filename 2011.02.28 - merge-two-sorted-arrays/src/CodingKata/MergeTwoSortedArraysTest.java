package CodingKata;

import org.junit.Test;
import static org.junit.Assert.*;

public class MergeTwoSortedArraysTest {
    
    @Test public void test() {
        assertArrayEquals(MergeTwoSortedArrays.merge(new int[] {},              new int[] {}        ), new int[] {}                      );
        assertArrayEquals(MergeTwoSortedArrays.merge(new int[] {2,4,6,8,10,12}, new int[] {1,4,5,7} ), new int[] {1,2,4,4,5,6,7,8,10,12} );
        assertArrayEquals(MergeTwoSortedArrays.merge(new int[] {2},             new int[] {1}       ), new int[] {1,2}                   );
        assertArrayEquals(MergeTwoSortedArrays.merge(new int[] {2},             new int[] {1,3}     ), new int[] {1,2,3}                 );
        assertArrayEquals(MergeTwoSortedArrays.merge(new int[] {2},             new int[] {}        ), new int[] {2}                     );
        assertArrayEquals(MergeTwoSortedArrays.merge(new int[] {},              new int[] {2}       ), new int[] {2}                     );
    }
}
