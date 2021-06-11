

import java.util.ArrayList;
import java.util.List;

public class Solution145 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(4);
		TreeNode rootl = new TreeNode(9);
		TreeNode rootr = new TreeNode(0);
		TreeNode rootll = new TreeNode(5);
		TreeNode rootlr = new TreeNode(1);
		root.left = rootl;
		root.right = rootr;
		rootl.left = rootll;
		rootl.right = rootlr;
		TreeSolution145 s = new TreeSolution145();
		List<Integer> result = s.postorderTraversal(root);
		for(Integer i : result) {
			System.out.print(i+",");
		}
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
class TreeSolution145 {
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> result = new ArrayList<Integer>();
    	if(root == null) {
    		return result;
    	}
    	get(root,result);
    	return result;
    }
    public void get(TreeNode node,List<Integer> result) {
    	
    	if(node.left != null) {
    		get(node.left,result);
    	}
    	if(node.right !=null) {
    		get(node.right,result);
    	}
    	result.add(node.val);
    }
}