package DynamicProgram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class Solution1049 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] stones = {1,2,3,5,7};
		DynmicSolution1049 s = new DynmicSolution1049();
		System.out.println(s.lastStoneWeightII(stones));
	}

}
class DynmicSolution1049 {
    public int lastStoneWeightII(int[] stones) {
    	
    	int[]dp = new int[15001];
        int sum = 0;
        for (int i = 0; i < stones.length; i++) sum += stones[i];
        int target = sum / 2;
        for (int i = 0; i < stones.length; i++) { // 遍历物品
            for (int j = target; j >= stones[i]; j--) { // 遍历背包
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - dp[target] - dp[target];

    }
}