package hot100;

import java.util.ArrayList;

public class Solution064 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {
				{1,3,1},
				{1,5,1},
				{4,2,1}
		};
		System.out.println(minPathSum001(grid));
		
		
	}
	public static int minPathSum001(int[][] grid) {
		int line = grid.length;
		int column = grid[0].length;
		int[][] dp = new int[line][column];
		dp[0][0] = grid[0][0];
		for(int i = 1;i < line;i++) {
			dp[i][0] = dp[i-1][0] + grid[i][0];
		}
		for(int j = 1;j< column;j++) {
			dp[0][j] = dp[0][j-1] + grid[0][j];
		}
		for(int i = 1;i<line;i++) {
			for(int j = 1;j<column;j++) {
				dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
			}
		}
		return dp[line-1][column-1];
    }
}
