package DynamicProgram;

public class Solution303 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-2, 0, 3, -5, 2, -1};
		DynamicNumArray303 s = new DynamicNumArray303(nums);
		System.out.println(s.sumRange(0, 2));
		System.out.println(s.sumRange(2, 5));
		System.out.println(s.sumRange(0, 5));
	}

}
class DynamicNumArray303 {
	private int[] nums;
    public DynamicNumArray303(int[] nums) {
    	this.nums = nums;
    }
    
    public int sumRange(int left, int right) {
    	int sum = 0;
    	for(int i = left;i<=right;i++) {
    		sum += this.nums[i];
    	}
    	return sum;
    }
}