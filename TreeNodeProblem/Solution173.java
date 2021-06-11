package TreeNodeProblem;

import java.util.ArrayList;
import java.util.List;

public class Solution173 {

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
		BSTIterator BST = new BSTIterator(root);
		System.out.println(BST.next());
		System.out.println(BST.next());
		System.out.println(BST.hasNext());
		System.out.println(BST.next());
		System.out.println(BST.hasNext());
		System.out.println(BST.next());
		System.out.println(BST.hasNext());
		System.out.println(BST.next());
		System.out.println(BST.hasNext());
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
class BSTIterator {
	TreeNode root;
	List<Integer> result;
	int i = -1;
    public BSTIterator(TreeNode root) {
    	this.root = root;
    	List<Integer> result = new ArrayList<Integer>();
    	if(root == null) {
    		this.result = result;
    	}
    	get(root,result);
    	this.result = result;
    }
    
    public int next() {
    	i++;
    	return result.get(i);
    }
    
    public boolean hasNext() {
    	if(i+1<result.size()) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    public void get(TreeNode node,List<Integer> result) {
    	
    	if(node.left != null) {
    		get(node.left,result);
    	}
    	result.add(node.val);
    	if(node.right !=null) {
    		get(node.right,result);
    	}
    	
    }
    
}
