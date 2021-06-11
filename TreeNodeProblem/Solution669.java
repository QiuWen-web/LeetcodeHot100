package TreeNodeProblem;
//�޼�����������
public class Solution669 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		TreeNode rl = new TreeNode(0);
		TreeNode rr = new TreeNode(4);
		TreeNode rlr = new TreeNode(2);
		TreeNode rlrl = new TreeNode(1);
		
		root.left = rl;
		root.right = rr;
		rl.right = rlr;
		rlr.left =rlrl;
		TreeSolution669 s = new TreeSolution669();
		TreeNode res = s.trimBST(root, 1, 3);
		System.out.println();
	}

}
class TreeSolution669 {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return root;
        //����ڵ�ֵ�����ұ߽磬�������������޽�
        if (root.val > R) return trimBST(root.left, L, R);
      //����ڵ�ֵС����߽磬�������������޽�
        if (root.val < L) return trimBST(root.right, L, R);
        //������������������������������޽�
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}