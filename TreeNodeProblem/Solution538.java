package TreeNodeProblem;

public class Solution538 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(4);
		TreeNode rootl = new TreeNode(1);
		TreeNode rootr = new TreeNode(6);
		TreeNode rootll = new TreeNode(0);
		TreeNode rootlr = new TreeNode(2);
		TreeNode rootrl = new TreeNode(5);
		TreeNode rootrr = new TreeNode(7);
		TreeNode rootrrr = new TreeNode(8);
		TreeNode rootlrr = new TreeNode(3);

		root.left = rootl;
		root.right = rootr;
		rootl.left = rootll;
		rootl.right = rootlr;
		rootr.left =rootrl;
		rootr.right = rootrr;
		rootlr.right = rootlrr;
		rootrr.right =rootrrr;
		TreeSolution538 s = new TreeSolution538();
		TreeNode res = s.convertBST(root);
		System.out.println(res);
	}

}
class TreeSolution538 {
	private int sum;
	private int pre = 0;
    public TreeNode convertBST(TreeNode root) {
        //1.首先拿到二叉搜索树所有节点的值的和
    	if(root == null) {
    		return null;
    	}
    	this.sum = sumAllNode(root);
    	midOrder(root);
    	return root;
    }
    public void midOrder(TreeNode root) {
    	if(root.left != null) {
    		midOrder(root.left);
    	}
    	sum = sum-pre;
    	pre = root.val;
    	root.val = sum;
    	if(root.right != null) {
    		midOrder(root.right);
    	}
    }
    public int sumAllNode(TreeNode root) {
    	int res = 0;
    	if(root.left != null) {
    		res += sumAllNode(root.left);
    	}
    	res += root.val;
    	if(root.right != null) {
    		res += sumAllNode(root.right);
    	}
    	return res;
    }
    
}