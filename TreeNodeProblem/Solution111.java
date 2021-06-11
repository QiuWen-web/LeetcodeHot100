package TreePackage;

public class Solution111 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(2);
		TreeNode rootl = new TreeNode(3);
		TreeNode rootr = new TreeNode(4);
		TreeNode rootll = new TreeNode(5);
		TreeNode rootlr = new TreeNode(6);

		root.left = rootl;
		root.right = rootr;
		rootr.left = rootll;
		rootr.right = rootlr;

		TreeSolution111 s = new TreeSolution111();
		System.out.println(s.minDepth(root));
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
class TreeSolution111 {
    public int minDepth(TreeNode root) {
    	int res = 1;
    	if(root ==null) {
    		return 0;
    	}
    	if(root.left == null && root.right == null) {
    		return res;
    	}
    	if(root.left == null && root.right != null) {
    		res += minDepth(root.right);
    	}
    	if(root.left != null && root.right == null) {
    		res += minDepth(root.left);
    	}
    	if(root.left != null && root.right != null) {
    		res += Math.min(minDepth(root.left), minDepth(root.right));
    	}
    	return res;
    }
}