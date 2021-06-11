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
 * 简化一下这个问题：一棵二叉树，树上的每个点都有对应的权值，每个点有两种状态（选中和不选中），问在不能同时选中有父子关系的点的情况下，能选中的点的最大权值和是多少。

我们可以用 f(o)f(o) 表示选择 oo 节点的情况下，oo 节点的子树上被选择的节点的最大权值和；g(o)g(o) 表示不选择 oo 节点的情况下，oo 节点的子树上被选择的节点的最大权值和；ll 和 rr 代表 oo 的左右孩子。

当 oo 被选中时，oo 的左右孩子都不能被选中，故 oo 被选中情况下子树上被选中点的最大权值和为 ll 和 rr 不被选中的最大权值和相加，即 f(o) = g(l) + g(r)f(o)=g(l)+g(r)。
当 oo 不被选中时，oo 的左右孩子可以被选中，也可以不被选中。对于 oo 的某个具体的孩子 xx，它对 oo 的贡献是 xx 被选中和不被选中情况下权值和的较大值。故 g(o) = \max \{ f(l) , g(l)\}+\max\{ f(r) , g(r) \}g(o)=max{f(l),g(l)}+max{f(r),g(r)}。
至此，我们可以用哈希表来存 ff 和 gg 的函数值，用深度优先搜索的办法后序遍历这棵二叉树，我们就可以得到每一个节点的 ff 和 gg。根节点的 ff 和 gg 的最大值就是我们要找的答案。
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
