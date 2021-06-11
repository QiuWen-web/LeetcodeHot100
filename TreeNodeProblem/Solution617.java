package TreeNodeProblem;

public class Solution617 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode s = new TreeNode(1);
		TreeNode sl = new TreeNode(3);
		TreeNode sr = new TreeNode(2);
		TreeNode sll = new TreeNode(5);
		
		s.left = sl;
		s.right = sr;
		sl.left=sll;
		
		TreeNode t = new TreeNode(2);
		TreeNode tl = new TreeNode(1);
		TreeNode tr = new TreeNode(3);
		TreeNode tlr = new TreeNode(3);
		TreeNode trr = new TreeNode(3);
		t.left = tl;
		t.right = tr;
		tl.right = tlr;
		tr.right = trr;
		TreeSolution617 res = new TreeSolution617();
		TreeNode result = res.mergeTrees(s, t);
		System.out.println();
	}

}
class TreeSolution617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
    	if(root1 !=null && root2 !=null) {
    		root1.val = root1.val + root2.val;
    	}else if(root1 ==null && root2 !=null) {
    		root1 = new TreeNode(root2.val);
    		
    	}else {
    		root1.val = root1.val;
    		root2 = new TreeNode(0);
    	}
    	
    	//当root1，或 root2 == null 下面报错
    	if(root1.left != null || root2.left != null) {
    		root1.left = mergeTrees(root1.left,root2.left);
    	}
    	if(root1.right != null || root2.right != null) {
    		root1.right = mergeTrees(root1.right,root2.right);
    	}
    	
    	return root1;
    }
    //前序遍历吧
    
}