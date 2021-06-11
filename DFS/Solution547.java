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
    	//����һ�����ʵ�
    	boolean[][] visited = new boolean[rows][cols];
//    	for(int i = 0;i<rows;i++) {
//    		visited[i][i] = true;
//    	}
    	//
    	int res = 0;
    	for(int i = 0;i<rows;i++) {
    		for(int j = 0;j<rows;j++) {
    			//���δ���ʣ����ҵ���1
    			if(!visited[i][j]&&isConnected[i][j] == 1) {
    				res++;
    				dfs(isConnected,i,j,visited);
    			}
    		}
    	}
    	return res;
    }
    public void dfs(int[][] isConnected,int i,int j,boolean[][] visited) {
    	//Ѱ��i��j����Ϊ1��λ�ã���Ϊ�ѷ���
    	visited[i][j] = true;
    	//��Ѱi��
    	for(int n = 0;n<rows;n++) {
    		if(!visited[i][n] && isConnected[i][n] == 1) {
    			dfs(isConnected,i,n,visited);
    		}
    	}
    	//��Ѱj��
    	for(int m = 0;m<rows;m++) {
    		if(!visited[m][j] && isConnected[m][j] == 1) {
    			dfs(isConnected,m,j,visited);
    		}
    	}
    }
}