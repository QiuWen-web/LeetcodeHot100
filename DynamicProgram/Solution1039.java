package DynamicProgram;

public class Solution1039 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] values = {1,3,1,4,1,5};
		DynamicSolution1039 s = new DynamicSolution1039();
		System.out.println(s.minScoreTriangulation(values));
	}

}
class DynamicSolution1039 {
    public int minScoreTriangulation(int[] values) {
    	//≥ı ºªØdp
    	int n = values.length;
    	int[][] dp = new int[n][n];
    	for(int i = 0;i<n;i++) {
    		for(int j = 0;j<n;j++) {
    			dp[i][j] = Integer.MAX_VALUE;
    		}
    	}
    	for(int i = 0;i<n-1;i++) {
    		dp[i][i+1] = 0;
    	}
    	for(int d = 2;d<n;d++) {
    		for(int i = 0;i<n-d;i++) {
    			int j = i+d;
    			for(int k = i+1;k<j;k++) {
    				dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + values[i] * values[k] * values[j]);
    			}
    		}
    	}
    	return dp[0][n-1];
    }
}