package ArrayProblem;

import java.util.HashMap;
import java.util.Map;

public class Solution106 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] inorder = {9,3,15,20,7};
		int[] postorder = {9,15,7,20,3};
		ArraySolution106 s = new ArraySolution106();
		TreeNode106 root = s.buildTree(inorder, postorder);
		System.out.println(root.val);

	}

}
class ArraySolution106 {
	int post_idx;
    int[] postorder;
    int[] inorder;
    Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    public TreeNode106 helper(int in_left, int in_right) {
        // �������û�нڵ㹹��������ˣ��ͽ���
        if (in_left > in_right) {
            return null;
        }

        // ѡ�� post_idx λ�õ�Ԫ����Ϊ��ǰ�������ڵ�
        int root_val = postorder[post_idx];
        TreeNode106 root = new TreeNode106(root_val);

        // ���� root ����λ�÷ֳ�������������
        int index = idx_map.get(root_val);

        // �±��һ
        post_idx--;
        // ����������
        root.right = helper(index + 1, in_right);
        // ����������
        root.left = helper(in_left, index - 1);
        return root;
    }

    public TreeNode106 buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        // �Ӻ�����������һ��Ԫ�ؿ�ʼ
        post_idx = postorder.length - 1;

        // ������Ԫ�أ��±꣩��ֵ�ԵĹ�ϣ��
        int idx = 0;
        for (Integer val : inorder) {
            idx_map.put(val, idx++);
        }
        
        return helper(0, inorder.length - 1);
    }
}
//�������Ľڵ㣬����ڵ�������ֵval����ڵ�left���ҽڵ�right��
//�����ָ�ֵ����
class TreeNode106 {
    int val;
    TreeNode106 left;
    TreeNode106 right;
    TreeNode106() {}
    TreeNode106(int val) { this.val = val; }
    TreeNode106(int val, TreeNode106 left, TreeNode106 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}