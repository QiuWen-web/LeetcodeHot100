package TreeNodeProblem;

import java.util.ArrayList;
import java.util.List;

public class Solution653 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode s = new TreeNode(5);
		TreeNode sl = new TreeNode(3);
		TreeNode sr = new TreeNode(6);
		TreeNode sll = new TreeNode(2);
		TreeNode slr = new TreeNode(4);
		TreeNode srr = new TreeNode(7);
		
		s.left = sl;
		s.right = sr;
		sl.left = sll;
		sl.right = slr;
		sr.right = srr;
		
		TreeSolution653 res = new TreeSolution653();
		System.out.println(res.findTarget(s, 9));
	}

}
class TreeSolution653 {
	List<Integer> list = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        midOrder(root);
        int size = list.size();
        for(int i = 0;i<size-1;i++) {
        	for(int j=i+1;j<size;j++) {
        		if(list.get(i)+list.get(j) == k) {
        			return true;
        		}
        	}
        }
        return false;
    }
    public void midOrder(TreeNode root){
    	if(root.left!=null) {
    		midOrder(root.left);
    	}
    	list.add(root.val);
    	if(root.right!=null) {
    		midOrder(root.right);
    	}
    }
}