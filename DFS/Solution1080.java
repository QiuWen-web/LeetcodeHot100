package DFS;

import java.util.HashMap;
import java.util.Map;

public class Solution1080 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(10);
		
		TreeNode rl = new TreeNode(5);
		TreeNode rr = new TreeNode(10);
		root.left = rl;
		root.right = rr;
		dfsSolution1080 s = new dfsSolution1080();
		TreeNode res = s.sufficientSubset(root, 21);
	}

}
class dfsSolution1080 {
    //前序遍历，累加节点值，当到末尾时判断是否小于limit
    int sum = 0;
    //我觉得需要一个状态来反映此节点是否符合条件
    Map<TreeNode,Boolean> flag = new HashMap<>();
    //保存limit
    int limit;
    //parent
    Map<TreeNode,TreeNode> parent = new HashMap<>();
    TreeNode root;
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        helper(root,null);
        this.root = root;
        this.limit = limit;
        dfs(root);
        //遍历每一个节点管辖下的叶子节点是否都是false，如果是删除这个节点
        delete(root);
        return this.root;
    }
    public void helper(TreeNode node,TreeNode par){
        if(node != null){
            parent.put(node,par);
            helper(node.left,node);
            helper(node.right,node);
        }
    }
    public void delete(TreeNode node){
        //中序遍历
        //如果这个节点下的叶子节点都为false;删除这个节点
        if(!condition(node)){
            //如果node的状态都为false;则删除节点
            TreeNode par = parent.get(node);
            if(par == null){
                //即为根节点
                root = null;
            }else{
                if(par.left == node){
                    par.left = null;
                }
                if(par.right == node){
                    par.right = null;
                }
            }
        }else{
            //如果node的状态为ture，表示子节点有符合条件的，应该深入搜索
            if(node.left != null){
                delete(node.left);
            }
            if(node.right != null){
                delete(node.right);
            }
        }
       
    }
    public boolean condition(TreeNode node){
        if(node.left == null && node.right == null){
            return flag.get(node);
        }else if(node.left == null && node.right != null){
            return condition(node.right);
        }else if(node.right == null && node.left != null){
            return condition(node.left);
        }else{
            return condition(node.left)||condition(node.right);
        }

    }
    //给每一个节点添加这一节点到根的累计值是否大于limit的一个标记
    public void dfs(TreeNode node){
        sum += node.val;
        if(node.left != null){
            dfs(node.left);
        }
        if(node.right != null){
            dfs(node.right);
        }
        if(sum<limit){
            flag.put(node,false);
        }else{
            flag.put(node,true);
        }
        sum -= node.val;
    }
}