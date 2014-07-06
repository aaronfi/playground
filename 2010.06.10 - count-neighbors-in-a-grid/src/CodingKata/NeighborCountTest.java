package CodingKata;

import org.junit.Test;
import static org.junit.Assert.*;

public class NeighborCountTest {
   @Test
   public void test() {
       Boolean[][] board = new Boolean[][] {
           new Boolean[] { true, true, true, true },
           new Boolean[] { true, true, true, true },
           new Boolean[] { true, true, true, true },
           new Boolean[] { true, true, true, true },
       };
       NeighborCount[] ncs = { new NeighborCount(board, NeighborCount.Solutions.TryCatch),
                               new NeighborCount(board, NeighborCount.Solutions.BoundaryCheck1),
                               new NeighborCount(board, NeighborCount.Solutions.BoundaryCheck2),
       };

       for(NeighborCount nc : ncs) {
           assertEquals(2, nc.count(0, 0));
           assertEquals(2, nc.count(0, 3));
           assertEquals(2, nc.count(3, 0));
           assertEquals(2, nc.count(3, 3));
           assertEquals(4, nc.count(2, 2));
           assertEquals(3, nc.count(0, 2));
           assertEquals(4, nc.count(1, 1));
       }
   }
}