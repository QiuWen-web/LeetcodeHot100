package DFS;

public class Solution695 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
		                {0,0,0,0,0,0,0,1,1,1,0,0,0},
		                {0,1,1,0,1,0,0,0,0,0,0,0,0},
		                {0,1,0,0,1,1,0,0,1,0,1,0,0},
		                {0,1,0,0,1,1,0,0,1,1,1,0,0},
		                {0,0,0,0,0,0,0,0,0,0,1,0,0},
		                {0,0,0,0,0,0,0,1,1,1,0,0,0},
		                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
		dfsSolution695 s  = new dfsSolution695();
		System.out.println(s.maxAreaOfIsland(grid));
	}

}
class dfsSolution695 {
	int rows;
	int cols;
	boolean[][] flag;
	//存储岛屿最大面积
	int max = 0;
	//存储每次深度优先搜索的岛屿值
	int temp = 0;
    public int maxAreaOfIsland(int[][] grid) {
    	rows = grid.length;
    	if(rows<=0) {
    		return 0;
    	}
    	cols = grid[0].length;
    	flag = new boolean[rows][cols];
    	for(int i = 0;i<rows;i++) {
    		for(int j = 0;j<cols;j++) {
    			if(grid[i][j] == 1 && flag[i][j] == false) {
    				temp = 0;
    				dfs(grid,i,j);
    				max = Math.max(max,temp);
    			}
    		}
    	}
    	return max;
    }
    public void dfs(int[][] grid,int i,int j) {
    	//搜索grid[i][j]是否符合
    	if(i<0||i>=rows||j<0||j>=cols) {
    		return;
    	}
    	if(grid[i][j] == 1 && flag[i][j] == false) {
    		temp++;
    		flag[i][j] = true;
    		dfs(grid,i-1,j);
    		dfs(grid,i+1,j);
    		dfs(grid,i,j-1);
    		dfs(grid,i,j+1);
    	}
    }
}