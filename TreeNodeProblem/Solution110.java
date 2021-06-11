package TreePackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode rootl = new TreeNode(2);
		TreeNode rootr = new TreeNode(3);
		TreeNode rootll = new TreeNode(4);
		TreeNode rootlr = new TreeNode(5);
		TreeNode rootrl = new TreeNode(6);
		TreeNode rootrr = null;
		TreeNode rootlll = new TreeNode(8);
		root.left = rootl;
		root.right = rootr;
		rootl.left = rootll;
		rootl.right = rootlr;
		rootr.left = rootrl;
		rootr.right = rootrr;
		rootll.left = rootlll;
		TreeSolution110 s = new TreeSolution110();
		System.out.println(s.isBalanced(root));
	}

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    
}
class TreeSolution110 {
    public boolean isBalanced(TreeNode root) {
    	if(root == null) {
    		return true;
    	}else {
    		return Math.abs(height(root.left) - height(root.right))<=1&&isBalanced(root.left)&&isBalanced(root.right);
    	}
    }

    public int height(TreeNode root) {
    	if(root == null) {
    		return 0;
    	}else {
    		return Math.max(height(root.left), height(root.right))+1;
    	}
    }
}