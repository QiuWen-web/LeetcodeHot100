package TreePackage;

public class Solution100 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root1 = new TreeNode(1);
		TreeNode root1left = new TreeNode(2);
		TreeNode root1right = new TreeNode(3);
		TreeNode root2 = new TreeNode(1);
		TreeNode root2left = new TreeNode(2);
		TreeNode root2right = new TreeNode(3);
		root1.left = root1left;
		root1.right = root1right;
		root2.left = root2left;
		root2.right = root2right;
		TreeSolution100 s = new TreeSolution100();
		System.out.println(s.isSameTree(root1, root2));
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
class TreeSolution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
    	return isSameTreeNode(p,q);
    }
    public boolean isSameTreeNode(TreeNode p, TreeNode q) {
    	boolean flag1 = true,flag2=true;
    	if ((p == null && q != null)||(p != null && q == null)) {
            return false;
        }else if(p==null && q == null){
    		return true;
    	}else if(p.val == q.val) {
    		flag1 = isSameTreeNode(p.left,q.left);
    		flag2 = isSameTreeNode(p.right,q.right);
    	}else {
    		return false;
    	}
    	return flag1&&flag2;
    }
}