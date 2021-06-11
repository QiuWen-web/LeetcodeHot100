package DFS;

public class Solution743 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
		dfsSolution743  s=  new dfsSolution743();
		System.out.println(s.networkDelayTime(times, 4, 2));
	}

}
class dfsSolution743 {
	int t = 0;
	boolean[] visited;
	int len;
	int itemki = Integer.MAX_VALUE;
    public int networkDelayTime(int[][] times, int n, int k) {
    	len = times.length;
    	//初始化访问节点
    	visited = new boolean[n];
    	//深度优先遍历
    	visited[k-1] = true;
    	for(int i = 1;i<=n;i++) {
    		if(i!=k) {
    			//从k->i路上所花的最少时间
    			//深度优先搜索k->i的所有有效路径，求其最少时间
    			dfs(times,k,i,0);
    			t = Math.max(t, itemki);
    			itemki = Integer.MAX_VALUE;
    		}
    	}
    	if(t==Integer.MAX_VALUE) {
    		return -1;
    	}else {
    		return t;
    	}
    	
    }
    public void dfs(int[][] times,int k,int s,int mintimes) {
    	if(k==s) {
    		itemki = Math.min(itemki, mintimes);
    		return;
    	}
    	
    	for(int i = 0;i<len;i++) {
    		if(times[i][0] == k && !visited[times[i][1]-1]) {
    			visited[times[i][1]-1] = true;
    			dfs(times,times[i][1],s,mintimes+times[i][2]);
    			visited[times[i][1]-1] = false;
    		}
    	}
    	
    	
    }
}