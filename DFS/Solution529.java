package DFS;

import java.awt.List;

//扫雷游戏
public class Solution529 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] click = {1,2};
		char[][] board = {{'E', 'E', 'E', 'E', 'E'},
		                  {'E', 'E', 'M', 'E', 'E'},
		                  {'E', 'E', 'E', 'E', 'E'},
		                  {'E', 'E', 'E', 'E', 'E'}};
		dfsSolution529 s = new dfsSolution529();
		char[][] res = s.updateBoard(board, click);
		for(char[] i:res) {
			for(char j:i) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}

}
class dfsSolution529 {
	int rows;
	int cols;
	int m;
	int n;
    public char[][] updateBoard(char[][] board, int[] click) {
    	//如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
    	rows = board.length;
    	cols = board[0].length;
    	m = click[0];
    	n = click[1];
    	if(board[m][n] == 'M') {
    		board[m][n] = 'X';
    		return board;
    	}
    	//如果一个没有相邻地雷的空方块（'E'）被挖出，
    	//修改它为（'B'），并且所有和其相邻的未挖出方
    	//块都应该被递归地揭露。
    	dfs(board,m,n);
    	return board;
    }
    public void dfs(char[][] board,int m,int n) {
    	//判断m,n是否符合条件,如果m，n超边界
    	if(m<0||m>=rows||n<0||n>=cols) {
    		return;
    	}
    	//点击面板m，n处
    	//如果面板已被显示，返回
    	if(board[m][n] != 'E' && board[m][n] != 'M') {
    		return;
    	}
    	//面板还未点击，若是E
    	if(board[m][n] == 'E') {
    		//查看周围情况，上下左右对角线
    		int sum = 0;
    		//上
    		if(m-1>=0) {
    			if(board[m-1][n] == 'M') {
    				sum++;
    			}
    			//左上角
    			if(n-1>=0) {
    				if(board[m-1][n-1] == 'M') {
    					
        				sum++;
        			}
    			}
    			//右上角
    			if(n+1<cols) {
    				if(board[m-1][n+1] == 'M') {
        				sum++;
        			}
    			}
    		}
    		//下
    		if(m+1<rows) {
    			if(board[m+1][n] == 'M') {
    				sum++;
    			}
    			//左下角
    			if(n-1>=0) {
    				if(board[m+1][n-1] == 'M') {
        				sum++;
        			}
    			}
    			//右下角
    			if(n+1<cols) {
    				if(board[m+1][n+1] == 'M') {
        				sum++;
        			}
    			}
    		}
    		//左
    		if(n-1>=0) {
    			if(board[m][n-1] == 'M') {
    				sum++;
    			}
    		}
    		//右
    		if(n+1<cols) {
    			if(board[m][n+1] == 'M') {
    				sum++;
    			}
    		}
    		//查看完毕了
    		if(sum == 0) {
    			board[m][n] = 'B';
    		}else {
    			board[m][n] = (char)(sum+48);
    		}
    	}
    	if(board[m][n] == 'B') {
    		dfs(board,m-1,n-1);
        	dfs(board,m-1,n);
        	dfs(board,m-1,n+1);
        	dfs(board,m,n-1);
        	dfs(board,m,n+1);
        	dfs(board,m+1,n-1);
        	dfs(board,m+1,n);
        	dfs(board,m+1,n+1);
    	}
    } 
}