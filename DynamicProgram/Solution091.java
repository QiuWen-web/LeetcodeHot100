package DynamicProgram;

public class Solution091 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s  = "10011";
		DynamicSolution091 r = new DynamicSolution091();
		System.out.println(r.numDecodings(s));
	}

}
class DynamicSolution091 {
	public int numDecodings(String s) {
    	int n = s.length();
    	int[] dp = new int[n];
    	if(s.charAt(0) == '0') {
    		return 0;
    	}
    	dp[0] = 1;
    	for(int i = 1;i<n;i++) {
    		if(s.charAt(i) == '0') {
    			if(s.charAt(i-1) == '1' ||s.charAt(i-1) == '2'){
    				if(i == 1) {
    					dp[i] = dp[0];
    				}else {
    					dp[i] = dp[i-2];	
    				}
    				
    			}else{
                    return 0;
                }
    			
    		}else {
    			if(Integer.parseInt(s.substring(i-1, i+1))>=11 &&Integer.parseInt(s.substring(i-1, i+1))<=26){
    				if(i==1) {
    					dp[i] = dp[0]+1;
    				}else {
    					dp[i] = dp[i-1]+dp[i-2];
    				}
    				
    			}else{
                    dp[i] = dp[i-1];
                }
    		}
    	}
    	return dp[n-1];
    }
}