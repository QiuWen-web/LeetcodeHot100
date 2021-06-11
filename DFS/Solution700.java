package DFS;

public class Solution700 {

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
		
		dfsSolution700 s = new dfsSolution700();
		TreeNode res = s.searchBST(root, 5);
		System.out.println("���");
	}

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
class dfsSolution700 {
    public TreeNode searchBST(TreeNode root, int val) {
    	if(root != null) {
    		if(root.val>val) {
    			//�����ʱ�Ľڵ�ֵ����ҪѰ�ҵ�ֵ����Ѱ�Ҵ˽ڵ�����ӽڵ�
    			return searchBST(root.left,val);
    		}else if(root.val<val){
    			//����ڵ�ֵС��ҪѰ�ҵ�val����Ѱ�������ӽڵ�
    			return searchBST(root.right,val);
    		}else if(root.val == val){
    			//������
    			return root;
    		}
    	}
    	return null;
    }
}