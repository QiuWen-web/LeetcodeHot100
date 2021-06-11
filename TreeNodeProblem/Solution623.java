package TreeNodeProblem;

import java.util.Deque;
import java.util.LinkedList;

//在二叉树中增加一行
public class Solution623 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode s = new TreeNode(4);
		TreeNode sl = new TreeNode(2);
		TreeNode slr = new TreeNode(1);
		TreeNode sll = new TreeNode(3);
		
		s.left = sl;
		sl.right = slr;
		sl.left=sll;
		
		TreeSolution623 res = new TreeSolution623();
		TreeNode result = res.addOneRow(s, 1, 3);
		System.out.println("完成TreeSolution623");
	}

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class TreeSolution623 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
    	//由于输入的深度d在【1，max深度】之间
    	//因此只要判定两种情况 d==1和d！=1的情况
    	
    	//此外root至少有一个节点表示root不为null
    	//可以直接用root
    	if(depth == 1) {
    		TreeNode v = new TreeNode(val);
    		v.left = root;
    		return v;
    	}
    	
    	//第二种情况
    	//首先寻找到第d-1层
    	Deque<TreeNode> nodes = new LinkedList<>();
    	nodes.add(root);
    	int curfloor = 1;
    	while(!nodes.isEmpty()) {
    		int size = nodes.size();
    		if(curfloor == depth-1) {
    			//nodes保存的是d-1层的每个节点
    			break;
    		}
    		while(size>0) {
    			TreeNode node = nodes.removeFirst();
    			if(node.left != null) {
    				nodes.add(node.left);
    			}
    			if(node.right != null) {
    				nodes.add(node.right);
    			}
    			size--;
    		}
    		curfloor++;
    	}
    	//此时nodes保存的是d-1层的每个节点
    	int size = nodes.size();
    	while(size>0) {
			TreeNode node = nodes.removeFirst();
			TreeNode templeft = new TreeNode(val);
			TreeNode tempright = new TreeNode(val);
			if(node.left != null) {
				TreeNode temp = node.left;
				node.left = templeft;
				templeft.left = temp;
			}else {
				node.left = templeft;
			}
			if(node.right != null) {
				TreeNode temp = node.right;
				node.right = tempright;
				tempright.right = temp;
			}else {
				node.right = tempright;
			}
			size--;
		}
    	return root;
    }
}