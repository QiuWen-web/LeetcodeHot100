package ArrayProblem;

import java.util.Arrays;

public class Solution628 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3};
		ArraySolution628 s = new ArraySolution628();
		System.out.println(s.maximumProduct(nums));
	}

}
class ArraySolution628 {
    public int maximumProduct(int[] nums) {
    	//三个数组成的最大乘积
    	Arrays.sort(nums);
    	int res1 = nums[0] * nums[1] * nums[nums.length-1];
    	int res2 = nums[nums.length-3] * nums[nums.length-2] * nums[nums.length-1];
    	int res3 = nums[0] * nums[1] * nums[2];
    	int temp = res1>res2? res1:res2;
    	int res = temp>res3? temp:res3;
    	return res;
    }
}