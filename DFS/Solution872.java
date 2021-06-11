package DFS;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution872 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		TreeNode rt_l = new TreeNode(5);
		TreeNode rt_r = new TreeNode(1);
		
		TreeNode l_l = new TreeNode(6);
		TreeNode l_r = new TreeNode(2);
		TreeNode r_l = new TreeNode(9);
		TreeNode r_r = new TreeNode(8);
		
		TreeNode m_l = new TreeNode(7);
		TreeNode m_r = new TreeNode(4);
		
		root.left = rt_l;
		root.right = rt_r;
		
		rt_l.left = l_l;
		rt_l.right = l_r;
		rt_r.left = r_l;
		rt_r.right = r_r;
		
		l_r.left = m_l;
		l_r.right = m_r;
		
		TreeNode root1 = new TreeNode(3);
		TreeNode rt_l1 = new TreeNode(5);
		TreeNode rt_r1 = new TreeNode(1);
		
		TreeNode l_l1 = new TreeNode(6);
		TreeNode l_r1 = new TreeNode(7);
		TreeNode r_l1 = new TreeNode(4);
		TreeNode r_r1 = new TreeNode(2);
		
		TreeNode m_l1 = new TreeNode(9);
		TreeNode m_r1 = new TreeNode(8);
		
		root1.left = rt_l1;
		root1.right = rt_r1;
		
		rt_l1.left = l_l1;
		rt_l1.right = l_r1;
		rt_r1.left = r_l1;
		rt_r1.right = r_r1;
		
		r_r1.left = m_l1;
		r_r1.right = m_r1;
		
		dfsSolution872 s = new dfsSolution872();
		boolean flag = s.leafSimilar(root, root1);
		System.out.println(flag);
	}

}
class dfsSolution872 {
	
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    	//µ¯Õ»²Ù×÷
    	Stack<TreeNode> st1 = new Stack<>();
    	Stack<TreeNode> st2 = new Stack<>();
    	List<TreeNode> res1 = leaf(root1,st1);
    	List<TreeNode> res2 = leaf(root2,st2);
    	int size1 = res1.size();
    	int size2 = res2.size();
    	if(size1 != size2) {
    		return false;
    	}else {
    		for(int i = 0;i<size1;i++) {
    			if(res1.get(i).val != res2.get(i).val) {
    				return false;
    			}
    		}
    		return true;
    	}
    }
    public List<TreeNode> leaf(TreeNode root1,Stack<TreeNode> st1){
    	List<TreeNode> res = new ArrayList<>();
    	st1.push(root1);
    	while(!st1.isEmpty()) {
    		TreeNode node = st1.pop();
    		if(node.left == null && node.right == null) {
    			res.add(node);
    		}else {
    			if(node.left != null) {
    				st1.push(node.left);
    			}
    			if(node.right != null) {
    				st1.push(node.right);
    			}
    		}
    	}
    	return res;
    }
}