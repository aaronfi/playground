package MyKata;

// Author:  aaronfi@ 2010.05.31
//
// a node in a k-ary tree

public class TreeNode {
    public TreeNode[] children;
    public int val;
    
    TreeNode() {
        this(0, null);
    }

    TreeNode(int val) {
        this(val, null);
    }
    
    TreeNode(int init_val, TreeNode[] init_children) {
        this.children = init_children;
        this.val = init_val;
    }

    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(this.val);
        if (this.children != null) {
            output.append(":(");
            for(TreeNode child : this.children) {
                output.append(child.toString());
                output.append(',');
            }
            output.deleteCharAt(output.length()-1);
            output.append(')');
        }
        
        return output.toString();
    }
    
    public boolean equals(TreeNode that) {
        if (this.val != that.val) return false;
        if (this.children == null && that.children != null) return false;
        if (this.children != null && that.children == null) return false;
        if (this.children != null && that.children != null) {
            if (this.children.length != that.children.length) return false;
            for (int i = 0; i < this.children.length; i++) {
                if (! this.children[i].equals(that.children[i])) return false; 
            }
        }
        return true;
    }
}
