package TreeNodeProblem;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Soution449 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	StringBuilder sb = postOrder(root,new StringBuilder());
    	if(sb.length() != 0) {
    		sb.deleteCharAt(sb.length()-1);
    	}
    	return sb.toString();
    }
    public StringBuilder postOrder(TreeNode node,StringBuilder sb) {
    	if(node == null) {
    		return sb;
    	}
    	postOrder(node.left,sb);
    	postOrder(node.right,sb);
    	sb.append(node.val);
    	sb.append(" ");
    	return sb;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()) {
        	return null;
        }
        Deque<Integer> nums = new LinkedList<>();
        for(String s : data.split("\\s+")) {
        	nums.add(Integer.valueOf(s));
        }
        return helper(Integer.MIN_VALUE,Integer.MAX_VALUE,nums);
    }
    public TreeNode helper(int min,int max,Deque<Integer> nums) {
    	if(nums.size() == 0) {
    		return null;
    	}
    	int val = nums.getLast();
    	if(val > max || val<min) {
    		return null;
    	}
    	TreeNode root = new TreeNode(val);
    	nums.removeLast();
    	root.right = helper(val,max,nums);
    	root.left = helper(min,val,nums);
    	
    	return root;
    }
}