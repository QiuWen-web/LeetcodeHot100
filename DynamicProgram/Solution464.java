package DynamicProgram;

public class Solution464 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maxChoosableInteger = 10; 
		int desiredTotal = 11;
		DynamicSolution464 s = new DynamicSolution464();
		System.out.println(s.canIWin(maxChoosableInteger, desiredTotal));
	}

}
class DynamicSolution464 {
	 public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
	        // 特判，如果总的点数和不能达到desiredTotal，判输
	        if((1+maxChoosableInteger)*maxChoosableInteger/2 < desiredTotal)
	            return false;
	        return helper(maxChoosableInteger, desiredTotal, new Boolean[1 << maxChoosableInteger], 0);
	    }

	    public boolean helper(int maxChoosableInteger, int desiredTotal, Boolean[] dp, int state){
	        if(dp[state] != null)
	            return dp[state];
	        for(int i = 1; i <= maxChoosableInteger; i++){
	            int cur = 1 << (i - 1);
	            if((cur & state) != 0)
	                continue;
	            
	            // 如果当前选择使得累积和大于等于desiredTotal
	            // 又或者当前选择之后，另一个人的选择必输，说明当前必赢
	            if(desiredTotal - i <= 0 || 
	                helper(maxChoosableInteger, desiredTotal - i, dp, state | cur) == false){
	                return dp[state] = true;
	            }
	        }

	        // 无论怎么选都无法让对手输，那么就是自己输了
	        return dp[state] = false;
	    }
}