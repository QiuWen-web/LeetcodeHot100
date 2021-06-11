package hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution136 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,2,1};
		int sum = 0;
		for(int i = 0 ;i<nums.length;i++) {
			sum += nums[i];
		}
		int temp= 0;
		for(int i = 0 ;i<nums.length-1;i++) {
			for(int j = i+1 ;j<nums.length;j++) {
				if(nums[i] == nums[j]) {
					temp += 2*nums[i];
				}
			}
		}
		System.out.println(sum-temp);
	}
//	private static int onenums(int[] nums) {
//		List<Integer> ls = new ArrayList<Integer>();
//		for(int i =0;i<nums.length;i++) {
//			if(!ls.contains(nums[i])) {
//				//如果ls中没有这个数则添加
//				ls.add(nums[i]);
//			}else {
//				ls.remove(nums[i]);
//			}
//		}
//		return ls.get(0);
//	}
}
