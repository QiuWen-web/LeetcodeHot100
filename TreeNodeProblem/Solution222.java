package TreeNodeProblem;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution222 {

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
		TreeSolution222 s = new TreeSolution222();
		System.out.println(s.countNodes(root));
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
class TreeSolution222 {
    public int countNodes(TreeNode root) {
    	Deque<TreeNode> nodes = new LinkedList<>();
    	
    	if(root == null) {
    		return 0;
    	}
    	int res = 0;
    	nodes.add(root);
    	while(!nodes.isEmpty()) {
    		int size = nodes.size();
    		res += size;
    		while(size>0) {
    			TreeNode node = nodes.removeFirst();
    			if(node.left != null) {
    				nodes.add(node.left);
    			}
    			if(node.right !=null) {
    				nodes.add(node.right);
    			}
    			size--;
    		}
    	}
    	return res;
    }
    public int countNodes01(TreeNode root) {
        if (root == null){
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

}