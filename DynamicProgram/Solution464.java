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
	        // ���У�����ܵĵ����Ͳ��ܴﵽdesiredTotal������
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
	            
	            // �����ǰѡ��ʹ���ۻ��ʹ��ڵ���desiredTotal
	            // �ֻ��ߵ�ǰѡ��֮����һ���˵�ѡ����䣬˵����ǰ��Ӯ
	            if(desiredTotal - i <= 0 || 
	                helper(maxChoosableInteger, desiredTotal - i, dp, state | cur) == false){
	                return dp[state] = true;
	            }
	        }

	        // ������ôѡ���޷��ö����䣬��ô�����Լ�����
	        return dp[state] = false;
	    }
}