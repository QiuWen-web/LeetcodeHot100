package DFS;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution988 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(2);
		
		TreeNode rol = new TreeNode(2);
		TreeNode ror = new TreeNode(1);
		
		TreeNode ll = new TreeNode(1);
		TreeNode lr = new TreeNode(3);
		TreeNode rl = new TreeNode(0);
		TreeNode rr = new TreeNode(2);
		
		root.left = rol;
		root.right = ror;
		
		rol.left = ll;
		rol.right = lr;
		ror.left = rl;
		ror.right = rr;
		
		
		TreeNode root1 = new TreeNode(2);
		
		TreeNode rol1 = new TreeNode(2);
		TreeNode ror1 = new TreeNode(1);
		
		TreeNode ll1 = null;
		TreeNode lr1 = new TreeNode(1);
		TreeNode rl1 = new TreeNode(0);
		TreeNode rr1 = null;
		
		TreeNode lr1_l = new TreeNode(0);
		root1.left = rol1;
		root1.right = ror1;
		
		rol1.left = ll1;
		rol1.right = lr1;
		ror1.left = rl1;
		ror1.right = rr1;
		lr1.left = lr1_l;
		dfsSolution988 s = new dfsSolution988();
		String result = s.smallestFromLeaf(root1);
		System.out.println(result);
	}

}
class dfsSolution988 {
	//首先要找到最短层的叶子节点的node集合
	Map<TreeNode,TreeNode> parent = new HashMap<>();
	List<List<TreeNode>> leafs = new ArrayList<>();
	int min = 25;
    public String smallestFromLeaf(TreeNode root) {
    	//层序遍历找出最短一层的叶子节点
    	dfs(root,null);
    	Deque<TreeNode> queue = new LinkedList<>();
    	queue.add(root);
    	
    	while(!queue.isEmpty()) {
    		int size = queue.size();
    		//标签表示这一层的下一次是否有叶子节点
			
    		while(size>0) {
    			TreeNode node = queue.removeFirst();
    			
    			if(node.left == null && node.right == null) {
    				//如果此节点下无节点，即node为叶子节点
    				
    				List<TreeNode> temp = new ArrayList<>();
    				temp.add(node);
    				min = Math.min(min, node.val);
    				leafs.add(temp);
    			}
    			if(node.left != null) {
    				queue.addLast(node.left);
    			}
    			if(node.right != null) {
    				queue.addLast(node.right);
    			}
    			size--;
    		}
    		
    	}
    	//现在leafs中存在最短曾的几个节点，我们作比较
    	//先比较数值，小的留下，大的删除
    	
    	while(leafs.size()!=1) {
    		List<List<TreeNode>> temp = new ArrayList<>();
    		for(List<TreeNode> item : leafs) {
    			TreeNode node = item.get(item.size()-1);
    			if(node.val==min) {
    				temp.add(item);
    			}
    		}
    		min = 25;
    		for(List<TreeNode> item : temp) {
    			TreeNode node = item.get(item.size()-1);
    			TreeNode par = parent.get(node);
    			if(par == null) {
    				return helper(item);
    			}
    			min = Math.min(min, par.val);
    			item.add(parent.get(node));
    		}
    		leafs = temp;
    	}
    	List<TreeNode> res = leafs.get(0);
    	while(parent.get(res.get(res.size()-1))!=null) {
    		res.add(parent.get(res.get(res.size()-1)));
    	}
    	String result = helper(res);
    	return result;
    }
    public String helper(List<TreeNode> res) {
    	//遍历每一个node取出val找到对应的字母添加到string
    	String result = "";
    	for(TreeNode node : res) {
    		int value = node.val;
    		//0-a(98)
    		result += (char)(value+97);
    	}
    	return result;
    }
    public void dfs(TreeNode node,TreeNode par) {
    	if(node !=null) {
    		parent.put(node,par);
    		dfs(node.left,node);
    		dfs(node.right,node);
    	}
    }
}