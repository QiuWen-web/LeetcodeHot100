package TreeNodeProblem;

public class Solution235 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(6);
		TreeNode rootl = new TreeNode(2);
		TreeNode rootr = new TreeNode(8);
		TreeNode rootll = new TreeNode(0);
		TreeNode rootlr = new TreeNode(4);
		TreeNode rootrl = new TreeNode(7);
		TreeNode rootrr = new TreeNode(9);
		TreeNode rootlrl = new TreeNode(3);
		TreeNode rootlrr = new TreeNode(5);
		root.left = rootl;
		root.right = rootr;
		rootl.left = rootll;
		rootl.right = rootlr;
		rootr.left = rootrl;
		rootr.right = rootrr;
		rootlr.left = rootlrl;
		rootlr.right = rootlrr;
		TreeNode p = new TreeNode(2);
		TreeNode q = new TreeNode(4);
		TreeSolution235 s = new TreeSolution235();
		TreeNode node = s.lowestCommonAncestor(root, p, q);
		System.out.println(node.val);
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
class TreeSolution235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val) {
        	return lowestCommonAncestor(root.left,p,q);
        }
        if(root.val < p.val && root.val < q.val) {
        	return lowestCommonAncestor(root.right,p,q);
        }
        if(root.val > p.val && root.val <q.val) {
        	return root;
        }
        if(root.val < p.val && root.val >q.val) {
        	return root;
        }
        if(root.val == p.val || root.val == q.val) {
        	return root;
        }
        return null;
    }
}