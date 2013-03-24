package MyKata;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LevelOrderTreeConversion {
    
    public static class Node {
        public Node left, right;
        public int value;
        public Node(int value) {
            this.value = value;
            this.left = this.right = null;
        }
        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public static List<List<Node>> process(Node n) {
        if (n == null) { 
            return null;
        }
        
        List<List<Node>> all = new ArrayList<List<Node>>();        
        Queue<Node> nodesToVisit = new LinkedList<Node>();
        
        nodesToVisit.add(n);
        while(! nodesToVisit.isEmpty()) {
            
            List<Node> currLevel = new LinkedList<Node>();
            Queue<Node> nextNodesToVisit = new LinkedList<Node>();

            while(! nodesToVisit.isEmpty()) {
                Node curr = nodesToVisit.remove();
                currLevel.add(curr);
                
                if (curr.left != null) nextNodesToVisit.add(curr.left);
                if (curr.right != null) nextNodesToVisit.add(curr.right);
            }
            
            all.add(currLevel);
            nodesToVisit.addAll(nextNodesToVisit);
        }

        return all;
    }
    
    
    public static void main(String[] args) {        
        Node root = new Node(8, new Node(5, new Node(2), new Node(6)), new Node(14, new Node(13), new Node(17)));
        List<List<Node>> all = process(root);
        for(List<Node> list : all) {
            System.out.print("[");
            for(Node n: list) {
                System.out.print(n.value + ",");
            }
            System.out.println("]");
        }
    }
}
