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
    //Ѱ��λ��r0,c0������ͨ����
    //���������������r0,c0����ͬһ��ɫ�ı߽�����Ϊcolorֵ
    //����Ҫ��¼һ��r0,c0����ǰ����ɫ
    int curcolor;
    //������ҪȾ�ɵ���ɫ
    int color;
    //��������
    int[][] grid;
    //���浱ǰ������к�����
    int rows,cols;
    //����һ��visited��ʾ���ʱ��
    boolean[][] visited;
    //����λ��
    List<Integer> location = new ArrayList<>();
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        //��ֵ��ǰ��ɫ
        curcolor = grid[r0][c0];
        this.color = color;
        this.grid = grid;
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];
        //������ȱ���r0,c0������ͨ�����ı߽�
        dfs(r0,c0);
      //����locationȾɫ
        for(int i = 0;i<location.size()-1;i+=2){
            grid[location.get(i)][location.get(i+1)]=color;
        }
        return grid;
    }
    //��ͨ�����ı߽���ָ��ͨ�����е������벻�ڷ����е����������ڣ��ĸ������ϣ������������Σ�
    //����������ı߽��ϣ���һ��/�л����һ��/�У������������Ρ�
    public void dfs(int i,int j){
        //�ȿ��ڶ���������������ı߽��ϣ���һ��/�л����һ��/�У������������Ρ�
        //��i=0/i=rows-1/j=0/j=cols-1
        visited[i][j] = true;
        if(i==0||j==0||i==rows-1||j==cols-1){
            //����������Ⱦɫ�ɡ�
        	location.add(i);
            location.add(j);
        }else if(grid[i-1][j] != curcolor || grid[i+1][j] != curcolor ||grid[i][j-1] != curcolor ||grid[i][j+1] != curcolor){
            //�ڶ����������벻�ڷ����е����������ڣ��ĸ������ϣ�������������
            //���ĸ�������ֻҪ����һ����ɫ���ǵ�ǰɫ�ľͿ���Ⱦgrid[i][j]
        	location.add(i);
            location.add(j);
        }

        //���ȱ���
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