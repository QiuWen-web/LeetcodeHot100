package DFS;

public class Solution1038 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class dfsSolution1038 {
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        //���Ӵ�С�������ۼ������->��->��
        dfs(root);
        return root;
    }
    public void dfs(TreeNode node){
        if(node.right != null){
            dfs(node.right);
        }
        sum += node.val;
        node.val = sum;
        if(node.left != null){
            dfs(node.left);
        }
    }
}