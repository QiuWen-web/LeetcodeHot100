package DynamicProgram;

public class Solution1367 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DynamicListNode1367 head = new DynamicListNode1367(4);
		DynamicListNode1367 second = new DynamicListNode1367(2);
		DynamicListNode1367 third = new DynamicListNode1367(8);
		head.next = second;
		second.next = third;
		DynamicTreeNode1367 root = new DynamicTreeNode1367(1);
		DynamicTreeNode1367 dot1 = new DynamicTreeNode1367(4);
		DynamicTreeNode1367 dot2 = new DynamicTreeNode1367(4);
		DynamicTreeNode1367 dot3 = new DynamicTreeNode1367(2);
		DynamicTreeNode1367 dot4 = new DynamicTreeNode1367(2);
		DynamicTreeNode1367 dot5 = new DynamicTreeNode1367(1);
		DynamicTreeNode1367 dot6 = new DynamicTreeNode1367(6);
		DynamicTreeNode1367 dot7 = new DynamicTreeNode1367(8);
		DynamicTreeNode1367 dot8 = new DynamicTreeNode1367(1);
		DynamicTreeNode1367 dot9 = new DynamicTreeNode1367(3);
		root.left = dot1;
		root.right = dot2;
		dot1.right = dot3;
		dot2.left = dot4;
		dot3.left = dot5;
		dot4.left = dot6;
		dot4.right = dot7;
		dot7.left = dot8;
		dot7.right = dot9;
		DynamicSolution1367 s =new DynamicSolution1367();
		System.out.println(s.isSubPath(head, root));
	}

}
class DynamicSolution1367 {
	public boolean isSubPath(DynamicListNode1367 head, DynamicTreeNode1367 root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        //���жϵ�ǰ�Ľڵ㣬������ԣ��ٿ�����������������
        return isSub(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean isSub(DynamicListNode1367 head, DynamicTreeNode1367 node) {
        //���У����������ˣ�����true
        if (head == null) {
            return true;
        }
        //���У�����û���꣬�������ˣ���϶����У�����false
        if (node == null) {
            return false;
        }
        //���ֵ��ͬ���ض����ǰ�
        if (head.val != node.val) {
            return false;
        }
        //���ֵ��ͬ������������ߺ��ұ���һ�����㼴��
        return isSub(head.next, node.left) || isSub(head.next, node.right);
    }

}


class DynamicListNode1367 {
     int val;
     DynamicListNode1367 next;
     DynamicListNode1367() {}
     DynamicListNode1367(int val) { this.val = val; }
     DynamicListNode1367(int val, DynamicListNode1367 next) { this.val = val; this.next = next; }
}
 

class DynamicTreeNode1367 {
    int val;
    DynamicTreeNode1367 left;
    DynamicTreeNode1367 right;
    DynamicTreeNode1367() {}
    DynamicTreeNode1367(int val) { this.val = val; }
    DynamicTreeNode1367(int val, DynamicTreeNode1367 left, DynamicTreeNode1367 right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
