package DynamicProgram;

import java.util.ArrayList;
import java.util.List;

public class Solution474 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"10", "0001", "111001", "1", "0"};
		int m = 5;
		int n = 3;
		DynamicSolution474 s = new DynamicSolution474();
		System.out.println(s.findMaxForm(strs, m, n));
	}

}
class DynamicSolution474 {
    public int findMaxForm(String[] strs, int m, int n) {
    	int[][] dp = new int[m+1][n+1];
    	for(String s : strs) {
    		int[] c = countszerosones(s);
    		for(int i = m;i>=c[0];i--) {
    			for(int j = n;j>=c[1];j--) {
    				dp[i][j] = Math.max(1+dp[i-c[0]][j-c[1]], dp[i][j]);
    			}
    		}
    		
    		
    	}
    	return dp[m][n];
    }
    public int[] countszerosones(String s) {
    	int[] c = new int[2];
    	for(int i = 0;i<s.length();i++) {
    		if(s.charAt(i) == '0') {
    			c[0] += 1;
    		}else {
    			c[1] += 1;
    		}
    	}
    	return c;
    }
}