package hot100;

import java.util.HashSet;
import java.util.Set;
/*
 * ����һ��������������ʼ�뻷�ĵ�һ���ڵ㡣 ��������޻����򷵻� null��
 * ˼·���㷨
 * һ���ǳ�ֱ�۵�˼·�ǣ�
 * ���Ǳ��������е�ÿ���ڵ㣬
 * ��������¼������һ�������˴�ǰ�������Ľڵ㣬
 * �Ϳ����ж������д��ڻ���������ϣ����Ժܷ����ʵ�֡�
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
