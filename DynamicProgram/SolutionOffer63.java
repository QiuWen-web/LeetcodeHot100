package DynamicProgram;

public class SolutionOffer63 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {7,1,5,3,6,4};
		DynamicSolution63 s = new DynamicSolution63();
		System.out.println(s.maxProfit(prices));
	}

}
class DynamicSolution63 {
    public int maxProfit(int[] prices) {
    	int[][] dp = new int[2][prices.length];
    	dp[0][0] = prices[0];
    	dp[1][0] = 0;
    	for(int i = 1;i<prices.length;i++) {
    		dp[0][i] = Math.min(dp[0][i-1], prices[i]);
    		dp[1][i] = Math.max(dp[1][i-1], prices[i]-dp[0][i-1]);
    	}
    	
    	return dp[1][prices.length-1];
    }
}