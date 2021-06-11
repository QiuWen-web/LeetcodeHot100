package TreeNodeProblem;

import java.util.Deque;
import java.util.LinkedList;

public class Solution404 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode rootl = null;
		TreeNode rootr = new TreeNode(2);
		TreeNode rootll = new TreeNode(1);
		TreeNode rootlr = new TreeNode(3);
		TreeNode rootrl = new TreeNode(2);
		TreeNode rootrr = new TreeNode(5);
		root.left = rootl;
		root.right = rootr;
//		rootr.left = rootrl;
//		rootr.right = rootrr;
//		rootl.left = rootll;
//		rootl.right = rootlr;
		TreeSolution404 s = new TreeSolution404();
		int res = s.sumOfLeftLeaves(root);
		System.out.println(res);
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
class TreeSolution404 {
	private int r = 0;
	public int sumOfLeftLeaves(TreeNode root) {
		if(root == null) {
			return 0;
		}
		addr(root);
		return r;
    }
	public void addr(TreeNode root) {
		
		if(root.left != null) {
			if(isLeftNode(root.left)) {
				r += root.left.val;
			}
		}
		if(root.right !=null && !isLeftNode(root.right)) {
			addr(root.right);
		}
		
	}
	public boolean isLeftNode(TreeNode node) {
		if(node.left == null && node.right == null) {
			return true;
		}else {
			return false;
		}
		
	}
}