package hot100;

import java.util.HashSet;
import java.util.Set;
/*
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 思路与算法
 * 一个非常直观的思路是：
 * 我们遍历链表中的每个节点，
 * 并将它记录下来；一旦遇到了此前遍历过的节点，
 * 就可以判定链表中存在环。借助哈希表可以很方便地实现。
  */
public class Solution142 {
	public static void main(String[] args) {
		
		
	}
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
		val = x;
		next = null;
		}
	}
	public static ListNode detectCycle(ListNode head) {
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<>();
        while(pos != null) {
        	if(visited.contains(pos)) {
        		return pos;
        	}else {
        		visited.add(pos);
        	}
        	pos = head.next;
        }
        return null;
    }
}
