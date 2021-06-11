package TreePackage;

import java.util.ArrayList;
import java.util.List;

public class Solution129 {

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
		TreeSolution129 s = new TreeSolution129();
		System.out.println(s.sumNumbers(root));
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
class TreeSolution129 {
	private int res = 0;
    public int sumNumbers(TreeNode root) {
    	List<Integer> list = new ArrayList<>();
    	function(root,list);
    	return res;
    }
    public void function(TreeNode node,List<Integer> list) {
    	List<Integer> temp = new ArrayList<>();
    	for(int i = 0;i<list.size();i++) {
    		temp.add(list.get(i));
    	}
    	temp.add(node.val);
    	if(node.left == null && node.right == null) {
    		StringBuilder sb = new StringBuilder();
    		for(Integer i : temp) {
    			sb.append(i+"");
    		}
    		int tempres = Integer.parseInt(sb.toString());
    		res += tempres;
    	}
    	if(node.left != null) {
    		function(node.left,temp);
    	}
    	if(node.right != null) {
    		function(node.right,temp);
    	}
    }
}