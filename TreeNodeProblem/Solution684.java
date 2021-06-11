package TreeNodeProblem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//冗余连接，在本问题中, 树指的是一个连通且无环的无向图。
public class Solution684 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] edges = {{1,5},{2,4},{3,4},{1,3},{3,5}};
		TreeSolution684 s = new TreeSolution684();
		int[] res = s.findRedundantConnection(edges);
		System.out.println(res[0]);
		System.out.println(res[1]);
	}

}
class TreeSolution684 {
    public int[] findRedundantConnection(int[][] edges) {
    	//答案保存在res中
    	int[] res = new int[2];
    	//得到图的行数
    	int n = edges.length;
    	//求得最大节点的值
    	int N = 1;
    	for(int[] i: edges) {
    		N = Math.max(i[0], N);
    		N = Math.max(i[1], N);
    	}
    	//建立动态规划表格
    	int[][] dp = new int[N][N];
    	//遍历edges跟新dp
    	for(int i =0;i<n;i++) {
    		int[] temp = edges[i];
    		int num1 = temp[0];
    		int num2 = temp[1];
    		
    		//如果dp【num1-1】【num2-1】==0
    		if(dp[num1-1][num2-1] == 0) {
    			dp[num1-1][num2-1] = 1;
    			//查询num1-1的列是否有等于1的
    			for(int j = 0;j<N;j++) {
    				if(dp[j][num1-1] == 1) {
    					if(j<num2-1) {
    						dp[j][num2-1] = 1;
    					}else {
    						dp[num2-1][j] = 1;
    					}
    					
    				}
    			}
    			//查询num1-1的行是否有等于1的
    			for(int j = 0;j<N;j++) {
    				if(dp[num1-1][j] == 1 && j != num2-1) {
    					if(j>num2-1) {
    						dp[num2-1][j] = 1;
    					}else {
    						dp[j][num2-1] = 1;
    					}
    					
    				}
    			}
    			
    			//查询num2-1的列是否有等于1的
    			for(int j = 0;j<N;j++) {
    				if(dp[j][num2-1] == 1 && j != num1-1) {
    					if(j<num1-1) {
    						dp[j][num1-1] = 1;	
    					}else {
    						dp[num1-1][j] = 1;
    					}
    					
    				}
    			}
    			//查询num2-1的行是否有等于1的
    			for(int j = 0;j<N;j++) {
    				if(dp[num2-1][j] == 1 ) {
    					if(j<num1-1) {
    						dp[j][num1-1] = 1;
    					}else {
    						dp[num1-1][j] = 1;
    					}
    					
    				}
    			}
    		}else {
    			//如果dp【num1-1】【num2-1】==1
    			//已经被连接了
    			res[0]= num1;
    			res[1]= num2;
    			break;
    		}
    		
    	}
    	
    	return res;
    }
    public int[] findRedundantConnection01(int[][] edges) {
    	int n = edges.length;
    	int[] res = new int[2];
    	Set<Integer> list = new HashSet<>();
    	for(int i = 0;i<n;i++) {
    		int num1 = edges[i][0];
    		int num2 = edges[i][1];
    		boolean flag = false;
    		if(!list.contains(num1)||!list.contains(num2)) {
    			list.add(num1);
    			list.add(num2);
    		}else {
    			res[0] = num1;
    			res[1] = num2;
    			flag = true;
    		}
    		if(flag) {
    			break;
    		}
    	}
    	return res;
    }
}