package TreeNodeProblem;
//给定一个二叉树，计算 整个树 的坡度 。
public class Solution563 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(4);
		TreeNode rootl = new TreeNode(2);
		TreeNode rootr = new TreeNode(9);
		TreeNode rootll = new TreeNode(3);
		TreeNode rootlr = new TreeNode(5);
//		TreeNode rootrl = new TreeNode(5);
		TreeNode rootrr = new TreeNode(7);
//		TreeNode rootrrr = new TreeNode(8);
//		TreeNode rootlrr = new TreeNode(3);

		root.left = rootl;
		root.right = rootr;
		rootl.left = rootll;
		rootl.right = rootlr;
//		rootr.left =rootrl;
		rootr.right = rootrr;
//		rootlr.right = rootlrr;
//		rootrr.right =rootrrr;
		TreeSolution563 s = new TreeSolution563();
		System.out.println(s.findTilt(root));
	}

}
class TreeSolution563 {
	private int res = 0;
	
    public int findTilt(TreeNode root) {
    	//预处理树
    	lastOrder(root);
    	lastOrdercha(root);
    	return res;
    }
    //返回以root为根节点的所有子节点的和
    public int leftrightSum(TreeNode root) {
    	if(root.left == null && root.right == null) {
    		return root.val;
    	}else if(root.left != null && root.right == null) {
    		return root.val+root.left.val;
    	}else if(root.left == null && root.right != null) {
    		return root.val+root.right.val;
    	}else {
    		return root.val + root.right.val+root.left.val;
    	}    	    	
    }
    //后序遍历root
    public void lastOrder(TreeNode root) {
    	if(root.left != null) {
    		lastOrder(root.left);
    	}
    	if(root.right != null) {
    		lastOrder(root.right);
    	}
    	root.val = leftrightSum(root);
    }
    //后序遍历root
    public void lastOrdercha(TreeNode root) {
    	if(root.left != null) {
    		lastOrdercha(root.left);
    	}
    	if(root.right != null) {
    		lastOrdercha(root.right);
    	}
    	res += leftrightCha(root);
    }
    //返回以root为根节点的左右节点差的绝对值
    public int leftrightCha(TreeNode root) {
    	if(root.left == null && root.right == null) {
    		return 0;
    	}else if(root.left != null && root.right == null) {
    		return Math.abs(root.left.val);
    	}else if(root.left == null && root.right != null) {
    		return Math.abs(root.right.val);
    	}else {
    		return Math.abs(root.right.val-root.left.val);
    	}    	    	
    }
}