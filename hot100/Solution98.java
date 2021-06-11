package hot100;

public class Solution98 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class HotSolution98 {
	public class TreeNode {
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
    public boolean isValidBST(TreeNode root) {
    	return recurse(root,null,null);
    }
    public boolean recurse(TreeNode node,Integer lower,Integer upper) {
    	if(node == null) {
    		return true;
    	}
    	int val = node.val;
    	if(lower != null &&lower >= val) {
    		return false;
    	}
    	if(upper != null &&upper <= val) {
    		return false;
    	}
    	if(!recurse(node.right,val,upper)) {
    		return false;
    	}
    	if(!recurse(node.left,lower,val)) {
    		return false;
    	}
    	return true;
    }
}