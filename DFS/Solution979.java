package DFS;

public class Solution979 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class dfsSolution979 {
	int ans = 0;
    public int distributeCoins(TreeNode root) {
    	dfs(root);
    	return ans;
    }
    public int dfs(TreeNode node) {
    	if(node == null) {
    		return 0;
    	}
    	int L = dfs(node.left);
    	int R = dfs(node.right);
    	ans += Math.abs(L)+Math.abs(R);
    	return node.val+L+R-1;
    }
}