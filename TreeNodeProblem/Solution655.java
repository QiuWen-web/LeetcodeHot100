package TreeNodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution655 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 4;
    	int n = 1;
    	for(int i = 1;i<m;i++) {
    		n += 2<<(i-1);
    	}
    	System.out.println(m);
    	System.out.println(n);
	}

}
class TreeSolution655 {
	public List<List<String>> printTree(TreeNode root) {
		//得到树的深度
        int height = getHeight(root);
        String[][] res = new String[height][(1 << height) - 1];
        //得到数组
        for(String[] arr:res)
            Arrays.fill(arr,"");
        //对每一个元素设为"";
        //新建一个结果容器
        List<List<String>> ans = new ArrayList<>();
        //递归填充，在第0行的0-res[0].length列填充root的值
        fill(res, root, 0, 0, res[0].length);
        //最后将数据转换成需要的形式返回
        for(String[] arr:res)
            ans.add(Arrays.asList(arr));
        return ans;
    }
    public void fill(String[][] res, TreeNode root, int i, int l, int r) {
        //如果root为null返回
    	if (root == null)
            return;
    	//跟新第i行第j列为root的值；
        res[i][(l + r) / 2] = "" + root.val;
        //递归填充root.left和root.right的左右子树；
        fill(res, root.left, i + 1, l, (l + r) / 2);
        fill(res, root.right, i + 1, (l + r + 1) / 2, r);
    }
    //树的深度代码
    public int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}