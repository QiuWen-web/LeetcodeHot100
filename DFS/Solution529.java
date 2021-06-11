package DFS;

import java.awt.List;

//ɨ����Ϸ
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
    	//���һ�����ף�'M'�����ڳ�����Ϸ�ͽ�����- ������Ϊ 'X'��
    	rows = board.length;
    	cols = board[0].length;
    	m = click[0];
    	n = click[1];
    	if(board[m][n] == 'M') {
    		board[m][n] = 'X';
    		return board;
    	}
    	//���һ��û�����ڵ��׵Ŀշ��飨'E'�����ڳ���
    	//�޸���Ϊ��'B'�����������к������ڵ�δ�ڳ���
    	//�鶼Ӧ�ñ��ݹ�ؽ�¶��
    	dfs(board,m,n);
    	return board;
    }
    public void dfs(char[][] board,int m,int n) {
    	//�ж�m,n�Ƿ��������,���m��n���߽�
    	if(m<0||m>=rows||n<0||n>=cols) {
    		return;
    	}
    	//������m��n��
    	//�������ѱ���ʾ������
    	if(board[m][n] != 'E' && board[m][n] != 'M') {
    		return;
    	}
    	//��廹δ���������E
    	if(board[m][n] == 'E') {
    		//�鿴��Χ������������ҶԽ���
    		int sum = 0;
    		//��
    		if(m-1>=0) {
    			if(board[m-1][n] == 'M') {
    				sum++;
    			}
    			//���Ͻ�
    			if(n-1>=0) {
    				if(board[m-1][n-1] == 'M') {
    					
        				sum++;
        			}
    			}
    			//���Ͻ�
    			if(n+1<cols) {
    				if(board[m-1][n+1] == 'M') {
        				sum++;
        			}
    			}
    		}
    		//��
    		if(m+1<rows) {
    			if(board[m+1][n] == 'M') {
    				sum++;
    			}
    			//���½�
    			if(n-1>=0) {
    				if(board[m+1][n-1] == 'M') {
        				sum++;
        			}
    			}
    			//���½�
    			if(n+1<cols) {
    				if(board[m+1][n+1] == 'M') {
        				sum++;
        			}
    			}
    		}
    		//��
    		if(n-1>=0) {
    			if(board[m][n-1] == 'M') {
    				sum++;
    			}
    		}
    		//��
    		if(n+1<cols) {
    			if(board[m][n+1] == 'M') {
    				sum++;
    			}
    		}
    		//�鿴�����
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