package hot100;

import java.util.Arrays;

public class Solution647 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aa";
		char[] nums = new char[s.length()];
    	for(int i = 0;i<s.length();i++) {
    		nums[i] = s.charAt(i);
    	}
    	int res = countSubString2(nums);
    	System.out.println(res);
	}
	public static int countSubString2(char[] nums) {
		int count = 0;
		
		//我们要分割总的字符串
		//长度由小到大,以索引为标准，先第一个a,ab,aba,abab,ababc判断
		for(int j = 0;j<nums.length;j++) {
			for(int i = j;i<nums.length;i++) {
				char[] s = (char[]) Arrays.copyOfRange(nums, j, i+1);
				System.out.println(s);
				if(ishuiwen(s)) {
					count++;
				}
			}			
		}

		return count;
	}
	public static boolean ishuiwen(char[] item) {
		for(int i=0,j=item.length-1;i<=j;i++,j--) {
			if(item[i] != item[j]) {
				return false;
			}
		}
		return true;
	}
}
//class HotSolution647 {
//    public int countSubstrings(String s) {
//    	char[] nums = new char[s.length()];
//    	for(int i = 0;i<s.length();i++) {
//    		nums[i] = s.charAt(i);
//    	}
//    	int count = 0;
//    	int res =  countSbustrings2(nums,0,nums.length-1,count);
//    }
//    public int countSubStrings2(char[] nums,int start,int end,int count) {
//    	if(start == end) {
//    		count++;
//    	}
//    	if(nums[start] == nums[end]) {
//    		start++;
//    		end--;
//    		countSubStrings2(nums,start,end,count);
//    	}else if(nums[start] != nums[end] ) {
//    		countSubStrings2(nums,0,end-1,count);
//    		countSubStrings2(nums,start+1,nums.length-1,count);
//    	}
//    	return count;
//    } 
//}