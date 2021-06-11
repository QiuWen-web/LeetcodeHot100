package TreeNodeProblem;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution199 {

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
		TreeSolution199 s = new TreeSolution199();
		List<Integer> list = s.rightSideView(root);
		for(Integer i:list) {
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
class TreeSolution199 {
    public List<Integer> rightSideView(TreeNode root) {
    	Deque<TreeNode> nodes = new LinkedList<>();
    	List<Integer> list = new ArrayList<>();
    	if(root == null) {
    		return list;
    	}
    	nodes.add(root);
    	while(!nodes.isEmpty()) {
    		int size = nodes.size();
    		while(size>0) {
    			TreeNode node = nodes.removeFirst();
    			if(node.left != null) {
    				nodes.add(node.left);
    			}
    			if(node.right !=null) {
    				nodes.add(node.right);
    			}
    			size--;
    			if(size == 0) {
    				list.add(node.val);
    			}
    		}
    	}
    	return list;
    }
    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

        while (true) {
          while (root != null) {
            stack.add(root);
            root = root.left;
          }
          root = stack.removeLast();
          if (--k == 0) return root.val;
          root = root.right;
        }
      }
}