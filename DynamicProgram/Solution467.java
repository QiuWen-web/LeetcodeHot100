package DynamicProgram;

import java.util.HashMap;
import java.util.Map;

public class Solution467 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String p = "cac";
		DynamicSolution467 s = new DynamicSolution467();
		System.out.println(s.findSubstringInWraproundString(p));
	}

}
class DynamicSolution467 {
    public int findSubstringInWraproundString(String p) {
    	int[] dp = new int[26];
    	char[] arr = p.toCharArray();
    	int count = 0;
    	for(int i = 0;i<arr.length;i++) {
    		if(i>0 && (arr[i]-arr[i-1]-1)%26 == 0) {
    			//后一个字符与前一个字符是连续的
    			count++;
    		}else {
    			count = 1;
    		}
    		dp[arr[i]-'a'] = Math.max(dp[arr[i]-'a'], count);
    		
    	}
    	int res = 0;
    	for(int i :dp) {
    		res += i;
    	}
    	return res;
    }
}