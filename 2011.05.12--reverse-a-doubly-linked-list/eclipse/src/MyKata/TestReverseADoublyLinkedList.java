package MyKata;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestReverseADoublyLinkedList {

    @Test
    public void test() {
        ReverseADoublyLinkedList list1 = new ReverseADoublyLinkedList( new int[] {1,2,3,4,5} );
        ReverseADoublyLinkedList list2 = new ReverseADoublyLinkedList( new int[] {5,4,3,2,1} );
        list2.reverse();
        assertEquals(list1, list2);
        System.out.println(list1.toString() + " reversed is " + list2.toString());

        list1 = new ReverseADoublyLinkedList( new int[] {1} );
        list2 = new ReverseADoublyLinkedList( new int[] {1} );
        list2.reverse();
        assertEquals(list1, list2);
        System.out.println(list1.toString() + " reversed is " + list2.toString());

        list1 = new ReverseADoublyLinkedList( new int[] {} );
        list2 = new ReverseADoublyLinkedList( new int[] {} );
        list2.reverse();
        assertEquals(list1, list2);
        System.out.println(list1.toString() + " reversed is " + list2.toString());

        list1 = new ReverseADoublyLinkedList( new int[] {1,2,3} );
        list2 = new ReverseADoublyLinkedList( new int[] {4,5,6} );
        list2.reverse();
        assertFalse(list1.equals(list2));
        System.out.println(list1.toString() + " reversed is not " + list2.toString());
    }
}