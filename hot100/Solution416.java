package hot100;

import java.util.Arrays;

public class Solution416 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1, 2, 1, 2};
		HotSolution416 hotSolution = new HotSolution416();
		boolean res = hotSolution.canPartition(nums);
		System.out.println(res);
	}

}
class HotSolution416 {
    public boolean canPartition(int[] nums) {
    	
    	int len = nums.length;
    	Arrays.sort(nums);
    	System.out.println(Arrays.toString(nums));
    	int preindex = 0;
    	int lastindex = len-1;
    	int presum = nums[preindex];
    	int lastsum = nums[lastindex];
    	while(preindex<lastindex) {
    		if(presum<lastsum) {
    			
    			presum += nums[++preindex];
    			
    			
    		}else if(presum >lastsum) {
    			
    			lastsum += nums[--lastindex];
    			
    		}else if((preindex+1)==lastindex&&lastsum ==presum){
    			 return true;
    		}else if((preindex+1)<lastindex&&lastsum ==presum) {
    			presum += nums[++preindex];
    		}else {
    			return false;
    		}
    	}
    	System.out.println(presum +" " + lastsum);
    	return false;
    }
}