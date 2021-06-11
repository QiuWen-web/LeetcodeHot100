package hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution94 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode treeNode1 = new TreeNode(1);
		TreeNode treeNode2 = new TreeNode(2);
		TreeNode treeNode3 = new TreeNode(3);
		treeNode1.right = treeNode2;
		treeNode2.left = treeNode3;
		
		HotSolution94 hotSolution94 = new HotSolution94();
		List<Integer> res = hotSolution94.inorderTraversal(treeNode1);
	}

}
class HotSolution94 {
	 public class TreeNode {
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
	public List<Integer> res = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {   	
    	if(root == null) {
    		return res;
    	}else {
    		res.add(root.val);
    		if(root.left != null) {
    			return inorderTraversal(root.left);
    		}
    		if(root.right != null) {
    			return inorderTraversal(root.left);
    		}
    	}
    	return res;   	
    }
}