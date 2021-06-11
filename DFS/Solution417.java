package DFS;

import java.util.ArrayList;
import java.util.List;

public class Solution417 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
		dfsSolution417 s = new dfsSolution417();
		s.pacificAtlantic(heights);
	}

}
class dfsSolution417 {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
    	List<List<Integer>> res = new ArrayList<>();
    	
    	
    	int rows = heights.length;
    	if(rows == 0) {
    		return res;
    	}
    	int cols = heights[0].length;
    	boolean[][] taipinyang = new boolean[rows][cols];
    	boolean[][] daxiyang = new boolean[rows][cols];
    	for(int i = 0;i<rows;i++) {
    		dfs(heights,i,0,taipinyang,heights[i][0]);
    		dfs(heights,i,cols-1,daxiyang,heights[i][cols-1]);
    	}
    	for(int i = 0;i<cols;i++) {
    		dfs(heights,0,i,taipinyang,heights[0][i]);
    		dfs(heights,rows-1,i,daxiyang,heights[rows-1][i]);
    	}
    	for(int i = 0;i<rows;i++) {
    		for(int j = 0;j<cols;j++) {
    			if(taipinyang[i][j]&& daxiyang[i][j]) {
    				List<Integer> item = new ArrayList<>();
    				item.add(i);
    				item.add(j);
    				res.add(item);
    			}
    		}
    	}
    	return res;
    }
    private void dfs(int[][] m, int x, int y, boolean[][] visited, int pre) {
        if(x < 0 || y < 0 || x >= m.length || y >= m[0].length || visited[x][y] || m[x][y] < pre) 
            return;
        visited[x][y] = true;
        dfs(m, x+1, y, visited, m[x][y]);
        dfs(m, x-1, y, visited, m[x][y]);
        dfs(m, x, y+1, visited, m[x][y]);
        dfs(m, x, y-1, visited, m[x][y]);
    }
}