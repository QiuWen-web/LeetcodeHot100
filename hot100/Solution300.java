package hot100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 给定一个无序的整数数组，找到其中最长上升子序列的长度。
示例:
输入: [10,9,2,5,3,7,101,18]
输出: 4 
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * */
public class Solution300 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {10,9,2,5,3,7,101,18};
		HotSolution300 hotSolution300 = new HotSolution300();
		System.out.println(hotSolution300.lengthOfLIS(nums));
	}

}
class HotSolution300 {
    public int lengthOfLIS(int[] nums) {
    	if(nums.length == 0) {
    		return 0;
    	}
    	int[] dp = new int[nums.length];
    	dp[0] = 1;
    	int maxans = 1;
    	for(int i = 1;i<nums.length;i++) {
    		dp[i] = 1;
    		for(int j = 0;j<i;j++) {
    			if(nums[i]>nums[j]) {
    				dp[i] = Math.max(dp[i], dp[j]+1);
    			}    			
    		}
    		maxans = Math.max(dp[i],maxans);
        
    	}
    	return maxans;
    }
}