package DynamicProgram;

public class Solution375 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DynamicSolution375 s = new DynamicSolution375();
		System.out.println(s.getMoneyAmount(10));
	}

}
class DynamicSolution375 {
	
    public int getMoneyAmount(int n) {
        if(n==1) {
            return 0;
        }
        //�������
        int[][] dp = new int[n+1][n+1];
        //��ʼ����\��
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                dp[i][j]=Integer.MAX_VALUE;
            }
        }
        //�������ֵdp[i][i]
        for(int i=0;i<=n;i++){
            dp[i][i]=0;
        }

        //���������ӵ�2�п�ʼ
        for(int j=2;j<=n;j++){
            //����������������
            for(int i=j-1;i>=1;i--){
                //��������˵�ÿһ���ָ��
                for(int k=i+1;k<=j-1;k++){
                    dp[i][j]=Math.min(k+Math.max(dp[i][k-1],dp[k+1][j]),dp[i][j]);
                }
                //������
                dp[i][j]=Math.min(dp[i][j],i+dp[i+1][j]);
                dp[i][j]=Math.min(dp[i][j],j+dp[i][j-1]);
            }
        }
        return dp[1][n];
    }
}