package hot100;
//不会
import java.util.Arrays;

public class Solution322 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = {1,5,2};
		int amount = 11;
		HotSolution322 hotSolution322 = new HotSolution322();
		System.out.println(hotSolution322.coinChange(coins, amount));

	}

}
class HotSolution322 {
    public int coinChange(int[] coins, int amount) {
    	//coins排序
    	Arrays.sort(coins);
    	System.out.println(Arrays.toString(coins));
    	
    	//得到比总和小的数的索引最大值stopNum
    	int stopNum = -1;
    	for(int i = 0;i<coins.length;i++) {
    		if(coins[i]>amount) {
    			stopNum = i;
    		}
    	}
    	if(stopNum == -1) {
    		stopNum = coins.length;
    	}
    	
    	//如果amount= 0；则取0个硬币
    	if(amount == 0) {
    		return 0;
    	}
    	//如果coins最小值都比amount大的话，就返回-1；
    	if(coins[0]>amount) {
    		return -1;
    	}
    	
    	//
    	
    }
}