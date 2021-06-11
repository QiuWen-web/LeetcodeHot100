package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class dfsSolution1110 {
    //首先肯定要遍历节点
    //如果节点在to_delete中，则先保存此节点的左右子节点，然后将其删除，将左右子节点添加到list中

    //结果
    List<TreeNode> res = new ArrayList<>();
    //parent
    Map<TreeNode,TreeNode> parent = new HashMap<>();
    //to_delete
    List<Integer> delete = new ArrayList<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for(int i =0;i<to_delete.length;i++){
            delete.add(to_delete[i]);
        }
        helper(root,null);
        res.add(root);
        dfs(root);
        
        return res;
    }
    public void helper(TreeNode node,TreeNode par) {
    	if(node!=null) {
    		parent.put(node,par);
    		helper(node.left,node);
    		helper(node.right,node);
    	}
    }
    //其次，遍历的方式采用后续遍历，这样总是删除在下面的节点。不影响res中后面子数的改变
    public void dfs(TreeNode node){
        if(node.left != null ){
            dfs(node.left);
        }
        if(node.right !=null){
            dfs(node.right);
        }
        
        if(delete.contains(node.val)) {
        	//这个节点要删除
        	//首先判断它有没有子节点
        	if(node.left!=null) {
        		res.add(node.left);
        	}
        	if(node.right!=null) {
        		res.add(node.right);
        	}
        	//再删除节点
        	TreeNode par = parent.get(node);
        	if(par == null) {
        		//即删除root节点
        		res.remove(0);
        	}else if(par.left == node) {
        		par.left = null;
        	}else if(par.right == node) {
        		par.right = null;
        	}
        }
    }
}