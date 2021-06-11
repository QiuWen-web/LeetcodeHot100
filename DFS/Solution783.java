package DFS;

import java.util.ArrayList;
import java.util.List;

public class Solution783 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(4);
		TreeNode l = new TreeNode(2);
		TreeNode r = new TreeNode(7);
		TreeNode ll = new TreeNode(1);
		TreeNode lr = new TreeNode(3);
		root.left = l;
		root.right = r;
		l.left = ll;
		l.right = lr;
		
		dfsSolution783 s = new dfsSolution783();
		int res = s.minDiffInBST(root);
		System.out.println(res);
	}

}
class dfsSolution783 {
	int min = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
    	if(root == null) {
    		return min;
    	}
    	//���ȣ��ڵ���Ŀ��2-100֮�䣬��ض�����Сֵ
    	if(root.left != null) {
    		min =Math.min(min, Math.abs(root.val - root.left.val));
    	}
    	if(root.right != null) {
    		min =Math.min(min, Math.abs(root.val - root.right.val));
    	}
    	min = Math.min(min, minDiffInBST(root.left));
    	min = Math.min(min, minDiffInBST(root.right));
    	return min;
    }
    List<Integer> list = new ArrayList<>();
    public int minDiffInBST01(TreeNode root) {
    	//�������нڵ㣬����(ǰ�����)�ȴ�С����
    	preOrder(root);
    	int m = Integer.MAX_VALUE;
    	for(int i = 0;i<list.size()-1;i++) {
    		m = Math.max(list.get(i+1)-list.get(i), m);
    	}
    	return m;
    }
    public void preOrder(TreeNode root) {
    	if(root.left != null) {
    		preOrder(root.left);
    	}
    	list.add(root.val);
    	if(root.right != null) {
    		preOrder(root.right);
    	}
    }
}