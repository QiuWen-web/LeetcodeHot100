package TreePackage;

import java.util.ArrayList;
import java.util.List;

public class Solution113 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		TreeNode rootl = new TreeNode(4);
		TreeNode rootr = new TreeNode(8);
		TreeNode rootll = new TreeNode(11);
		TreeNode rootlll = new TreeNode(7);
		TreeNode rootllr = new TreeNode(2);
		TreeNode rootrl = new TreeNode(13);
		TreeNode rootrr = new TreeNode(4);
		TreeNode rootrrl = new TreeNode(5);
		TreeNode rootrrr = new TreeNode(1);
		root.left = rootl;
		root.right = rootr;
		rootl.left = rootll;
		rootll.left = rootlll;
		rootll.right = rootllr;
		rootr.left = rootrl;
		rootr.right = rootrr;
		rootrr.left = rootrrl;
		rootrr.right = rootrrr;
		TreeSolution113 s = new TreeSolution113();
		List<List<Integer>> list = s.pathSum(root, 22);
		for(List<Integer> i : list) {
			
			for(Integer j : i) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
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
class TreeSolution113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
    	List<List<Integer>> list = new ArrayList<>();
    	if(root == null) {
    		return list;
    	}
    	//root不为null的情况
    	List<Integer> item = new ArrayList<>();
    	boolean flag = iszero(root,targetSum,list,item);
    	return list;
    }
    public boolean iszero(TreeNode root,int targetSum,List<List<Integer>> list,List<Integer> item) {
    	targetSum -= root.val;
    	List<Integer> temp = new ArrayList<>();
    	for(Integer i : item) {
    		temp.add(i);
    	}
    	temp.add(root.val);
    	boolean flag1 = false;
    	boolean flag2 = false;
    	if(targetSum == 0 && root.left == null && root.right == null) {
    		list.add(temp);
    		return true;
    	}
    	if(targetSum != 0 || root.left != null || root.right != null) {
    		if(root.left != null) {
    			flag1 = iszero(root.left,targetSum,list,temp);
    		}
    		if(root.right != null) {
    			flag2 = iszero(root.right,targetSum,list,temp);
    		}
    	}
    	return flag1||flag2;
    }
}