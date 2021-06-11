package hot100;

public class Solution560 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,1};
		int k = 2;
		HotSolution560 hotSolution560 = new HotSolution560();
		System.out.println(hotSolution560.subarraySum(nums, k));
	}

}
class HotSolution560 {
    public int subarraySum(int[] nums, int k) {
    	int count = 0;
    	
    	for(int j = 0;j<nums.length;j++) {
    		
        	int sum = 0;
        	
    		for(int i = j;i<nums.length;i++) {
    			sum = sum + nums[i];
    			if(sum == k) {
    				count++;
    			}
    		}
    	}
    	return count;
    }
}