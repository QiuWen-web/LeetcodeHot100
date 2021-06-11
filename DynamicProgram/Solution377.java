package DynamicProgram;

import java.util.Arrays;

public class Solution377 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3};
		int target = 4;
		DynamicSolution377 s = new DynamicSolution377();
		System.out.println(s.combinationSum4(nums, target));
	}

}
class DynamicSolution377 {
	 public int combinationSum4(int[] nums, int target) {
	        int[] memo = new int[target + 1];
	        memo[0] = 1;
	        for (int i = 0; i < target; i++) {
	            for (int num : nums) {
	                if (i + num <= target) {
	                    memo[i + num] += memo[i];
	                }
	            }
	        }
	        return memo[target];
	    }
}