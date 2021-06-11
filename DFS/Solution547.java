package DFS;

public class Solution547 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] isConnected = {{1,1,0},{1,1,0},{0,0,1}};
		dfsSolution547 s = new dfsSolution547();
		System.out.println(s.findCircleNum(isConnected));
	}

}
class dfsSolution547 {
	int rows;
	int cols;
    public int findCircleNum(int[][] isConnected) {
    	rows = isConnected.length;
    	cols = isConnected[0].length;
    	//设立一个访问点
    	boolean[][] visited = new boolean[rows][cols];
//    	for(int i = 0;i<rows;i++) {
//    		visited[i][i] = true;
//    	}
    	//
    	int res = 0;
    	for(int i = 0;i<rows;i++) {
    		for(int j = 0;j<rows;j++) {
    			//如果未访问，并且等于1
    			if(!visited[i][j]&&isConnected[i][j] == 1) {
    				res++;
    				dfs(isConnected,i,j,visited);
    			}
    		}
    	}
    	return res;
    }
    public void dfs(int[][] isConnected,int i,int j,boolean[][] visited) {
    	//寻找i行j列上为1的位置，设为已访问
    	visited[i][j] = true;
    	//搜寻i行
    	for(int n = 0;n<rows;n++) {
    		if(!visited[i][n] && isConnected[i][n] == 1) {
    			dfs(isConnected,i,n,visited);
    		}
    	}
    	//搜寻j列
    	for(int m = 0;m<rows;m++) {
    		if(!visited[m][j] && isConnected[m][j] == 1) {
    			dfs(isConnected,m,j,visited);
    		}
    	}
    }
}