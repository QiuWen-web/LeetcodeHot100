package DFS;

import java.util.ArrayList;
import java.util.List;

public class Solution938 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class dfsSolution938 {
	List<Integer> list = new ArrayList<>();
	int sum=0;
	int low;
	int high;
    public int rangeSumBST(TreeNode root, int low, int high) {
    	this.low=low;
    	this.high=high;
    	midOrder(root);
    	
    	return sum;
    }
    public void midOrder(TreeNode root) {
    	if(root.left !=null) {
    		midOrder(root.left);
    	}
    	
    	if(root.val>=low&&root.val<=high) {
			sum+=root.val;
		}
    	if(root.right != null) {
    		midOrder(root.right);
    	}
    }
}