package CodingKata;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Author:  aaronfi@ 2010.05.31
// 
// Given a k-ary tree, 'flatten' it, i.e. return an array of arrays, each nested 
// array containing the level-order elements for that depth level within the tree.

public class FlattenTree {
    public static List<List<Node>> flatten(Node n) {
        List<List<Node>> retVal = new ArrayList<List<Node>>();
        List<Node> currLevel = new ArrayList<Node>();
        
        Queue<Node> q = new LinkedList<Node>();
        if (n != null) q.add(n);
        while(! q.isEmpty()) {
            Node[] children = q.toArray(new Node[q.size()]);
            q.clear();
            currLevel.clear();

            for(Node x : children) {
                currLevel.add(new Node(x.val));
                if (x.children != null) {
                    for(Node y : x.children) { q.add(y); }
                }
            }
            retVal.add(new ArrayList<Node>(currLevel));
        }
        
        return retVal;
    }
}
