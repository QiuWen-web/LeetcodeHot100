package TreeNodeProblem;

//ÑéÖ¤×ÓÊ÷
public class Solution572 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode s = new TreeNode(3);
		TreeNode sl = new TreeNode(4);
		TreeNode sr = new TreeNode(5);
		TreeNode sll = new TreeNode(1);
		TreeNode slr = new TreeNode(2);
		TreeNode slrl = new TreeNode(2);
		
		s.left = sl;
		s.right = sr;
		sl.left=sll;
		sl.right=slr;
		slr.left = slrl;
		
		TreeNode t = new TreeNode(4);
		TreeNode tl = new TreeNode(1);
		TreeNode tr = new TreeNode(2);
		t.left = tl;
		t.right = tr;
		
		TreeSolution572 res = new TreeSolution572();
		System.out.println(res.isSubtree(s, t));
	}

}
class TreeSolution572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null){
            return false;
        }
        boolean flag = false;
        
        flag = isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot)||helper(root,subRoot);
        
        return flag;
        
    }
    public boolean helper(TreeNode root, TreeNode subRoot){
    	if(root==null&&subRoot==null) {
    		return true;
    	}else if(root!=null&&subRoot==null) {
    		return false;
    	}else if(root==null&&subRoot!=null) {
    		return false;
    	}else {
    		if(root.val == subRoot.val) {
    			return helper(root.left,subRoot.left)&&helper(root.right,subRoot.right);
    		}else {
    			return false;
    		}
    	}
    }
}