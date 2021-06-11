package DynamicProgram;

public class Solution650 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DynamicSolution650 s = new DynamicSolution650();
		System.out.println(s.minSteps(27));
	}

}
class DynamicSolution650 {
    public int minSteps(int n) {
    	//nµÄÈ¡Öµ·¶Î§1-1000
    	int[] dp = new int[n+1];
    	for(int i = 0;i<n+1;i++) {
    		if(i == 0 ||i ==1) {
    			dp[i] = 0;
    		}
    		if(i == 2) {
    			dp[i] = 2;
    		}
    		if(i == 3) {
    			dp[i] = 3;
    		}
    		 if(i == 5) {
     			dp[i] = 5;
     		}
             if(i == 7) {
     			dp[i] = 7;
     		}
    		for(int k = i/2;k>=1;k--) {
    			if(i%k == 0) {
    				dp[i] = dp[k]+i/k;
    				break;
    			}
    			if(k == 1) {
    				dp[i] = i;
    			}
    		}
    	}
    	return dp[n];
    }
}