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
    //���ȿ϶�Ҫ�����ڵ�
    //����ڵ���to_delete�У����ȱ���˽ڵ�������ӽڵ㣬Ȼ����ɾ�����������ӽڵ���ӵ�list��

    //���
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
    //��Σ������ķ�ʽ���ú�����������������ɾ��������Ľڵ㡣��Ӱ��res�к��������ĸı�
    public void dfs(TreeNode node){
        if(node.left != null ){
            dfs(node.left);
        }
        if(node.right !=null){
            dfs(node.right);
        }
        
        if(delete.contains(node.val)) {
        	//����ڵ�Ҫɾ��
        	//�����ж�����û���ӽڵ�
        	if(node.left!=null) {
        		res.add(node.left);
        	}
        	if(node.right!=null) {
        		res.add(node.right);
        	}
        	//��ɾ���ڵ�
        	TreeNode par = parent.get(node);
        	if(par == null) {
        		//��ɾ��root�ڵ�
        		res.remove(0);
        	}else if(par.left == node) {
        		par.left = null;
        	}else if(par.right == node) {
        		par.right = null;
        	}
        }
    }
}