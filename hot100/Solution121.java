package hot100;

public class Solution121 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {7,6,4,3,1};
		int max = maxProfit(prices);
		System.out.println(max);
	}
	private static int maxProfit(int[] prices) {
		
		int money = 0;//׬������Ǯ
		int temp = 0;//��ʱ�Ƚϴ�С��Ǯ
		for(int index = 0;index<prices.length-1;index++) {
			//�½�һ����������
			for(int i = index+1;i<prices.length;i++) {
//				if(prices[index] >= prices[i]) {
//					//�������ʱ�ļ۸�prices[i]С������ʱ�ļ۸�prices[index]
//					//���迼��
//				}
				if(prices[index] < prices[i]) {
					//�������ʱ�ļ۸�prices[i]��������ʱ�ļ۸�prices[index]
					//���¼����ʱ׬��Ǯ����
					temp = prices[i]-prices[index];
					//�����ʱ��moneyС�����׬��Ǯ����ȡ��ε�
					if(money < temp) {
						money = temp;
					}
				}
			}
		}
		return money;
		
	}
}
