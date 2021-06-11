package TreePackage;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution103 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode rootl = new TreeNode(4);
		TreeNode rootr = new TreeNode(5);
		TreeNode rootrl = new TreeNode(10);
		TreeNode rootrr = new TreeNode(9);
		root.left = rootl;
		root.right = rootr;
		rootr.left = rootrl;
		rootr.right = rootrr;
		TreeSolution103 s = new TreeSolution103();
		List<List<Integer>> list = s.zigzagLevelOrder(root);
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
class TreeSolution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	Deque<TreeNode> queue = new LinkedList<>();
    	List<List<Integer>> res = new ArrayList<>();
    	if(root == null) {
    		return res;
    	}
    	queue.offer(root);
    	boolean flag = true;
    	while(!queue.isEmpty()) {
    		List<Integer> item = new ArrayList<>();
    		int size = queue.size();    		
    		if(flag) {
    			while(size > 0) {
    				//¥”◊ÛÕ˘”“±È¿˙
     				TreeNode node = queue.removeFirst();
     				item.add(node.val);
     				if(node.left != null) {
     					queue.offerLast(node.left);
     				}
     				if(node.right != null) {
     					queue.offerLast(node.right);
     				}
     				size--;
    			}
    			
    		}else {
    			while(size > 0) {
    				//¥””“Õ˘◊Û±È¿˙
     				TreeNode node = queue.removeLast();
     				item.add(node.val);
     				if(node.right != null) {
     					queue.offerFirst(node.right);
     				}
     				if(node.left != null) {
     					queue.offerFirst(node.left);
     				}
     				size--;
    			}
    		}
    		flag = !flag;
    		res.add(item);
    	}
    	return res;
    }
}