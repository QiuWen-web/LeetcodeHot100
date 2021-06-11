package TreeNodeProblem;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

public class Solution230 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		TreeNode rootl = new TreeNode(1);
		TreeNode rootr = new TreeNode(4);
//		TreeNode rootll = new TreeNode(2);
		TreeNode rootlr = new TreeNode(2);
		root.left = rootl;
		root.right = rootr;
//		rootl.left = rootll;
		rootl.right = rootlr;
		TreeSolution230 s=  new TreeSolution230();
		System.out.println(s.kthSmallest01(root, 1));
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
class TreeSolution230 {
    public int kthSmallest(TreeNode root, int k) {
    	List<Integer> list = new ArrayList<>();
    	if(root == null) {
    		return 0;
    	}
    	midlookFor(root,list);
    	return list.get(k-1);
    }
    public void midlookFor(TreeNode root,List<Integer> list) {
    	if(root.left != null) {
    		midlookFor(root.left,list);
    	}
    	list.add(root.val);
    	if(root.right !=null) {
    		midlookFor(root.right,list);
    	}
    	
    }
    public int kthSmallest01(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

        while(true) {
        	while(root != null) {
        		stack.add(root);
        		root = root.left;
        	}
        	root = stack.removeLast();
        	if(--k == 0) {
        		return root.val;
        	}
        	root = root.right;
        }
      }
}