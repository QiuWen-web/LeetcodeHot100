package hot100;

import java.util.ArrayList;

public class Solution079 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {
		                  {'A','B','C','E'},
		                  {'S','F','C','S'},
		                  {'A','D','E','E'}
		};
		String word = "ABCB";
		boolean[][] visited = new boolean[board.length][board[0].length];
		
		for(int i = 0;i < board.length;i++) {
    		for(int j= 0;j < board[0].length;j++) {
    			//¿ªÊ¼Ñ°ÕÒ
    			boolean flag = check(board, visited, i, j, word, 0);
                if (flag) {
                    System.out.println(true);;
                }
    		}
    	}
		System.out.println(false);
	}
    public static boolean check(char[][] board, boolean[][] visited, int i, int j, String s, int k) {
        if (board[i][j] != s.charAt(k)) {
            return false;
        } else if (k == s.length() - 1) {
            return true;
        }
        
        visited[i][j] = true;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if (!visited[newi][newj]) {
                    boolean flag = check(board, visited, newi, newj, s, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visited[i][j] = false;
        
        return result;
    }

}
