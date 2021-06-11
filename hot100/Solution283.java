package hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution283 {
	public static void main(String[] args) {
		int[] nums = {0,1,0,3,12,0,3,5,4,0};
		moveZeroes(nums);
		for(int i : nums) {
			System.out.print(i + " ");
		}
		
	}
	public static void moveZeroes(int[] nums) {
		int len  = nums.length;
		
		int number0 = 0;
		for(int i = 0 ;i<len;i++) {
			if(nums[i]==0) {
				number0++;
			}
		}
		System.out.println("number0:" + number0);
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<len;i++) {
			if(nums[i] != 0) {
				list.add(nums[i]);
			}
		}
		for(int i =0;i<number0;i++) {
			list.add(0);
		}
		for(int i = 0;i<len;i++) {
			nums[i] = list.get(i);
		}
	}
}
