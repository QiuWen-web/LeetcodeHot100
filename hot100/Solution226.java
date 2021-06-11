package hot100;

public class Solution226 {

}
class Solution {
	
    public TreeNode invertTree(TreeNode root) {
    	if(root.left == null) {
    		return null;
    	}
    	TreeNode temp = root.left;
    	root.left = root.right;
    	root.right = temp;
    	return invertTree(root.left);
    	
    }
    
}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}