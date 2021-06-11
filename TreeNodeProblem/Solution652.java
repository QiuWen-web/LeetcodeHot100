package TreeNodeProblem;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution652 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode s = new TreeNode(1);
		TreeNode sl = new TreeNode(2);
		TreeNode sr = new TreeNode(3);
		TreeNode sll = new TreeNode(4);
		TreeNode srl = new TreeNode(2);
		TreeNode srr = new TreeNode(4);
		TreeNode srll = new TreeNode(4);
		s.left = sl;
		s.right = sr;
		sl.left = sll;
		sr.left = srl;
		sr.right = srr;
		srl.left = srll;
		TreeSolution652 res = new TreeSolution652();
		List<TreeNode> result = res.findDuplicateSubtrees(s);
	}

}
class TreeSolution652 {
    Map<String, Integer> count;
    List<TreeNode> ans;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        count = new HashMap<>();
        ans = new ArrayList<>();
        collect(root);
        return ans;
    }

    public String collect(TreeNode node) {
        if (node == null) return "#";
        String serial = node.val + "," + collect(node.left) + "," + collect(node.right);
        count.put(serial, count.getOrDefault(serial, 0) + 1);
        if (count.get(serial) == 2)
            ans.add(node);
        return serial;
    }
}
