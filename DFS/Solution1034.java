package DFS;

import java.util.ArrayList;
import java.util.List;

public class Solution1034 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{1,2,1,2,1,2},{2,2,2,2,1,2},{1,2,2,2,1,2}};
		dfsSolution1034 s = new dfsSolution1034();
		int[][] res = s.colorBorder(grid, 1, 3, 1);
		for(int[] i : res) {
			for(int j : i) {
				System.out.print(j+",");
			}
			System.out.println();
		}
	}

}
class dfsSolution1034 {
    //寻找位于r0,c0处的连通分量
    //可以深度有限搜索r0,c0，将同一颜色的边界设置为color值
    //首先要记录一下r0,c0处当前的颜色
    int curcolor;
    //保存需要染成的颜色
    int color;
    //保存网格
    int[][] grid;
    //保存当前网格的行和列数
    int rows,cols;
    //设置一个visited表示访问标记
    boolean[][] visited;
    //保存位置
    List<Integer> location = new ArrayList<>();
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        //赋值当前颜色
        curcolor = grid[r0][c0];
        this.color = color;
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];
        //深度优先遍历r0,c0处的连通分量的边界
        dfs(r0,c0);
      //遍历location染色
        for(int i = 0;i<location.size()-1;i+=2){
            grid[location.get(i)][location.get(i+1)]=color;
        }
        return grid;
    }
    //连通分量的边界是指连通分量中的所有与不在分量中的正方形相邻（四个方向上）的所有正方形，
    //或者在网格的边界上（第一行/列或最后一行/列）的所有正方形。
    public void dfs(int i,int j){
        //先看第二个条件：在网格的边界上（第一行/列或最后一行/列）的所有正方形。
        //即i=0/i=rows-1/j=0/j=cols-1
        visited[i][j] = true;
        if(i==0||j==0||i==rows-1||j==cols-1){
            //符合条件，染色吧、
        	location.add(i);
            location.add(j);
        }else if(grid[i-1][j] != curcolor || grid[i+1][j] != curcolor ||grid[i][j-1] != curcolor ||grid[i][j+1] != curcolor){
            //第二个条件：与不在分量中的正方形相邻（四个方向上）的所有正方形
            //即四个方向上只要存在一个颜色不是当前色的就可以染grid[i][j]
        	location.add(i);
            location.add(j);
        }

        //优先遍历
        if(i-1>=0 && grid[i-1][j] == curcolor && !visited[i-1][j]){
            dfs(i-1,j);
        }
        if(i+1<rows && grid[i+1][j] == curcolor && !visited[i+1][j]){
            dfs(i+1,j);
        }
        if(j-1>=0 && grid[i][j-1] == curcolor && !visited[i][j-1]){
            dfs(i,j-1);
        }
        if(j+1<cols && grid[i][j+1] == curcolor && !visited[i][j+1]){
            dfs(i,j+1);
        }
        
    }
}