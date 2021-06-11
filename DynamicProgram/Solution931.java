package DynamicProgram;

public class Solution931 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{2,1,3},{6,5,4},{7,8,9}};
		int[][] matrix1 = {{-19,57},{-40,-5}};
		int[][] matrix2 = {{-48}};
		DynamicSolution931 s = new DynamicSolution931();
		System.out.println(s.minFallingPathSum(matrix2));
	}

}
class DynamicSolution931 {
    public int minFallingPathSum(int[][] matrix) {
    	int n = matrix.length;
    	int[][] dp = new int[n][n];
    	//≥ı ºªØdp
    	for(int i = 0;i<n;i++) {
    		dp[0][i] = matrix[0][i];
    	}
    	for(int i = 1;i<n;i++) {
    		for(int j = 0;j<n;j++) {
    			int left = Integer.MAX_VALUE;
    			if(j-1 >= 0) {
    				left = dp[i-1][j-1] + matrix[i][j];
    			}
    			int right = Integer.MAX_VALUE;
    			if(j+1<n) {
    				right = dp[i-1][j+1] + matrix[i][j];
    			}
    			
    			int min = Math.min(right, left);
    			dp[i][j] = Math.min(min, dp[i-1][j]+matrix[i][j]);
    		}
    	}
    	int res = Integer.MAX_VALUE;
    	for(int i = 0;i<n;i++) {
    		if(dp[n-1][i] < res) {
    			res = dp[n-1][i];
    		}
    	}
    	return res;
    }
}