package TreeNodeProblem;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//�����������
public class Solution662 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		TreeNode rl = new TreeNode(3);
		TreeNode rr = new TreeNode(2);
		TreeNode rll = new TreeNode(5);
		
		root.left = rl;
		root.right = rr;
		rl.left = rll;
		
		TreeSolution662 s = new TreeSolution662();
		int res = s.widthOfBinaryTree(root);
		System.out.println(res);
	}

}
class TreeSolution662 {
	public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        Deque<TreeNode> deque = new LinkedList<>();
        root.val = 1;
        deque.offer(root);
        int ret = 0;
        while (! deque.isEmpty()) {
            int n = deque.size();
            ret = Math.max(ret, deque.peekLast().val - deque.peekFirst().val + 1);
            while (n-- > 0) {
                TreeNode node = deque.poll();
                // �����½���pos�򣬻���ÿ���null����β
                //�������ڣ����µ�valֵ�����ϵ�valֵ��ÿһ���node����õ���һ��Ŀ��
                if (node.left != null) {
                    node.left.val = node.val * 2 + 1;
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    node.right.val = node.val * 2 + 2;
                    deque.offer(node.right);
                }
            }
        }
        return ret;
    }
    
}