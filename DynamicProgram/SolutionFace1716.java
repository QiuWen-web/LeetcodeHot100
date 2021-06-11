package DynamicProgram;

public class SolutionFace1716 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,1,4,5,3,1,1,3};
		DynamicFaceSolution1716 s = new DynamicFaceSolution1716();
		System.out.println(s.massage(nums));
	}

}
class DynamicFaceSolution1716 {
    public int massage(int[] nums) {
    	int n = nums.length;
    	int[][] dp = new int[2][n];
    	dp[0][0] = nums[0];
    	for(int i = 1;i<n;i++) {
    		dp[0][i] = dp[1][i-1] + nums[i];
    		dp[1][i] = Math.max(dp[0][i-1], dp[1][i-1]);
    	}
    	return Math.max(dp[0][n-1], dp[1][n-1]);
    }
}