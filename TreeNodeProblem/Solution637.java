package TreeNodeProblem;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//�������Ĳ�ƽ��ֵ
public class Solution637 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode s = new TreeNode(3);
		TreeNode sl = new TreeNode(9);
		TreeNode sr = new TreeNode(20);
		TreeNode srl = new TreeNode(15);
		TreeNode srr = new TreeNode(7);
		s.left = sl;
		s.right = sr;
		sr.left = srl;
		sr.right = srr;
		TreeSolution637 res = new TreeSolution637();
		List<Double> result = res.averageOfLevels(s);
		for(int i =0;i<result.size();i++) {
			System.out.println(result.get(i));
		}
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
class TreeSolution637 {
    public List<Double> averageOfLevels(TreeNode root) {
    	//��Ŀ˵���Ƿǿն���������˿��Բ��ж��Ƿ�Ϊ��
    	//��������ĸļ���
    	Deque<TreeNode> nodes = new LinkedList<>();
    	nodes.add(root);
    	List<Double> result = new ArrayList<>();
    	
    	while(!nodes.isEmpty()) {
    		//ÿһ��ڵ����
    		int size = nodes.size();
    		int length = size;
    		//ÿһ��ڵ�ֵ��ʼ��
    		double floorsum = 0;
    		while(size>0) {
    			TreeNode node = nodes.removeFirst();
    			floorsum += node.val;
    			if(node.left != null) {
    				nodes.add(node.left);
    			}
    			if(node.right != null) {
    				nodes.add(node.right);
    			}
    			size--;
    		}
    		//����ͺõ�ÿ��ֵƽ������ӵ�result��
    		result.add(floorsum/length);
    	}
    	return result;
    }
}