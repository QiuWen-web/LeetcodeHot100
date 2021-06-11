package hot100;



public class Solution198 {
	public static void main(String[] args) {
		int[] nums = {2,1,1,2};
		int a = 0;
		int b = 0;
		for(int i = 0; i<nums.length;i++) {
			int c = Math.max(b, a+nums[i]);
			a = b;
			b = c;
		}
		System.out.println(b);
	}	
}
