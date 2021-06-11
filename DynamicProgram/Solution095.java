package DynamicProgram;

public class Solution095 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class DynamicSolution095 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> allTrees = new LinkedList<TreeNode>();
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // ö�ٿ��и��ڵ�
        for (int i = start; i <= end; i++) {
            // ������п��е�����������
            List<TreeNode> leftTrees = generateTrees(start, i - 1);

            // ������п��е�����������
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            // ��������������ѡ��һ������������������������ѡ��һ����������ƴ�ӵ����ڵ���
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currTree = new TreeNode(i);
                    currTree.left = left;
                    currTree.right = right;
                    allTrees.add(currTree);
                }
            }
        }
        return allTrees;
    }
}
��