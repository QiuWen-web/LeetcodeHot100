package TreeNodeProblem;

import java.util.Deque;
import java.util.LinkedList;

public class Solution513 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
/*给定一个二叉树，在树的最后一行找到最左边的值。*/
class TreeSolution13 {
    public int findBottomLeftValue(TreeNode root) {
    	//这题我一开始想到的就是层序遍历
    	Deque<TreeNode> nodes = new LinkedList<>();
    	nodes.add(root);
    	TreeNode res = root;
    	while(!nodes.isEmpty()) {
    		int size = nodes.size();
    		while(size>0) {
    			TreeNode node = nodes.removeLast();
    			res = node;
    			//这边先放右子树
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
	//利用前序遍历,记录最深一层最左边的值
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
