package MyKata;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Author:  aaronfi@ 2010.05.31
// 
// Given a k-ary tree, 'flatten' it, i.e. return an array of arrays, each nested 
// array containing the level-order elements for that depth level within the tree.

public class FlattenTree {
    public static List<List<TreeNode>> flatten(TreeNode n) {
        List<List<TreeNode>> retVal = new ArrayList<List<TreeNode>>();
        List<TreeNode> currLevel = new ArrayList<TreeNode>();
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if (n != null) q.add(n);
        while(! q.isEmpty()) {
            TreeNode[] children = q.toArray(new TreeNode[q.size()]);
            q.clear();
            currLevel.clear();

            for(TreeNode x : children) {
                currLevel.add(new TreeNode(x.val));
                if (x.children != null) {
                    for(TreeNode y : x.children) { q.add(y); }
                }
            }
            retVal.add(new ArrayList<TreeNode>(currLevel));
        }
        
        return retVal;
    }
    
    public static void main(String[] args) {
    }
}
