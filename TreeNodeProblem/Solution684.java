package TreeNodeProblem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//�������ӣ��ڱ�������, ��ָ����һ����ͨ���޻�������ͼ��
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
    	//�𰸱�����res��
    	int[] res = new int[2];
    	//�õ�ͼ������
    	int n = edges.length;
    	//������ڵ��ֵ
    	int N = 1;
    	for(int[] i: edges) {
    		N = Math.max(i[0], N);
    		N = Math.max(i[1], N);
    	}
    	//������̬�滮���
    	int[][] dp = new int[N][N];
    	//����edges����dp
    	for(int i =0;i<n;i++) {
    		int[] temp = edges[i];
    		int num1 = temp[0];
    		int num2 = temp[1];
    		
    		//���dp��num1-1����num2-1��==0
    		if(dp[num1-1][num2-1] == 0) {
    			dp[num1-1][num2-1] = 1;
    			//��ѯnum1-1�����Ƿ��е���1��
    			for(int j = 0;j<N;j++) {
    				if(dp[j][num1-1] == 1) {
    					if(j<num2-1) {
    						dp[j][num2-1] = 1;
    					}else {
    						dp[num2-1][j] = 1;
    					}
    					
    				}
    			}
    			//��ѯnum1-1�����Ƿ��е���1��
    			for(int j = 0;j<N;j++) {
    				if(dp[num1-1][j] == 1 && j != num2-1) {
    					if(j>num2-1) {
    						dp[num2-1][j] = 1;
    					}else {
    						dp[j][num2-1] = 1;
    					}
    					
    				}
    			}
    			
    			//��ѯnum2-1�����Ƿ��е���1��
    			for(int j = 0;j<N;j++) {
    				if(dp[j][num2-1] == 1 && j != num1-1) {
    					if(j<num1-1) {
    						dp[j][num1-1] = 1;	
    					}else {
    						dp[num1-1][j] = 1;
    					}
    					
    				}
    			}
    			//��ѯnum2-1�����Ƿ��е���1��
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
    			//���dp��num1-1����num2-1��==1
    			//�Ѿ���������
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