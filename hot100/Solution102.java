package hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//����һ�������������㷵���䰴 ������� �õ��Ľڵ�ֵ�� �������أ������ҷ������нڵ㣩��
//
//ʾ����
//��������[3,9,20,null,null,15,7],
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//�������α��������
//
//[
//  [3],
//  [9,20],
//  [15,7]
//]

public class Solution102 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
}
public class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val = x;
	}
}
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
    	//���Ƚ���һ��list��ŷ��صĽ��
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	//������ڵ��ޣ��򷵻ؿյ�list
    	if(root == null) {
    		return list;
    	}
    	//����һ�������Ŷ�����
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	//�����з����һ��������
    	queue.add(root);
    	//������Ϊ��ʱ
    	while(!queue.isEmpty()) {
    		//��¼����ĳ���count��ÿ�μ�¼�����ϴα����ļ���Ķ������ĸ���;
    		int count = queue.size();
    		//�½�һ��ls���ÿһ���ֵ
    		List<Integer> ls = new ArrayList<Integer>();
    		//��������count����0ʱ
    		while(count > 0) {
    			//��queue�е�һ��Ԫ���õ�����ɾ��
    			TreeNode node = queue.poll();
    			//�������������ֵ����ls��
    			ls.add(node.val);
    			//�ж�������Ƿ��������������еĻ��������뵽����ĩβ
    			if(node.left != null) {
    				queue.add(node.left);
    			}
    			if(node.right != null) {
    				queue.add(node.right);
    			}
    			//������--
    			count--;
    		}
    		//����һ������ls���뵽list��
    		list.add(ls);
    	}
    	return list;
    }
}