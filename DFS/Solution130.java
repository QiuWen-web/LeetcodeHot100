package DFS;

public class Solution130 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {{'O','O','O'},{'O','O','O'},{'O','O','O'}};
		DFSSolution130 s = new DFSSolution130();
		s.solve(board);
		for(char[] i: board) {
			for(char item:i) {
				System.out.print(item+",");
			}
			System.out.println();
		}
	}

}
class DFSSolution130 {
	int m,n;
    public void solve(char[][] board) {
    	m = board.length;
    	if(m==0) {
    		return ;
    	}
    	n = board[0].length;
    	for(int i = 0;i<m;i++) {
    		dfs(board,i,0);
    		dfs(board,i,n-1);
    	}
    	for(int j = 0;j<n;j++) {
    		dfs(board,0,j);
    		dfs(board,m-1,j);
    	}
    	for(int i = 0;i<m;i++) {
    		for(int j = 0;j<n;j++) {
    			if(board[i][j] == 'A') {
    				board[i][j] = 'O';
    			}else if(board[i][j] =='O') {
    				board[i][j] ='X';
    			}
    		}
    	}
    }
    
    public void dfs(char[][] board,int i,int j) {
    	//上，下，左，右
      	int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};  	
    	if(board[i][j] =='O') {
    		board[i][j] = 'A';
    		for(int[] d:directions) {
    			if(i+d[0]<0 || i+d[0]>=m ||j+d[1]<0||j+d[1]>=n) {
    				//超出边界，必不可能被环绕
    				continue;
    			}
    			//如果没有超出边界，查看其上下左右是否是'0'
    			if(board[i+d[0]][j+d[1]] == 'O') {
    				//如果有O与之相连
    				dfs(board,i+d[0],j+d[1]);
    			}
    		}
    	}

    	
    }
}