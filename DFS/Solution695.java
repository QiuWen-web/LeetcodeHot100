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
	//�洢����������
	int max = 0;
	//�洢ÿ��������������ĵ���ֵ
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
    	//����grid[i][j]�Ƿ����
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