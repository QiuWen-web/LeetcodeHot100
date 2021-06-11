package DFS;

import java.util.ArrayList;
import java.util.List;

//给定一个单链表，其中的元素按升序排序，
//将其转换为高度平衡的二叉搜索树。
public class Solution109 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(-10);
		ListNode h1 = new ListNode(-3);
		ListNode h2 = new ListNode(0);
		ListNode h3 = new ListNode(5);
		ListNode h4 = new ListNode(9);
		head.next = h1;h1.next = h2;h2.next=h3;h3.next=h4;
		dfsSolution109 s = new dfsSolution109();
		TreeNode root = s.sortedListToBST(head);
		System.out.println("完毕");
	}

}


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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

class dfsSolution109 {
    public TreeNode sortedListToBST(ListNode head) {
    	//将链表转换成列表
    	List<Integer> list = new ArrayList<>();
    	while(head != null) {
    		list.add(head.val);
    		head = head.next;
    	}
    	if(list.size()==0) {
    		return null;
    	}
    	TreeNode root = helper(list,0,list.size()-1);
    	return root;
    }
    public TreeNode helper(List<Integer> list,int start,int end) {
    	int mid = (end+start)/2;
    	TreeNode node = new TreeNode(list.get(mid));
    	if(start<mid) {
    		node.left = helper(list,start,mid-1);
    	}
    	if(mid<end) {
    		node.right = helper(list,mid+1,end);
    	}
    	return node;
    }
}