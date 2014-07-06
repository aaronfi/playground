package CodingKata;

// Author:  aaronfi@, 2011.05.12
// Coding kata:  implement the logic for reversing a doubly-linked list

public class ReverseADoublyLinkedList
{
    public class Node {
        public int value;
        public Node prev;
        public Node next;
 
        public Node(int value) {
            this.value = value;
        }    
    }
    
    public Node head;
    public Node tail;
    public int length = 0;
    
    public Node append(int value) {
        Node node = new Node(value);
        if (tail == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        
        length++;

        return tail;
    }
    
    public ReverseADoublyLinkedList(int[] values) {
        for(int val : values) {
            append(val);
        }
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder().append('[');
        for(Node n = head; n != null; n = n.next) {
            sb.append(n.value).append(',');
        }
        if (sb.length() > 1) sb.deleteCharAt(sb.length()-1);
        sb.append(']');

        return sb.toString();
    }
    
    public Node reverse() {
        tail = head;
  
        Node n = head;
        while (n != null) {
            Node temp = n.next;
            n.next = n.prev;
            n.prev = temp;
            
            if (n.prev == null) head = n;

            n = n.prev;
        }
        
        return head;
    }

    public boolean equals(Object obj) {
    	if (obj == null) return head == null;    	
        if (obj instanceof ReverseADoublyLinkedList) {
            ReverseADoublyLinkedList that = (ReverseADoublyLinkedList) obj; 
            if (length != that.length) return false;

            Node i = head;
            Node j = that.head;
            while (i != null) {
                if (i.value != j.value) return false;
                i = i.next;
                j = j.next;
            }

            return true;
        } else {
            return false;
        }
    }
}