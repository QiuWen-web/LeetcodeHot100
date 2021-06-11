package DynamicProgram;

public class Solution1641 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DynamicSolution1641 s = new DynamicSolution1641();
		System.out.println(s.countVowelStrings(2));
	}

}
class DynamicSolution1641 {
    public int countVowelStrings(int n) {
    	int[][] dp = new int[n][5];
    	for(int j = 0;j<5;j++) {
    		dp[0][j] = 1;
    	}
    	for(int i = 1;i<n;i++) {
    		int index = 0;
    		while(index<5) {
    			for(int j = index;j<5;j++) {
    				dp[i][index] += dp[i-1][j];
    			}
    			index++;
    		}
       	}
    	return dp[n-1][0]+dp[n-1][1]+dp[n-1][2]+dp[n-1][3]+dp[n-1][4];
    }
}