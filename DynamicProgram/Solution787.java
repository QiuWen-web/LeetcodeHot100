package DynamicProgram;

public class Solution787 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] flights = {{0,1,100},{1,2,100},{0,2,500}};
		int n = 3;
		int src = 0;
		int dst = 2;
		int K= 1;
		DynamicSolution787 s = new DynamicSolution787();
		System.out.println(s.findCheapestPrice(n, flights, src, dst, K));
	}

}
class DynamicSolution787 {
	private int[][] graph;
	private boolean[] visited;
	private int res = Integer.MAX_VALUE;
	
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
    	K=Math.min(K,n-2);
    	this.graph = new int[n][n];
    	for(int i = 0;i<flights.length;i++) {
    		graph[flights[i][0]][flights[i][1]] = flights[i][2];
    	}
    	this.visited = new boolean[n];
    	dfs(src,dst,K+1,0);
    	if(res == Integer.MAX_VALUE) {
    		return -1;
    	}
    	return res;
    }
    public void dfs(int src,int dst,int K,int cost) {
    	if(src == dst) {
    		res = cost;
    		return;
    	}
    	if(K==0) {
    		return;
    	}
    	for(int i = 0;i<graph.length;i++) {
    		if(graph[src][i] > 0) {
    			if(visited[i] == true) {
    				continue;
    			}
    			visited[i] = true;
    			if(cost + graph[src][i] > res) {
    				continue;
    			}
    			visited[i] = true;
    			dfs(i,dst,K-1,graph[src][i] + cost);
    			visited[i] = false;
    			
    		}
    	}
    }
}