package hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
//示例：
//二叉树：[3,9,20,null,null,15,7],
//
//    3
//   / \
//  9  20
//    /  \
//   15   7
//返回其层次遍历结果：
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
    	//首先建立一个list存放返回的结果
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	//如果根节点无，则返回空的list
    	if(root == null) {
    		return list;
    	}
    	//建立一个链表存放二叉树
    	Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	//链表中放入第一个二叉树
    	queue.add(root);
    	//当链表不为空时
    	while(!queue.isEmpty()) {
    		//记录链表的长度count，每次记录的是上次遍历的加入的二叉树的个数;
    		int count = queue.size();
    		//新建一个ls存放每一层的值
    		List<Integer> ls = new ArrayList<Integer>();
    		//当链表长度count大于0时
    		while(count > 0) {
    			//将queue中第一个元素拿到，并删除
    			TreeNode node = queue.poll();
    			//将这个二叉树的值加入ls中
    			ls.add(node.val);
    			//判断这个数是否有左右子树，有的话继续加入到链表末尾
    			if(node.left != null) {
    				queue.add(node.left);
    			}
    			if(node.right != null) {
    				queue.add(node.right);
    			}
    			//链表长度--
    			count--;
    		}
    		//将第一遍历的ls加入到list中
    		list.add(ls);
    	}
    	return list;
    }
}