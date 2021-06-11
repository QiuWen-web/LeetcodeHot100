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
        // 如果这里没有节点构造二叉树了，就结束
        if (in_left > in_right) {
            return null;
        }

        // 选择 post_idx 位置的元素作为当前子树根节点
        int root_val = postorder[post_idx];
        TreeNode106 root = new TreeNode106(root_val);

        // 根据 root 所在位置分成左右两棵子树
        int index = idx_map.get(root_val);

        // 下标减一
        post_idx--;
        // 构造右子树
        root.right = helper(index + 1, in_right);
        // 构造左子树
        root.left = helper(in_left, index - 1);
        return root;
    }

    public TreeNode106 buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        this.inorder = inorder;
        // 从后序遍历的最后一个元素开始
        post_idx = postorder.length - 1;

        // 建立（元素，下标）键值对的哈希表
        int idx = 0;
        for (Integer val : inorder) {
            idx_map.put(val, idx++);
        }
        
        return helper(0, inorder.length - 1);
    }
}
//建立树的节点，这个节点里面有值val，左节点left，右节点right，
//和两种赋值方法
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