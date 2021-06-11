package hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution114 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class Solution {
	public void flatten(TreeNode root) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		preorderTraversal(root,list);
		int size = list.size();
		for(int i = 1 ;i< size;i++) {
			TreeNode prev = list.get(i-1);
			TreeNode curr = list.get(i);
			prev.left = null;
			prev.right = curr;
		}
	}
	public void preorderTraversal(TreeNode root,List<TreeNode> list) {
		if(root != null) {
			list.add(root);
			preorderTraversal(root.left,list);
			preorderTraversal(root.right,list);
		}
	}
}