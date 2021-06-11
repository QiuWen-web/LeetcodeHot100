package DFS;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution865 {

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
		l_r.right = m_r;
		
		dfsSolution865 s = new dfsSolution865();
		TreeNode res = s.subtreeWithAllDeepest(root);
		System.out.println(res.val);
	}

}
class dfsSolution865 {
	Map<TreeNode,TreeNode> parent;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
    	
    	parent = new HashMap<>();
        dfs(root,null);
        int dep = depth(root);
        //层序遍历找最后一层的节点啊
        List<TreeNode> list = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int cur = 1;
        while(!queue.isEmpty()) {
        	int size = queue.size();
        	if(cur == dep) {
        		
        		for(TreeNode node : queue) {
        			list.add(node);
        		}
        		break;
        	}else {
        		while(size>0) {
        			TreeNode node = queue.removeLast();
        			if(node.left != null) {
        				queue.addFirst(node.left);
        			}
        			if(node.right != null) {
        				queue.addFirst(node.right);
        			}
        			size--;
        		}
        	}
        	
        	cur++;
        }
        
        //拿到最小父节点
        TreeNode res = helper(list);
        return res;
    }
    public TreeNode helper(List<TreeNode> list) {
    	int size = list.size();
    	if(size==1) {
    		return list.get(0);
    	}else {
    		return helper01(list);
    	}
    	
    }
    public TreeNode helper01(List<TreeNode> list) {
    	int size = list.size();
    	boolean flag = false;
    	for(int i = 0;i<size-1;i++) {
    		if(list.get(i).val != list.get(i+1).val) {
    			flag = true;
    			break;
    		}
    	}
    	if(flag) {
    		List<TreeNode> temp = new ArrayList<>();
    		for(TreeNode node:list) {
    			
    			temp.add(parent.get(node));
    		}
    		return helper01(temp);
    	}else {
    		return list.get(0);
    	}
    }
    public void dfs(TreeNode root,TreeNode par) {
		if(root != null) {
			parent.put(root, par);
			dfs(root.left,root);
			dfs(root.right,root);
		}
	}
    public int depth(TreeNode node) {
    	if(node == null) {
    		return 0;
    	}else {
    		int a = depth(node.left);
    		int b = depth(node.right);
    		return Math.max(a, b)+1;
    	}
    	
    }
}