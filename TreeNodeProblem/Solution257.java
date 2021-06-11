package TreeNodeProblem;

import java.util.ArrayList;
import java.util.List;

public class Solution257 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(6);
		TreeNode rootl = new TreeNode(2);
		TreeNode rootr = new TreeNode(8);
		TreeNode rootll = new TreeNode(0);
		root.left = rootl;
		root.right = rootr;
		rootl.left = rootll;
		TreeSolution257 s = new  TreeSolution257();
		List<String> list = s.binaryTreePaths(root);
		for(String i:list) {
			System.out.println(i);
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
class TreeSolution257 {
    public List<String> binaryTreePaths(TreeNode root) {
    	List<String> res = new ArrayList<>();
    	StringBuilder sb = new StringBuilder();
    	if(root == null){
    		return res;    		
    	}
    	preOrder(root,sb,res);
    	return res;
    }
    public void preOrder(TreeNode node,StringBuilder sb,List<String> res) {
    	
    	StringBuilder temp = new StringBuilder(sb);
    	temp.append(node.val);
    	
    	if(node.left == null && node.right == null) {
    		res.add(temp.toString());
    		return;
    	}else {
    		temp.append("->");
    		if(node.left != null) {    			
    			preOrder(node.left,temp,res);
    		}
    		if(node.right != null) {    			
    			preOrder(node.right,temp,res);
    		}
    	}
    }
}