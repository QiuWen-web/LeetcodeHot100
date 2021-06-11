package DynamicProgram;

import java.util.ArrayList;
import java.util.List;

public class Solution576 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DynamicSolution576 s = new DynamicSolution576();
		System.out.println(s.findPaths01(1,3,3,0,1));
	}

}
class DynamicSolution576 {
	/*
	 * m行，n列
	 * 球在i行j列
	 * N步之内移出网格的方法个数
	 * */
    public int findPaths(int m, int n, int N, int i, int j) {
    	int[] dp = new int[N+1];
    	dp[0] = 0;
    	//初始化位置
    	List<Integer> location = new ArrayList<>();
    	
    	location.add(i);location.add(j);
    	
    	
    	for(int k = 1;k<N+1;k++) {
    		int count = 0;
    		List<Integer> pre = new ArrayList<>();

    		
    		pre.addAll(location);

    		location.clear();
    		for(int t = 0;t<pre.size();t+=2) {
    			//向下
    			if(pre.get(t)+1>=m || pre.get(t)+1<0) {
    				count++;
    			}else {
    				location.add(pre.get(t)+1);
    				location.add(pre.get(t+1));
    			}
    			//向上
    			if(pre.get(t)-1>=m || pre.get(t)-1<0) {
    				count++;
    			}else {
    				location.add(pre.get(t)-1);
    				location.add(pre.get(t+1));
    			}
    			//向右
    			if(pre.get(t+1)+1>=n || pre.get(t+1)+1<0) {
    				count++;
    			}else {
    				location.add(pre.get(t));
    				location.add(pre.get(t+1)+1);
    			}
    			//向左
    			if(pre.get(t+1)-1>=n || pre.get(t+1)-1<0) {
    				count++;
    			}else {
    				location.add(pre.get(t));
    				location.add(pre.get(t+1)-1);
    			}
    		}
    		
    		dp[k] = count;
    	}
    	int sum = 0;
    	for(int s = 0;s<dp.length;s++) {
    		sum += dp[s];
    	}
    	return sum%1000000007;
    }
    public int findPaths01(int m, int n, int N, int i, int j) {
    	int[][] dp = new int[m][n];
    	dp[i][j] = 1;
    	int[][] dp2 = new int[m][n];
    	int sum = 0;
    	for(int t = 1;t<=N;t++) {
    		
    		for(int a = 0;a<m;a++) {
    			for(int b = 0;b<n;b++) {
    				if(dp[a][b] != 0) {
    					int count = jisuanchukou(a,b,dp[a][b],m,n,dp,dp2);
    					
    					sum += count;
    				}
    			}
    		}
    		for(int a = 0;a<m;a++) {
    			for(int b = 0;b<n;b++) {
    				dp[a][b] = dp2[a][b];
    				dp2[a][b] = 0;
    			}
    		}
    		
    	}
    	return sum;
    }
    public int jisuanchukou(int a,int b,int qiu,int m,int n,int[][] dp,int[][] dp2) {
    	int count = 0;
		//向上走逃出
		if(a-1<0||a-1>=m) {
			count++;
		}else {
			dp2[a-1][b] += qiu;
		}
		//向下走逃出
		if(a+1<0||a+1>=m) {
			count++;
		}else {
			dp2[a+1][b] += qiu;
		}
		//向左走逃出
		if(b-1<0||b-1>=n) {
			count++;
		}else {
			dp2[a][b-1] += qiu;
		}
		//向右走逃出
		if(b+1<0||b+1>=n) {
			count++;
		}else {
			dp2[a][b+1] += qiu;
		}
		return count*qiu;
    }
}