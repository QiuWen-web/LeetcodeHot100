package DynamicProgram;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

public class Solution368 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4,8,10,240};
		DynamicSolution368 s= new DynamicSolution368();
		System.out.println(s.largestDivisibleSubset(nums));
	}

}
class DynamicSolution368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
    	Arrays.sort(nums);
    	int n = nums.length;
    	int[] dp = new int[n];
    	if(n == 0) {
    		return new ArrayList<>();
    	}
    	if(n == 1){
            List<Integer> res =  new ArrayList<>();
            res.add(nums[0]);
            return res;
        }
    	for(int i = 0;i<n;i++) {
    		dp[i] = 1;
    	}
    	
    	for(int i = 1;i<n;i++) {
    		for(int j = i-1;j>=0;j--) {
    			if(nums[i]%nums[j] == 0) {
    				dp[i] = Math.max(dp[j]+1, dp[i]);   				
    			}
    		}
    		
    	}
  //  	System.out.println(Arrays.toString(dp));
    	//寻找最大数和其位置
    	int max = 0;    	
    	int id = 0;
    	for(int i = 0;i<n;i++) {
    		if(max<dp[i]) {
    			max = dp[i];
    			id = i;
    		}
    	}
    	//如果数组都不能被整除
    	if(max == 1) {
            List<Integer> res =  new ArrayList<>();
            res.add(nums[0]);
            return res;
    	}
    	//如果最大值大于1,可以返回数组
    	List<Integer> list = new ArrayList<>();
    	int pre = nums[id];
    	list.add(pre);
    	
    	int j = id-1;
    	//寻找比下一个能整除pre的数和其排序
    	for(int i = max-1;i>=1;i--) {
    		
    		 for(;j>=0;j--) {
    			 int cur = nums[j];
    			 int number = dp[j];
    			 
    			 if(pre%cur == 0 && number == i) {
    				 list.add(cur);
    				 pre = cur;
    				 break;    				 
    			 }
    		 }
    	}
    	return list;
    }
}