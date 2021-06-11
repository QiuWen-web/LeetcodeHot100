package hot100;

import java.util.Stack;

public class Solution234 {
	public static void main(String[] args) {
		ListNode listNode1 = new ListNode(1);
		listNode1.next = new ListNode(2);
		listNode1.next.next = new ListNode(2);
		listNode1.next.next.next = new ListNode(1);
		Solution solution = new Solution();
		boolean flag = solution.isPalindrome(listNode1);
		System.out.println(flag);
	}
}
class Solution{
	public boolean isPalindrome(ListNode head) {
		Stack<ListNode> stack = new Stack<ListNode>();

        ListNode temp = head;

		if(temp == null) {
			return true;
		}
		
		while(temp != null) {
			stack.push(temp);
            
			temp = temp.next;
            
		}

		while(stack.pop().val == head.val) {
			
			head = head.next;
            if(head == null){

                return true;
            }
		}

		return false;
	}
}
class ListNode{
	int val;
	ListNode next;
	ListNode(int x){
		val = x;
	}
}