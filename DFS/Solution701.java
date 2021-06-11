package DFS;

public class Solution701 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(4);
		TreeNode l = new TreeNode(2);
		TreeNode r = new TreeNode(7);
		TreeNode ll = new TreeNode(1);
		TreeNode lr = new TreeNode(3);
		root.left = l;
		root.right = r;
		l.left = ll;
		l.right = lr;
		
		dfsSolution701 s = new dfsSolution701();
		TreeNode res = s.insertIntoBST(root, 5);
		System.out.println("���");
	}

}
class dfsSolution701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
    	if(root == null) {
    		TreeNode res = new TreeNode(val);
    		return res;
    	}
        helper(root,val);
        return root;
    }
    public void helper(TreeNode root, int val) {
    	//�ж�val����root����һ��
    	if(root.val>val) {
    		//�ڵ����val��val�������
    		//�������нڵ�
    		if(root.left != null) {
    			helper(root.left,val);
    		}else {
    			//�޵Ļ�ֱ�Ӳ���
    			TreeNode temp = new TreeNode(val);
    			root.left = temp;
    		}
    	}else{
    		//�����ұ�
    		if(root.right != null) {
    			helper(root.right,val);
    		}else {
    			//�޵Ļ�ֱ�Ӳ���
    			TreeNode temp = new TreeNode(val);
    			root.right = temp;
    		}
    	}
    }
}