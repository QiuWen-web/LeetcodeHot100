package TreePackage;

import java.util.*;

public class Solution95 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSolution95 s = new TreeSolution95();
		List<TreeNode> list = s.generateTrees(3);
		for(TreeNode root:list) {
			System.out.println(root.val);
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
 
class TreeSolution95 {
    public List<TreeNode> generateTrees(int n) {
    	if(n==0) {
    		return new ArrayList<TreeNode>();
    	}
    	return builderTree(1,n);
    }
    public List<TreeNode> builderTree(int start,int end) {
    	List<TreeNode> allTrees = new LinkedList<TreeNode>();
    	if(start > end) {
    		allTrees.add(null);
    		return allTrees;
    	}
    	for(int i = start;i<=end;i++) {
    		List<TreeNode> leftTrees = builderTree(start,i-1);
    		List<TreeNode> rightTrees = builderTree(i+1,end);
    		for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
    	}
    	return allTrees;
    }
}
    
