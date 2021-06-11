package ArrayProblem;

public class Solution219 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,0,1,1};
		int k = 1;
		ArraySolution219 s= new ArraySolution219();
		System.out.println(s.containsNearbyDuplicate(nums, k));
	}

}
class ArraySolution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	int len = nums.length;
    	for(int i = 0 ; i < len;i++) {
    		for(int j = i+1;j <= k+i && j < len;j++) {
    			if(nums[i] == nums[j]) {
    				return true;
    			}
    		}
    	}
    	return false;
    }
}