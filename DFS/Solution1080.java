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
    //ǰ��������ۼӽڵ�ֵ������ĩβʱ�ж��Ƿ�С��limit
    int sum = 0;
    //�Ҿ�����Ҫһ��״̬����ӳ�˽ڵ��Ƿ��������
    Map<TreeNode,Boolean> flag = new HashMap<>();
    //����limit
    int limit;
    //parent
    Map<TreeNode,TreeNode> parent = new HashMap<>();
    TreeNode root;
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        helper(root,null);
        this.root = root;
        this.limit = limit;
        dfs(root);
        //����ÿһ���ڵ��Ͻ�µ�Ҷ�ӽڵ��Ƿ���false�������ɾ������ڵ�
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
        //�������
        //�������ڵ��µ�Ҷ�ӽڵ㶼Ϊfalse;ɾ������ڵ�
        if(!condition(node)){
            //���node��״̬��Ϊfalse;��ɾ���ڵ�
            TreeNode par = parent.get(node);
            if(par == null){
                //��Ϊ���ڵ�
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
            //���node��״̬Ϊture����ʾ�ӽڵ��з��������ģ�Ӧ����������
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
    //��ÿһ���ڵ������һ�ڵ㵽�����ۼ�ֵ�Ƿ����limit��һ�����
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