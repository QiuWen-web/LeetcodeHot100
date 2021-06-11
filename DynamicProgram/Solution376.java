package DynamicProgram;

public class Solution376 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,17,5,10,13,15,10,5,16,8};
		DynamicSolution376 s = new DynamicSolution376();
		System.out.println(s.wiggleMaxLength(nums));
	}

}
class DynamicSolution376 {
	public int wiggleMaxLength(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		if(n < 2) {
			return n;
		}
		dp[0] = 1;
		for(int i = 1;i<n;i++) {
			for(int j = i-1;j>=0;j--) {
				if(nums[i]-nums[j] != 0) {
					if(j == 0) {
						dp[i] = dp[j]+1;
						break;
					}
					if((nums[i] - nums[j] >0 && nums[j]-nums[j-1] <0)||(nums[i] - nums[j] <0 && nums[j]-nums[j-1] >0) ) {
						dp[i] =dp[j]+1;
						break;
					}
				}else {
					dp[i] = dp[j];
					break;
				}
			}
		}
		return dp[n-1];
    }
}