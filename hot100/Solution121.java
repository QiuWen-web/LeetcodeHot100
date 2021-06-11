package hot100;

public class Solution121 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {7,6,4,3,1};
		int max = maxProfit(prices);
		System.out.println(max);
	}
	private static int maxProfit(int[] prices) {
		
		int money = 0;//赚的最大的钱
		int temp = 0;//临时比较大小的钱
		for(int index = 0;index<prices.length-1;index++) {
			//新建一个买入索引
			for(int i = index+1;i<prices.length;i++) {
//				if(prices[index] >= prices[i]) {
//					//如果卖出时的价格prices[i]小于买入时的价格prices[index]
//					//则不予考虑
//				}
				if(prices[index] < prices[i]) {
					//如果卖出时的价格prices[i]大于买入时的价格prices[index]
					//则记录到临时赚的钱包里
					temp = prices[i]-prices[index];
					//如果此时的money小于这次赚的钱，则取这次的
					if(money < temp) {
						money = temp;
					}
				}
			}
		}
		return money;
		
	}
}
