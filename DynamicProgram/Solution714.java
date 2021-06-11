package DynamicProgram;

public class Solution714 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {1, 3, 2, 8, 4, 9};
		int fee = 2;
		DynamicSolution714 s = new DynamicSolution714();
		System.out.println(s.maxProfit(prices, fee));
	}

}
class DynamicSolution714 {
    public int maxProfit(int[] prices, int fee) {
    	int[][] dp = new int[prices.length][2];
    	for(int i = 0;i<prices.length;i++) {
    		if(i == 0) {
    			dp[0][0] = 0;
    			dp[0][1] = 0-prices[0];
    			
    		}else {
    			dp[i][0] = Math.max(prices[i] + dp[i-1][1] - fee, dp[i-1][0]);
    			dp[i][1] = Math.max(dp[i-1][0]-prices[i], dp[i-1][1]);
    	
    		}
    	}
    	return dp[prices.length-1][0];
    }
}