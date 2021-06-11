package DFS;

import java.util.ArrayList;
import java.util.List;

public class Solution897 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class dfsSolution897 {
	List<Integer> list = new ArrayList<>();
    public TreeNode increasingBST(TreeNode root) {
    	midOrder(root);
    	TreeNode res = new TreeNode(list.get(0));
    	TreeNode temp = res;
    	for(int i = 1;i<list.size();i++) {
    		
    		TreeNode node = new TreeNode(list.get(i));
    		res.right = node;
    		res = res.right;
    	}
    	return temp;
    }
    public void midOrder(TreeNode root) {
    	if(root.left !=null) {
    		midOrder(root.left);
    	}
    	list.add(root.val);
    	if(root.right != null) {
    		midOrder(root.right);
    	}
    }
}