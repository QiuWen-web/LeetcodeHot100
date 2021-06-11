package hot100;

import java.util.Arrays;
import java.util.Collections;

public class Solution215 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,2,3,1,2,4,5,5,6};
		Solution solution = new Solution();
		int res = solution.fidKthLargest(nums, 4);
		System.out.println(res);
		
	}

}

class Solution{
	public int fidKthLargest(int[] nums,int k) {
		Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
		Arrays.sort(arr,Collections.reverseOrder());
		return arr[k-1];
	}
}