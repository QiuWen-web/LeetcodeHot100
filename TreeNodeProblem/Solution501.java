package TreeNodeProblem;

import java.util.ArrayList;
import java.util.List;

public class Solution501 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		TreeNode rootl = new TreeNode(3);
		TreeNode rootr = new TreeNode(6);
		TreeNode rootll = new TreeNode(3);
		TreeNode rootlr = new TreeNode(4);
		TreeNode rootrr = new TreeNode(7);

		root.left = rootl;
		root.right = rootr;
		rootl.left = rootll;
		rootl.right = rootlr;
		rootr.right = rootrr;
		TreeSolution501 s = new TreeSolution501();
		int[] res = s.findMode(root);
		for(int i : res) {
			System.out.println(i);
		}
	}

}
class TreeSolution501 {
	private List<Integer> list = new ArrayList<>();
    public int[] findMode(TreeNode root) {
    	preOrder(root);
    	//list已经排序
    	//在list中寻找出现的最多次数的数
    	int[] dp = new int[list.size()];
    	for(int i = 0;i<list.size();i++) {
    		if(i==0) {
    			dp[0]=1;
    		}else {
    			if(list.get(i)==list.get(i-1)) {
    				dp[i] = dp[i-1] +1;
    			}else {
    				dp[i] =1;
    			}
    		}
    	}
    	int max = 0;
    	
    	for(int i = 0;i<dp.length;i++) {
    		if(max<dp[i]) {
    			max = dp[i];
    		}
    	}
    	List<Integer> list1 = new ArrayList<>();
    	for(int i = 0;i<dp.length;i++) {
    		if(dp[i]==max) {
    			list1.add(dp[i]);
    		}
    	}
    	int[] res = new int[list1.size()];
    	for(int i = 0;i<list1.size();i++) {
    		res[i] = list1.get(i);
    	}
    	return res;
    }
    public void preOrder(TreeNode root) {
    	if(root.left != null) {
    		preOrder(root.left);
    	}
    	list.add(root.val);
    	if(root.right !=null) {
    		preOrder(root.right);
    	}
    }
}
class TreeSolution501_1 {
    public int[] findMode(TreeNode root) {
    	
    }
}