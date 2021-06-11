package DynamicProgram;

public class Solution1025 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DynamicSolution1025 s = new DynamicSolution1025();
		System.out.println(s.divisorGame(4));
	}

}
class DynamicSolution1025 {
    public boolean divisorGame(int n) {
        if(n==1) {
        	return false;
        }
        if(n==2) {
        	return true;
        }
        if(n==3) {
        	return false;
        }
        boolean[] dp = new boolean[n+1];
        
        
        dp[2] = true;
        
        for(int i = 4;i<n+1;i++) {
        	for(int j = 1;j<=Math.sqrt(i);j++) {
        		if(i%j == 0) {
        			if(dp[i-j] == false) {
        				dp[i] = true;
        				
        			}
        		}
        	}
        	
        }
        return dp[n];
    }
}