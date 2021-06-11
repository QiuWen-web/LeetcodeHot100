package ArrayProblem;

import java.util.Arrays;

public class Solution1144 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3};
		ArraySolution1144 s = new ArraySolution1144();
		System.out.println(s.movesToMakeZigzag(nums));
	}

}
class ArraySolution1144 {
	public int movesToMakeZigzag(int[] nums) {
		int[] nums1 = Arrays.copyOf(nums, nums.length);
		int[] nums2 = Arrays.copyOf(nums, nums.length);
		int min1 = movesToMakeZigzagou(nums1);
		int min2 = movesToMakeZigzagji(nums2);
		int min = Math.min(min1, min2);
		return min;
    }
    public int movesToMakeZigzagou(int[] nums) {
    	//偶数索引的值大于奇数索引的值所需要的最小减法
    	int sum = 0;
    	//限定偶数索引
    	for(int i = 0;i<nums.length;i += 2) {
    		if(i == 0) {
    			//如果偶数索引为第一个数，则只需要比较右边
    			if(nums[0]<=nums[1]) {
    				sum += nums[1] - nums[0] +1;
    				nums[1] = nums[0]-1;
    			}
    		}
    		if(i==nums.length-1) {
    			//如果偶数索引为最后一个数，则只需要比较左边
    			if(nums[i]<=nums[i-1]) {
    				sum += nums[i-1] - nums[i] +1;
    				nums[i-1] = nums[i]-1;
    			}
    			
    		}
    		if(i>0 && i<nums.length-1) {
    			//如果偶数索引不在两头，则需要比较左右两个数
    			if(nums[i]<=nums[i-1]) {
    				sum += nums[i-1] - nums[i] + 1;
    				nums[i-1] = nums[i]-1;
    			}
    			if(nums[i]<=nums[i+1]) {
    				sum += nums[i+1] - nums[i] + 1;
    				nums[i+1] = nums[i] - 1;
    			}
    		}
    	}
    	System.out.println(Arrays.toString(nums));
    	return sum;
    }
    public int movesToMakeZigzagji(int[] nums) {
    	//奇数索引的值大于偶数索引的值所需要的最小减法
    	int sum = 0;
    	//限定奇数索引
    	for(int i = 1;i<nums.length;i += 2) {
    		
    		if(i==nums.length-1) {
    			//如果奇数索引为最后一个数，则只需要比较左边
    			if(nums[i]<=nums[i-1]) {
    				sum += nums[i-1] - nums[i] +1;
    				nums[i-1] = nums[i]-1;
    			}
    			
    		}
    		if(i>0 && i<nums.length-1) {
    			//如果偶数索引不在两头，则需要比较左右两个数
    			if(nums[i]<=nums[i-1]) {
    				sum += nums[i-1] - nums[i] + 1;
    				nums[i-1] = nums[i]-1;
    			}
    			if(nums[i]<=nums[i+1]) {
    				sum += nums[i+1] - nums[i] + 1;
    				nums[i+1] = nums[i] - 1;
    			}
    		}
    	}
    	System.out.println(Arrays.toString(nums));
    	return sum;
    }
}