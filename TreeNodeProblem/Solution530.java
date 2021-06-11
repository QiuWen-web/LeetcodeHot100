package TreeNodeProblem;

import java.util.ArrayList;
import java.util.List;

public class Solution530 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		TreeNode rootl = new TreeNode(3);
		TreeNode rootr = new TreeNode(6);
		TreeNode rootll = new TreeNode(1);
		TreeNode rootlr = new TreeNode(4);
		TreeNode rootrr = new TreeNode(7);

		root.left = rootl;
		root.right = rootr;
		rootl.left = rootll;
		rootl.right = rootlr;
		rootr.right = rootrr;
		
		TreeSolution530 s= new TreeSolution530();
		System.out.println(s.getMinimumDifference(root));
	}

}
//�����������������������������ڵ�Ĳ�ľ���ֵ����Сֵ
class TreeSolution530 {
	private int min = Integer.MAX_VALUE;
	private List<Integer> list = new ArrayList<>();
	//����ÿһ���ڵ���������нڵ㣬����min��ֵ
    public int getMinimumDifference(TreeNode root) {
    	midOrder(root);
    	for(int i = 0;i<list.size()-1;i++) {
    		if((list.get(i+1)-list.get(i)) < min) {
    			min = list.get(i+1)-list.get(i);
    		}
    	}
    	return min;
    }
    public void midOrder(TreeNode root) {
    	//���������������
    	if(root.left != null) {
    		midOrder(root.left);
    	}
    	list.add(root.val);
    	if(root.right != null) {
    		midOrder(root.right);
    	}
    }
}