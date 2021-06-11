package hot100;

import java.util.HashMap;
import java.util.Map;

//根据一棵树的前序遍历与中序遍历构造二叉树。
//
//注意:
//你可以假设树中没有重复的元素。
//
//例如，给出
//
//前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//返回如下的二叉树：
//
//    3
//   / \
//  9  20
//    /  \
//   15   7

public class Solution105 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	int prelen = preorder.length;
    	int inlen = inorder.length;
    	if(prelen != inlen) {
    		throw new RuntimeException("Incorrect input data");
    	}
    	Map<Integer,Integer> map = new HashMap<>(prelen);
    	//前序遍历preorder第一个数为根节点，中序遍历根节点的左边为左子树
    	//右边为右子树，所以我们建立一个map，来表示中序遍历的索引和值，
    	//当取出前序遍历根节点，就可知道中序遍历中根节点的索引值
    	for(int i = 0;i<inlen;i++) {
    		map.put(inorder[i],i);
    	}
    	return buildTree(preorder,0,prelen-1,map,0,inlen-1);
    }
    //preoder为前序遍历,preLeft-preRight为未遍历的节点，inLeft，inRight
    private TreeNode buildTree(int[] preorder,int preLeft,int preRight,Map<Integer,Integer> map,int inLeft,int inRight) {
    	//结束条件
    	if(preLeft > preRight || inLeft > inRight) {
    		return null;
    	}
    	
    	int rootVal = preorder[preLeft];
    	TreeNode root = new TreeNode(rootVal);
    	int pIndex = map.get(rootVal);
    	
    	//preoder为前序遍历,preLeft+1，pIndex-inLeft+preLeft为左子节点树，inLeft,pIndex-1为中序遍历左子节点树
    	root.left = buildTree(preorder,preLeft+1,pIndex-inLeft+preLeft,map,inLeft,pIndex-1);
    	//preoder为前序遍历,pIndex-inLeft+preLeft+1,preRight为右子节点树，pIndex+1,inRight为中序遍历右子节点树
    	root.right = buildTree(preorder,pIndex-inLeft+preLeft+1,preRight,map,pIndex+1,inRight);
    	return root;
    }
}