package TreeNodeProblem;

import java.util.Deque;
import java.util.LinkedList;

//�ڶ�����������һ��
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
		System.out.println("���TreeSolution623");
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
    	//������������d�ڡ�1��max��ȡ�֮��
    	//���ֻҪ�ж�������� d==1��d��=1�����
    	
    	//����root������һ���ڵ��ʾroot��Ϊnull
    	//����ֱ����root
    	if(depth == 1) {
    		TreeNode v = new TreeNode(val);
    		v.left = root;
    		return v;
    	}
    	
    	//�ڶ������
    	//����Ѱ�ҵ���d-1��
    	Deque<TreeNode> nodes = new LinkedList<>();
    	nodes.add(root);
    	int curfloor = 1;
    	while(!nodes.isEmpty()) {
    		int size = nodes.size();
    		if(curfloor == depth-1) {
    			//nodes�������d-1���ÿ���ڵ�
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
    	//��ʱnodes�������d-1���ÿ���ڵ�
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