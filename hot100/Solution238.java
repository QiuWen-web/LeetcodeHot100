package hot100;

public class Solution238 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,4};
		Solution solution = new Solution();
		int[] res = solution.productExceptSelf(nums);
		System.out.println(res);
	}

}
class Solution {
    public int[] productExceptSelf(int[] nums) {
    	int len = nums.length;
    	int[] res = new int[len];
    	if(len == 0) {
    		res[0] = 0;
    		return res;
    	}
    	if(len == 1) {
    		return nums;
    	}
    	int left = 1,right = 1;
    	for(int i = 0 ;i<len;i++) {
    		if(i>0) {
    			left = left * nums[i-1];
    		}    		  		res[i] = left;
    	}
    	for(int i = len-1 ;i>=0;i--) {
    		if(i<len-1) {
    			right = right * nums[i+1];
    		}    		
    		res[i] *= right;
    	}
    	return res;
    }
}