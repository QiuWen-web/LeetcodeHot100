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
	//����Ҫ�ҵ���̲��Ҷ�ӽڵ��node����
	Map<TreeNode,TreeNode> parent = new HashMap<>();
	List<List<TreeNode>> leafs = new ArrayList<>();
	int min = 25;
    public String smallestFromLeaf(TreeNode root) {
    	//��������ҳ����һ���Ҷ�ӽڵ�
    	dfs(root,null);
    	Deque<TreeNode> queue = new LinkedList<>();
    	queue.add(root);
    	
    	while(!queue.isEmpty()) {
    		int size = queue.size();
    		//��ǩ��ʾ��һ�����һ���Ƿ���Ҷ�ӽڵ�
			
    		while(size>0) {
    			TreeNode node = queue.removeFirst();
    			
    			if(node.left == null && node.right == null) {
    				//����˽ڵ����޽ڵ㣬��nodeΪҶ�ӽڵ�
    				
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
    	//����leafs�д���������ļ����ڵ㣬�������Ƚ�
    	//�ȱȽ���ֵ��С�����£����ɾ��
    	
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
    	//����ÿһ��nodeȡ��val�ҵ���Ӧ����ĸ��ӵ�string
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