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
    //����һ�����ʱ�ǣ�����λ�þ�δ����
    boolean[][] visited;
    //����ͼ��
    int[][] grid;
    public int numEnclaves(int[][] grid) {
        //������ȱ�����������߽��½�أ�������Щ½������������½����Ϊ2��ʣ�µ�1�ĸ������Ǵ�
        rows=grid.length;
        cols=grid[0].length;
        this.grid = grid;
        //����һ�����ʱ�ǣ�����λ�þ�δ����
        visited= new boolean[rows][cols];

        //������ȱ�����Ե½��
        //�ȱ�����������
        for(int i = 0;i<rows;i++){
            dfs(i,0);//��0������ֵ
            dfs(i,cols-1);//���һ������ֵ
        }
        for(int i = 0;i<cols;i++){
            dfs(0,i);//��0������ֵ
            dfs(rows-1,i);//���һ������ֵ
        }

        //�������֮�����п�����Ե��½��Ӧ�ö���Ϊ2��
        //ֻ��Ҫ�������е�ֵ������Ϊ1�ĸ���
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
            //������λ�ñ����ʹ��ˣ��򷵻�
            return;
        }
        if(grid[i][j] == 0){
            visited[i][j] = true;
            return;
        }
        if(grid[i][j] == 1&&!visited[i][j]){
            visited[i][j] = true;
            grid[i][j] = 2;
            //������չ
            if(i-1>=0){
                dfs(i-1,j);
            }
            //������չ
            if(i+1<rows){
                dfs(i+1,j);
            }
            //������չ
            if(j-1>=0){
                dfs(i,j-1);
            }
            //������չ
            if(j+1<cols){
                dfs(i,j+1);
            }
        }
    }
}