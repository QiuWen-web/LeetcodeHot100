package DynamicProgram;

public class Solution1664 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4,1,1,2,5,1,5,4};
		DynamicSolution1664 s = new DynamicSolution1664();
		System.out.println(s.waysToMakeFair(nums));
	}

}
class DynamicSolution1664 {
    public int waysToMakeFair(int[] nums) {
    	int n = nums.length;
    	
    	if(n == 1) {
    		if(nums[0] == 0) {
    			return 1;
    		}else {
    			return 0;
    		}
    	}
    	
    	int[][] dp = new int[4][n];
    	//初始化dp
    	int ro = 0;
    	for(int i = 1;i<n;i += 2) {
    		ro += nums[i];
    	}
    	int rj = 0;
    	for(int i = 2;i<n;i += 2) {
    		rj += nums[i];
    	}
    	dp[2][0] = ro;
    	dp[3][0] = rj;
    	for(int j = 1;j<n;j++) {
			if((j-1)%2 == 0) {
				//如果要删除的这个数的上一个数的索引是偶数
				dp[0][j] = dp[0][j-1] + nums[j-1];
				dp[1][j] = dp[1][j-1];
				dp[2][j] = dp[3][j-1];
				dp[3][j] = dp[2][j-1] - nums[j];
			}else {
				dp[0][j] = dp[0][j-1];
				dp[1][j] = dp[1][j-1] + nums[j-1];
				dp[2][j] = dp[3][j-1];
				dp[3][j] = dp[2][j-1] - nums[j];
			}			
    	}
    	int count = 0;
    	for(int j = 0;j<n;j++) {
    		if(j%2 == 1 && dp[0][j] + dp[3][j] == dp[1][j] + dp[2][j]) {
    			count++;
    		}
    		if(j%2 == 0 && dp[0][j] + dp[2][j] == dp[1][j] + dp[3][j]) {
    			count++;
    		}
    	}
    	return count;
    }
}