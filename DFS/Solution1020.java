package DFS;

public class Solution1020 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid= {{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}};
		dfsSolution1020 s = new dfsSolution1020();
		int res = s.numEnclaves(grid);
		System.out.println(res);
	}

}
class dfsSolution1020 {
    int rows;
    int cols;
    //建立一个访问标记，所有位置均未访问
    boolean[][] visited;
    //复制图谱
    int[][] grid;
    public int numEnclaves(int[][] grid) {
        //深度优先遍历靠经网格边界的陆地，将和这些陆地相连的所有陆地置为2，剩下的1的个数就是答案
        rows=grid.length;
        cols=grid[0].length;
        this.grid = grid;
        //建立一个访问标记，所有位置均未访问
        visited= new boolean[rows][cols];

        //深度优先遍历边缘陆地
        //先遍历两个竖排
        for(int i = 0;i<rows;i++){
            dfs(i,0);//第0列所有值
            dfs(i,cols-1);//最后一列所有值
        }
        for(int i = 0;i<cols;i++){
            dfs(0,i);//第0行所有值
            dfs(rows-1,i);//最后一行所有值
        }

        //遍历完成之后所有靠近边缘的陆地应该都置为2了
        //只需要遍历所有的值，记下为1的个数
        int sum = 0;
        for(int i = 0;i<rows;i++){
            for(int j = 0;j<cols;j++){
                if(grid[i][j] == 1){
                    sum++;
                }
            }
        }
        return sum;
    }
    public void dfs(int i,int j){
        if(visited[i][j]){
            //如果这个位置被访问过了，则返回
            return;
        }
        if(grid[i][j] == 0){
            visited[i][j] = true;
            return;
        }
        if(grid[i][j] == 1&&!visited[i][j]){
            visited[i][j] = true;
            grid[i][j] = 2;
            //向上扩展
            if(i-1>=0){
                dfs(i-1,j);
            }
            //向下扩展
            if(i+1<rows){
                dfs(i+1,j);
            }
            //向左扩展
            if(j-1>=0){
                dfs(i,j-1);
            }
            //向右扩展
            if(j+1<cols){
                dfs(i,j+1);
            }
        }
    }
}