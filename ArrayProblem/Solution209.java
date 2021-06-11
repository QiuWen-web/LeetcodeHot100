package ArrayProblem;

public class Solution209 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4,5};
		int target = 11;
		ArraySolution209 s = new ArraySolution209();
		System.out.println(s.minSubArrayLen(target, nums));
	}

}
class ArraySolution209 {
    public int minSubArrayLen(int target, int[] nums) {
    	//特殊情况，总和仍不大于target;
    	int tempsum = 0;
    	for(int i : nums) {
    		tempsum += i;
    	}
    	if(tempsum < target) {
    		return 0;
    	}
    	//从头开始遍历和
    	int sum = 0;
    	
    	//最小长度子数组
    	int minlen = Integer.MAX_VALUE;
    	
    	for(int start = 0;start <nums.length;start++) {
    		for(int i = start;i<nums.length;i++) {
    			sum += nums[i];
    			if(i-start+1 >= minlen) {
    				sum = 0;
    				break;
    			}
    			if(sum >= target) {
    				//说明该子数组符合要求
    				//如果该子数组长度小于minlen，则替换
    				int templen = i - start+1;
    				if(templen < minlen) {
    					minlen = templen;
    				}
    				sum = 0;
    				break;
    			}   			
    		}
    		sum = 0;
    	}
    	return minlen;
    }
}