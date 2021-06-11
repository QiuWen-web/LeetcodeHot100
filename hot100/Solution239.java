package hot100;

import java.util.Arrays;
import java.util.Collections;

public class Solution239 {
	public static void main(String[] args) {
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		
		int[] res = maxSlidingWindow(nums, k);
		
		for(int i : res) {
			System.out.println(i);
		}
		
	}
	public static int[] maxSlidingWindow(int[] nums, int k) {
		int[] res = new int[nums.length-k+1];
		
		for(int i = 0;i<nums.length-k+1;i++) {
			int[] temp = new int[k];
			System.arraycopy(nums, i, temp, 0, 3);
			for(int j : temp) {
				System.out.print(j);
			}
			System.out.println();
			int max = Arrays.stream(temp).max().getAsInt();
			res[i] = max;
		}
		return res;
    }
}
