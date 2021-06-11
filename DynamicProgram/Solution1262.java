package DynamicProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class Solution1262 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,4};
		DynamicSolution1262 s = new DynamicSolution1262();
		System.out.println(s.maxSumDivThree(nums));
	}

}
class DynamicSolution1262 {
    public int maxSumDivThree(int[] nums) {
    	int[][] dp = new int[nums.length + 1][3];
    	dp[0][0] = 0;
    	dp[0][1] = Integer.MIN_VALUE;
    	dp[0][2] = Integer.MIN_VALUE;
    	for(int i = 1;i<nums.length+1;i++) {
    		int yu = nums[i-1] % 3;
    		dp[i][0] = Math.max(dp[i-1][0], dp[i-1][(3-yu)%3]+nums[i-1]);
    		dp[i][1] = Math.max(dp[i-1][1], dp[i-1][(3-yu+1)%3]+nums[i-1]);
    		dp[i][2] = Math.max(dp[i-1][2], dp[i-1][(3-yu+2)%3]+nums[i-1]);
    	}
    	return dp[nums.length][0];
    }
}