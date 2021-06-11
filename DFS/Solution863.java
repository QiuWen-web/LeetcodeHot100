package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution863 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		TreeNode rt_l = new TreeNode(5);
		TreeNode rt_r = new TreeNode(1);
		
		TreeNode l_l = new TreeNode(6);
		TreeNode l_r = new TreeNode(2);
		TreeNode r_l = new TreeNode(0);
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
		l_l.right = m_r;
		
		dfsSolution863 s = new dfsSolution863();
		List<Integer> list = s.distanceK(root, rt_l, 2);
		for(Integer i:list) {
			System.out.print(i+",");
		}
	}

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class dfsSolution863 {
	Map<TreeNode,TreeNode> parent;
	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parent = new HashMap<>();
        dfs(root,null);
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(null);
        queue.add(target);
        
        Set<TreeNode> seen = new HashSet<TreeNode>();
        seen.add(target);
        seen.add(null);
        
        int dis = 0;
        while(!queue.isEmpty()) {
        	TreeNode node = queue.poll();
        	if(node == null) {
        		if(dis==k) {
        			List<Integer> res = new ArrayList<>();
        			for(TreeNode p:queue) {
        				res.add(p.val);
        			}
        			return res;
        		}
        		queue.add(null);
        		dis++;
        	}else {
        		if(!seen.contains(node.left)) {
        			seen.add(node.left);
        			queue.add(node.left);
        		}
        		if(!seen.contains(node.right)) {
        			seen.add(node.right);
        			queue.add(node.right);
        		}
        		TreeNode par = parent.get(node);
        		if(!seen.contains(par)) {
        			seen.add(par);
        			queue.add(par);
        		}
        	}
        	
        }
        return new ArrayList<>();
	}
	public void dfs(TreeNode root,TreeNode par) {
		if(root != null) {
			parent.put(root, par);
			dfs(root.left,root);
			dfs(root.right,root);
		}
	}
}