package TreeNodeProblem;

public class Solution543 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode rootl = new TreeNode(2);
		TreeNode rootr = new TreeNode(3);
		TreeNode rootll = new TreeNode(4);
		TreeNode rootlr = new TreeNode(5);

		root.left = rootl;
		root.right = rootr;
		rootl.left = rootll;
		rootl.right = rootlr;
		
		TreeSolution543 s = new TreeSolution543();
		System.out.println(s.diameterOfBinaryTree(root));
	}

}
class TreeSolution543 {
	//遍历左右子树的最深的层数再相加
	private int ans = 1;
	public int diameterOfBinaryTree(TreeNode root) {
		//遍历每一个节点
		if(root == null) {
			return 0;
		}
		depth(root);
		return ans-1;
	}
    public int depth(TreeNode root) {
    	//以root为根节点的深度
    	if(root == null) {
    		return 0;
    	}
    	int L = depth(root.left);
    	int R = depth(root.right);
    	ans = Math.max(L+R+1, ans);
    	return Math.max(L, R)+1;
    }
}