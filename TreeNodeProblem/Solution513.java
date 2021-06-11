package TreeNodeProblem;

import java.util.Deque;
import java.util.LinkedList;

public class Solution513 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
/*����һ�������������������һ���ҵ�����ߵ�ֵ��*/
class TreeSolution13 {
    public int findBottomLeftValue(TreeNode root) {
    	//������һ��ʼ�뵽�ľ��ǲ������
    	Deque<TreeNode> nodes = new LinkedList<>();
    	nodes.add(root);
    	TreeNode res = root;
    	while(!nodes.isEmpty()) {
    		int size = nodes.size();
    		while(size>0) {
    			TreeNode node = nodes.removeLast();
    			res = node;
    			//����ȷ�������
    			if(node.right != null) {
    				nodes.addFirst(node.right);
    			}
    			if(node.left != null) {
    				nodes.addFirst(node.left);
    			}
    			size--;
    		}
    	}
    	return res.val;
    }
}
class TreeSolution513_1 {
	//����ǰ�����,��¼����һ������ߵ�ֵ
    private int curMaxDepth=-1,curVal=0;
    public int findBottomLeftValue(TreeNode root) {
        help(root,0);
        return curVal;
    }
    private void help(TreeNode root,int depth){
        if(root==null){return;}
        if(depth>curMaxDepth){
            curMaxDepth=depth;
            curVal=root.val;
        }
        help(root.left,depth+1);
        help(root.right,depth+1);
    }
}
