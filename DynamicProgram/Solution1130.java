package DynamicProgram;

public class Solution1130 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {6,2,4};
		DynamicSolution1130 s = new DynamicSolution1130();
		System.out.println(s.mctFromLeafValues(arr));
	}

}
class DynamicSolution1130 {
    public int mctFromLeafValues(int[] arr) {
        //1. ״̬:��������Ҷ�ڵ�ĸ���;ѡ��:�ڵ㻮�֣���Щ����������/��Щ������������
        //2. dp[i][j]=x; i�����±���ʼ�㣬j��ʾ�����±��յ�
        int len = arr.length;
        int[][] dp = new int[len][len];
        //3. base case
        /*���ڷ�Ҷ�ڵ��ֵ�����������ֱ����Ҷ�ڵ��ֵ�˻���������Ҫ֪��������������ֵ*/
        /*����Ҫ����С��������������������ÿ����Ҷ�ڵ㶼������С��������Ҫ��dp��ʼ��*/   
        int[][] maxVal = new int[len][len];
        for (int i = 0;i < len;i++)
            maxVal[i][i] = arr[i];
        for (int i = 0;i < len; i++){
            for (int j = i+1; j < len; j++){
                maxVal[i][j] = Math.max(maxVal[i][j-1],arr[j]);
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        //4. ״̬ת��
        for (int l = 1; l < len; l++){//l=j-i �����ȣ�
            for (int i = 0; i < len-l; i++){//��ʼ��i,�յ�i+l-1
                for (int k = i; k < i+l; k++){//�м�ָ�㣨����
                    dp[i][i+l] = Math.min(dp[i][i+l],dp[i][k] + dp[k+1][i+l] + maxVal[i][k] * maxVal[k+1][i+l]);
                }
            }

        }

        return dp[0][len-1];
    }
}