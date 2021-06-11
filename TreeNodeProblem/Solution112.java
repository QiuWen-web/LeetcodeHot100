package TreePackage;

public class Solution112 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		TreeNode root = new TreeNode(5);
//		TreeNode rootl = new TreeNode(4);
//		TreeNode rootr = new TreeNode(8);
//		TreeNode rootll = new TreeNode(11);
//		TreeNode rootlll = new TreeNode(7);
//		TreeNode rootllr = new TreeNode(2);
//		TreeNode rootrl = new TreeNode(13);
//		TreeNode rootrr = new TreeNode(4);
//		TreeNode rootrrr = new TreeNode(1);
//		root.left = rootl;
//		root.right = rootr;
//		rootl.left = rootll;
//		rootll.left = rootlll;
//		rootll.right = rootllr;
//		rootr.left = rootrl;
//		rootr.right = rootrr;
//		rootrr.right = rootrrr;
		
//		TreeNode root = new TreeNode(-2);
//		TreeNode rootl = new TreeNode(-3);
////		TreeNode rootr = new TreeNode(3);
//		root.left = rootl;
////		root.right = rootr;
		TreeNode root = new TreeNode(1);
		TreeNode rootl = new TreeNode(-2);
		TreeNode rootr = new TreeNode(-3);
		TreeNode rootll = new TreeNode(1);
		TreeNode rootlr = new TreeNode(3);
		TreeNode rootlll = new TreeNode(-1);
		TreeNode rootrl = new TreeNode(-2);
		root.left = rootl;
		root.right = rootr;
		rootl.left = rootll;
		rootl.right = rootlr;
		rootll.left = rootlll;
		rootr.left = rootrl;
		TreeSolution112 s = new TreeSolution112();
		System.out.println(s.hasPathSum(root, -1));
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
class TreeSolution112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
    	if(root == null) {
    		return false;
    	}
    	//root不为null的情况
    	return iszero(root,targetSum);
    }
    public boolean iszero(TreeNode root,int targetSum) {
    	targetSum -= root.val;
    	boolean flag1 = false;
    	boolean flag2 = false;
    	if(targetSum == 0 && root.left == null && root.right == null) {
    		return true;
    	}
    	if(targetSum != 0 || root.left != null || root.right != null) {
    		if(root.left != null) {
    			flag1 = iszero(root.left,targetSum);
    		}
    		if(root.right != null) {
    			flag2 = iszero(root.right,targetSum);
    		}
    	}
    	return flag1||flag2;
    }
}