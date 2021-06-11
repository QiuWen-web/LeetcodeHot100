package TreeNodeProblem;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution515 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class TreeSolution515 {
    public List<Integer> largestValues(TreeNode root) {
    	Deque<TreeNode> nodes = new LinkedList<>();
    	if(root == null) {
    		return new ArrayList<>();
    	}
    	nodes.add(root);
    	List<Integer> res = new ArrayList<>();
    	while(!nodes.isEmpty()) {
    		int size = nodes.size();
    		int max = Integer.MIN_VALUE;
    		while(size>0) {
    			TreeNode node = nodes.removeLast();
    			if(node.val > max) {
    				max = node.val;
    			}
    			
    			//这边先放右子树
    			if(node.right != null) {
    				nodes.addFirst(node.right);
    			}
    			if(node.left != null) {
    				nodes.addFirst(node.left);
    			}
    			size--;
    		}
    		res.add(max);
    	}
    	return res;
    }
}