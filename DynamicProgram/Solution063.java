package DynamicProgram;
//机器人走路
public class Solution063 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] obstacleGrid = {{0,0},{1,1},{0,0}};
		DynamicSolution063 s = new DynamicSolution063();
		System.out.println(s.uniquePathsWithObstacles(obstacleGrid));
	}

}
class DynamicSolution063 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int m = obstacleGrid.length;
    	int n = obstacleGrid[0].length;
    	if(obstacleGrid[0][0] == 1) {
			return 0;
		}
    	if(m ==1 && n ==1) {
    		if(obstacleGrid[0][0] == 1) {
    			return 0;
    		}else {
    			return 1;
    		}
    	}
    	if(m == 1 && n >1) {
    		for(int j = 0;j<n;j++) {
    			if(obstacleGrid[0][j] == 1) {
    				return 0;
    			}
    		}
    		return 1;
    	}
    	if(n == 1 && m >1) {
    		for(int i = 0;i<m;i++) {
    			if(obstacleGrid[i][0] == 1) {
    				return 0;
    			}
    		}
    		return 1;
    	}
    	int[][] dp = new int[m][n];
    	
    	for(int i = 0;i<m;i++) {
    		for(int j=0;j<n;j++) {
    			if(obstacleGrid[i][j] == 1) {
    				dp[i][j] = -1;
    			}
    		}
    	}
    	//初始化第一行和第一列
    	int o = 0;
    	for(;o<m;o++) {
    		if(obstacleGrid[o][0] != 1) {
    			dp[o][0] = 1;
    		}else {
    			break;
    		}
    	}
    	for(;o<m;o++) {
    		dp[o][0] = -1;
    	}
    	o = 0;
    	for(;o<n;o++) {
    		if(obstacleGrid[0][o] != 1) {
    			dp[0][o] = 1;
    		}else {
    			break;
    		}
    	}
    	for(;o<n;o++) {
    		dp[0][o] = -1;
    	}
    	
    	for(int i = 1;i<m;i++) {
    		for(int j=1;j<n;j++) {
    			if(dp[i][j] == 0) {
    				if(dp[i-1][j] != -1 && dp[i][j-1] !=-1) {
    					dp[i][j] = dp[i-1][j]+dp[i][j-1];
    				}
    				if(dp[i-1][j] != -1 && dp[i][j-1] ==-1) {
    					dp[i][j] = dp[i-1][j];
    				}
    				if(dp[i-1][j] == -1 && dp[i][j-1] !=-1) {
    					dp[i][j] = dp[i][j-1];
    				}
    				if(dp[i-1][j] == -1 && dp[i][j-1] ==-1) {
    					dp[i][j] = -1;
    				}
    			}
    		}
    	}
    	if(dp[m-1][n-1] == -1) {
    		return 0;
    	}else {
    		return dp[m-1][n-1];
    	}
    	
    }
}
