package DFS;

import java.util.Arrays;

public class Solution473 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] matchsticks = {3,3,3,3,4};
		dfsSolution473 s = new dfsSolution473();
		System.out.println(s.makesquare(matchsticks));
	}

}
class dfsSolution473 {
	int len;
	int n;
    public boolean makesquare(int[] matchsticks) {
    	n = matchsticks.length;
    	if(n<=3) {
    		return false;
    	}
    	//对火柴求和
    	int sum = 0;
    	for(int i = 0;i<n;i++) {
    		sum += matchsticks[i];
    	}
    	if(sum%4 != 0) {
    		return false;
    	}
    	Arrays.sort(matchsticks);
    	len = sum/4;
    	if(matchsticks[n-1] > len) {
    		return false;
    	}
    	boolean[] visited = new boolean[n];
    	for(int index = 0;index<4;index++) {
    		dfs1(matchsticks,visited,index);
    	}
    	if(flag[0]&&flag[1]&&flag[2]&&flag[3]) {
    		return true;
    	}
    	
    	return false;
    }

    boolean[] flag = new boolean[4];
    int[] nums = new int[4];
    public void dfs1(int[] matchsticks,boolean[] visited,int index) {
    	if(flag[index]) {
    		return;
    	}
    	//深度优先遍历，能不能凑到4个len
    	//需要东西记录是否访问过,访问为true，未访为false;    	
    	for(int i = n-1;i>=0;i--) {
    		if(matchsticks[i] + nums[index] <len && !visited[i]) {
    			//如果当前火柴的长度加上已有的火柴长度小于等于len
    			//并且没有用过
    			//则加入当前序列
    			nums[index] += matchsticks[i];
    			//设为访问
    			visited[i] = true;
    			dfs1(matchsticks,visited,index);
    			if(flag[index]) {
    	    		return;
    	    	}
    			nums[index] -= matchsticks[i];
    			visited[i] = false;
    		}else if(matchsticks[i] + nums[index] == len && !visited[i]) {
    			nums[index] += matchsticks[i];
    			visited[i] = true;
    			flag[index] = true;
    			break;
    		}
    	}
    	
    }
    
}