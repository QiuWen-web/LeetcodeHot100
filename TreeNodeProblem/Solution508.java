package TreeNodeProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Solution508 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		TreeNode rootl = new TreeNode(3);
		TreeNode rootr = new TreeNode(6);
		TreeNode rootll = new TreeNode(3);
		TreeNode rootlr = new TreeNode(6);
		TreeNode rootrr = new TreeNode(6);

		root.left = rootl;
		root.right = rootr;
		rootl.left = rootll;
		rootl.right = rootlr;
		rootr.right = rootrr;
		TreeSolution508 s = new TreeSolution508();
		int[] res = s.findFrequentTreeSum(root);
		for(int i : res) {
			System.out.println(i);
		}
	}

}
class TreeSolution508 {
//	int sum = 0;
	private List<Integer> list = new ArrayList<>();
	private Map<Integer,Integer> map = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
    	addmap(root);
    	//list存储了所有的值
    	//在list中寻找出现的最多次数的数
    	int max = 0;
    	for(Entry<Integer,Integer> entry:map.entrySet()) {
    		if(max<entry.getValue()) {
    			max = entry.getValue();
    		}
    	}
    	for(Entry<Integer,Integer> entry:map.entrySet()) {
    		if(max==entry.getValue()) {
    			list.add(entry.getKey());
    		}
    	}
    	int[] re = new int[list.size()];
    	for(int i = 0;i<list.size();i++) {
    		re[i] = list.get(i);
    	}
    	return re;
    }
    public void addmap(TreeNode root) {
    	if(root != null) {
    		int sum = preOrder(root,0);
    		map.put(sum, map.getOrDefault(sum, 0)+1);
    		addmap(root.left);
    		addmap(root.right);
    	}
    }
    public int preOrder(TreeNode root,int sum) {
    	//以root为根节点的所有节点和
    	sum += root.val;
    	
    	if(root.left != null) {
    		sum = preOrder(root.left,sum);
    	}
    	if(root.right != null) {
    		sum = preOrder(root.right,sum);
    	}
    	
    	return sum;
    	
    }
}