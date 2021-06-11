package hot100;

import java.util.Arrays;

public class Solution581 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2, 6, 4, 8, 10, 9, 15};
		int[] n = new int[nums.length];
		for(int i = 0;i<nums.length;i++) {
			n[i] = nums[i];
		}
		Arrays.sort(n);
		System.out.println(Arrays.toString(nums));
		System.out.println(Arrays.toString(n));
		int countstart = nums.length-1;
		int countend = 0;
		for(int i = 0;i<nums.length;i++) {
			if(n[i] != nums[i] ) {
				if(i<countstart) {
					countstart = i;
				}
				if(i>countend) {
					countend = i;
				}
			}
		}
		System.out.println(countstart);
		System.out.println(countend);
	}

}
//class HotSolution581 {
//    public int findUnsortedSubarray(int[] nums) {
//    	int[] numsort = nums;
//    	Arrays.sort
//    }
//}