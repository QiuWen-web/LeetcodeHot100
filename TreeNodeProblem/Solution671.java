package TreeNodeProblem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution671 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class TreeSolution671 {
	//±È¿˙≈≈–Ú
	private Set<Integer> list = new HashSet<>();
	public int findSecondMinimumValue(TreeNode root) {
		int min = root.val;
		preOrder(root);
		int res = Integer.MAX_VALUE
		for(Integer i: list) {
			if(i != min) {
				res = Math.min(res, i);
			}
		}
		if(res == Integer.MAX_VALUE) {
			return -1;
		}else {
			return res;
		}
    }
	public void preOrder(TreeNode root) {
		if(root.left != null) {
			preOrder(root.left);
		}
		list.add(root.val);
		if(root.right != null) {
			preOrder(root.right);
		}
	}
}