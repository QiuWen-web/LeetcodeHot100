package hot100;
//����
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
    	//coins����
    	Arrays.sort(coins);
    	System.out.println(Arrays.toString(coins));
    	
    	//�õ����ܺ�С�������������ֵstopNum
    	int stopNum = -1;
    	for(int i = 0;i<coins.length;i++) {
    		if(coins[i]>amount) {
    			stopNum = i;
    		}
    	}
    	if(stopNum == -1) {
    		stopNum = coins.length;
    	}
    	
    	//���amount= 0����ȡ0��Ӳ��
    	if(amount == 0) {
    		return 0;
    	}
    	//���coins��Сֵ����amount��Ļ����ͷ���-1��
    	if(coins[0]>amount) {
    		return -1;
    	}
    	
    	//
    	
    }
}