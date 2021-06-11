package hot100;

import java.util.Arrays;
import java.util.TreeSet;




public class Solution152 {
	public static int product = 1;
	public static void main(String[] args) {
		int[] nums = {-1,0};		
		TreeSet<Integer> ts = new TreeSet<Integer>();
		for(int i = 0;i<nums.length;i++){
            ts.add(List(nums,i));
        }
		System.out.println(ts.last());
	}
	public static int List(int[] nums,int pos) {
		int max = nums[pos];
		product = 1;
		for(int i = pos;i<nums.length;i++) {			
			product = product*nums[i];
			//System.out.println("----"+product);
			if(max<product) {
				max = product;
			}
			
		}
		return max;
	}
}
