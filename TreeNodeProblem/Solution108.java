package TreePackage;

public class Solution108 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-10,-3,0,5,9};
		TreeSolution108 s = new TreeSolution108();
		TreeNode root = s.sortedArrayToBST(nums);
		print(root);
	}
	public static void print(TreeNode root) {
    	if(root != null) {
    		System.out.print(root.val+",");
    		print(root.left);
    		print(root.right);
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

class TreeSolution108 {
    public TreeNode sortedArrayToBST(int[] nums) {
    	int n = nums.length;
    	TreeNode root = new TreeNode(nums[n/2]);
    	root.left = lookforroot(nums,0,n/2-1);
    	root.right = lookforroot(nums,n/2+1,n-1);
    	return root;
    }
    public TreeNode lookforroot(int[] nums,int left,int right) {
    	if(left == right) {
    		return new TreeNode(nums[left]);
    	}
    	if(left > right) {
    		return null;
    	}
    	int mid = (left+right)/2;
    	TreeNode root = new TreeNode(nums[mid]);
    	root.left = lookforroot(nums,left,mid-1);
    	root.right = lookforroot(nums,mid+1,right);
    	return root;
    }
    
}