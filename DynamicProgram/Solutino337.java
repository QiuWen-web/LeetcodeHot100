package DynamicProgram;

import java.util.*;

import hot100.TreeNode;

public class Solutino337 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
 * ��һ��������⣺һ�ö����������ϵ�ÿ���㶼�ж�Ӧ��Ȩֵ��ÿ����������״̬��ѡ�кͲ�ѡ�У������ڲ���ͬʱѡ���и��ӹ�ϵ�ĵ������£���ѡ�еĵ�����Ȩֵ���Ƕ��١�

���ǿ����� f(o)f(o) ��ʾѡ�� oo �ڵ������£�oo �ڵ�������ϱ�ѡ��Ľڵ�����Ȩֵ�ͣ�g(o)g(o) ��ʾ��ѡ�� oo �ڵ������£�oo �ڵ�������ϱ�ѡ��Ľڵ�����Ȩֵ�ͣ�ll �� rr ���� oo �����Һ��ӡ�

�� oo ��ѡ��ʱ��oo �����Һ��Ӷ����ܱ�ѡ�У��� oo ��ѡ������������ϱ�ѡ�е�����Ȩֵ��Ϊ ll �� rr ����ѡ�е����Ȩֵ����ӣ��� f(o) = g(l) + g(r)f(o)=g(l)+g(r)��
�� oo ����ѡ��ʱ��oo �����Һ��ӿ��Ա�ѡ�У�Ҳ���Բ���ѡ�С����� oo ��ĳ������ĺ��� xx������ oo �Ĺ����� xx ��ѡ�кͲ���ѡ�������Ȩֵ�͵Ľϴ�ֵ���� g(o) = \max \{ f(l) , g(l)\}+\max\{ f(r) , g(r) \}g(o)=max{f(l),g(l)}+max{f(r),g(r)}��
���ˣ����ǿ����ù�ϣ������ ff �� gg �ĺ���ֵ����������������İ취���������ö����������ǾͿ��Եõ�ÿһ���ڵ�� ff �� gg�����ڵ�� ff �� gg �����ֵ��������Ҫ�ҵĴ𰸡�
*/
class DynamicSolution337 {
    Map<TreeNode,Integer> f = new HashMap<>();
    Map<TreeNode,Integer> g = new HashMap<>();
    public int rob(TreeNode root) {
    	dsf(root);
    	return Math.max(f.getOrDefault(root, 0), g.getOrDefault(root, 0));
    }
    public dsf(TreeNode root) {
    	if(root == null) {
    		return;
    	}
    	dsf(root.left);
    	dsf(root.right);
    	f.put(root, root.val+g.getOrDefault(root.left, 0)+g.getOrDefault(root.right, 0));
    	g.put(root, Math.max(Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0)) + Math.max(f.getOrDefault(node.right, 0), g.getOrDefault(node.right, 0)));
    }
}
