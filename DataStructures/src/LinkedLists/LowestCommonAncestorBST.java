package LinkedLists;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class LowestCommonAncestorBST {

public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
	
        if(root == null || root == p || root == q) return root;
        TreeNode t = p.val < q.val ? p : q;
        q = t == q?p :q;
        if(root.val < t.val) 
        	return lowestCommonAncestorBST(root.right,t,q);
        else if(root.val > q.val)
        	return lowestCommonAncestorBST(root.left, t, q);
        else
        	return root;
    }
	
}
