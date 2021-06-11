package DynamicProgram;

public class Solution416 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,5,11,5};
		DynamicSolution416 s = new DynamicSolution416();
		System.out.println(s.canPartition(nums));
	}

}
class DynamicSolution416 {
    public boolean canPartition(int[] nums) {
    	int n = nums.length;
    	int sum = 0;
    	for(int i = 0;i<n;i++) {
    		sum += nums[i];
    	}
    	if(sum%2 == 1) {
    		return false;
    	}
    	int m = sum/2;
    	int[] bao = new int[m+1];
    	for(int i = 0;i<n;i++) {
    		//遍历的nums数组
    		for(int j = m;j>=1;j--) {
    			if(j-nums[i] >= 0) {
    				bao[j] = Math.max(bao[j], bao[j-nums[i]] + nums[i]);
    			}
    		}
    	}
    	if(bao[m] == m) {
    		return true;
    	}
    	return false;
    }
}