package DynamicProgram;

public class Solution1130 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {6,2,4};
		DynamicSolution1130 s = new DynamicSolution1130();
		System.out.println(s.mctFromLeafValues(arr));
	}

}
class DynamicSolution1130 {
    public int mctFromLeafValues(int[] arr) {
        //1. 状态:左右子树叶节点的个数;选择:节点划分（哪些属于左子树/哪些属于右子树）
        //2. dp[i][j]=x; i数组下标起始点，j表示数组下标终点
        int len = arr.length;
        int[][] dp = new int[len][len];
        //3. base case
        /*由于非叶节点的值是左右子树分别最大叶节点的值乘积，所以需要知道各个区间内最值*/
        /*由于要求最小代价生成树，所以期望每个非叶节点都尽可能小，所以需要对dp初始化*/   
        int[][] maxVal = new int[len][len];
        for (int i = 0;i < len;i++)
            maxVal[i][i] = arr[i];
        for (int i = 0;i < len; i++){
            for (int j = i+1; j < len; j++){
                maxVal[i][j] = Math.max(maxVal[i][j-1],arr[j]);
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        //4. 状态转移
        for (int l = 1; l < len; l++){//l=j-i （长度）
            for (int i = 0; i < len-l; i++){//起始点i,终点i+l-1
                for (int k = i; k < i+l; k++){//中间分割点（根）
                    dp[i][i+l] = Math.min(dp[i][i+l],dp[i][k] + dp[k+1][i+l] + maxVal[i][k] * maxVal[k+1][i+l]);
                }
            }

        }

        return dp[0][len-1];
    }
}