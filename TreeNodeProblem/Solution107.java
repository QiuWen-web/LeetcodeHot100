package TreePackage;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution107 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode rootl = new TreeNode(9);
		TreeNode rootr = new TreeNode(20);
		TreeNode rootrl = new TreeNode(15);
		TreeNode rootrr = new TreeNode(7);
		root.left = rootl;
		root.right = rootr;
		rootr.left = rootrl;
		rootr.right = rootrr;
		TreeSolution107 s = new TreeSolution107();
		List<List<Integer>> list = s.levelOrderBottom(root);
		for(List<Integer> i : list) {
			for(Integer j :i) {
				System.out.print(j+",");
			}
			System.out.println();
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
class TreeSolution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	Deque<TreeNode> nodes = new LinkedList<>();
    	List<List<Integer>> res = new LinkedList<>();
    	
    	if(root == null) {
    		return res;
    	}else {
    		nodes.add(root);
    	}
    	
    	while(!nodes.isEmpty()) {
    		int size = nodes.size();
    		List<Integer> item = new LinkedList<>();
    		while(size>0) {
    			TreeNode node = nodes.removeFirst();
    			item.add(node.val);
    			if(node.left != null) {
    				nodes.add(node.left);
    			}
    			if(node.right != null) {
    				nodes.add(node.right);
    			}
    			size--;
    		}
    		res.add(item);
    	}
    	List<List<Integer>> res1 = new LinkedList<>();
    	for(int i = res.size()-1;i>=0;i--) {
    		res1.add(res.get(i));
    	}
    	return res1;
    }
}