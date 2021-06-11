package TreeNodeProblem;

public class Solution437 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(10);
		TreeNode rootl = new TreeNode(5);
		TreeNode rootr = new TreeNode(-3);
		TreeNode rootll = new TreeNode(3);
		TreeNode rootlr = new TreeNode(2);
		TreeNode rootrr = new TreeNode(11);
		TreeNode rootlll = new TreeNode(3);
		TreeNode rootllr = new TreeNode(-2);
		TreeNode rootlrr = new TreeNode(1);
		root.left = rootl;
		root.right = rootr;
		rootl.left = rootll;
		rootl.right = rootlr;
		rootr.right = rootrr;
		rootll.left = rootlll;
		rootll.right = rootllr;
		rootlr.right = rootlrr;
		TreeSolution437 s = new TreeSolution437();
		System.out.println(s.pathSum(root, 8));
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
class TreeSolution437 {
    public int pathSum(TreeNode root, int sum) {
        //递归吧，每次设定一个初始节点，从初始节点向下遍历，看看能不能得到结果sum
    	if(root == null) {
    		return 0;
    	}
    	thisnodecanhave(root,sum);
    	if(root.left != null) {
    		pathSum(root.left,sum);
    	}
    	if(root.right !=null) {
    		pathSum(root.right,sum);
    	}
    	return i;
    }
    //从初始节点向下遍历的路线条数
    private int i =0;
    public void thisnodecanhave(TreeNode node, int sum) {
    	if(sum - node.val == 0) {
    		//记一次
    		i++;
    	}
    	if(node.left != null) {
    		thisnodecanhave(node.left,sum-node.val);
    	}
    	if(node.right != null) {
    		thisnodecanhave(node.right,sum-node.val);
    	}
    }
}