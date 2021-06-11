package DynamicProgram;

public class Solution357 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DynamicSolution357 s  = new DynamicSolution357();
		System.out.println(s.countNumbersWithUniqueDigits(2));
	}

}
class DynamicSolution357 {
    public int countNumbersWithUniqueDigits(int n) {
    	if(n == 0) {
    		return 1;
    	}
    	if(n == 1) {
    		return 10;
    	}
    	int[][] dp = new int[n][10];
    	for(int i = 0;i<10;i++) {
    		dp[0][i] = 1;
    	}
    	for(int i = 1;i<n;i++) {
    		
    		for(int j = 0;j<10;j++) {
    			if(j==0) {
    				//求上一行总和
    				int presum = 0;
    				for(int k = 0;k<10;k++) {
    					presum += dp[i-1][k];
    				}
    				dp[i][0] = presum;
    				
    			}else {
    				dp[i][j] = dp[i-1][j] * (10-i);
    			}
    			
    		}    		
    	}
    	int res = 0;
    	for(int j = 0;j<10;j++) {
    		res += dp[n-1][j];
    	}
    	return res;
    }
}