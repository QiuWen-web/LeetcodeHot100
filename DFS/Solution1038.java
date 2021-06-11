package DFS;

public class Solution1038 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class dfsSolution1038 {
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        //（从大到小索引）累计求和右->根->左
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