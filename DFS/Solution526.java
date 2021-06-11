package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution526 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dfsSolution526 s = new dfsSolution526();
		int res =s.countArrangement(3);
		System.out.println(res);
	}

}
class dfsSolution526 {
	//存放不能放的键值对
	Map<Integer,Integer> map = new HashMap<>();
	int len;
	int sum = 0;
    public int countArrangement(int n) {
    	len = n+1;
    	int[] nums = new int[n+1];
    	boolean[] visited = new boolean[n+1];
    	int k = 1;
    	dfs(nums,visited,k);
    	return sum;
    }
    public void dfs(int[] nums,boolean[] visited,int k) {
    	if(k == len) {
    		sum++;
    		return;
    	}
    	//j为正整数
    	for(int j = 1;j<len;j++) {
    		if(!visited[j]) {
    			if(j%k == 0 || k%j == 0) {
					//如果这个位置符合优美条件
					visited[j] = true;
					nums[k] = j;
					k++;
					dfs(nums,visited,k);
					visited[j] = false;
					k--;
					nums[k] = 0;
				}
    		}
    	}
    }
}