package ArrayProblem;

import java.util.Arrays;

public class Solution1275 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] moves = {{2,2},{0,2},{1,0},{0,1},{2,0},{0,0}};
		ArraySolution1275 s = new ArraySolution1275();
		System.out.println(s.tictactoe(moves));
	}

}
class ArraySolution1275 {
    public String tictactoe(int[][] moves) {
    	//建立棋盘
    	int[][] chessboard = new int[3][3];
    	//A下的用1表示B下的用2表示
    	//总共下了n次
    	int n = moves.length;
    	for(int i = 0;i<n;i++) {
    		if(i%2 == 0) {
    			//A下
    			int a = moves[i][0];
    			int b = moves[i][1];
    			chessboard[a][b] = 1;
    		}else {
    			//B下
    			int a = moves[i][0];
    			int b = moves[i][1];
    			chessboard[a][b] = 2;
    		}    		
    	}
    	//已经下完棋了，判断一下谁胜谁负
    	for(int[] k : chessboard) {
    		System.out.println(Arrays.toString(k));
    	}
    	String result = rule(chessboard);
    	if(result == "C") {
    		if(n == 9) {
    			return "Draw";
    		}else {
    			return "Pending";
    		}
    	}
    	return result;
    }
    public String rule(int[][] chessboard) {
    	for(int i = 0;i<3;i++) {
    		int Atimes = 0;
			int Btimes = 0;
    		for(int j = 0;j<3;j++) {
    			//查看一行中是否有相同的x或o

    			if(chessboard[i][j] == 1) {
    				Atimes++;
    			}
    			if(chessboard[i][j] == 2) {
    				Btimes++;
    			}
    			
    			if(Atimes == 3) {
    				return "A";
    			}
    			if(Btimes == 3) {
    				return "B";
    			}
    		}
    	}
    	for(int j = 0 ;j<3;j++) {
    		int Atimes = 0;
			int Btimes = 0;
    		for(int i =0;i<3;i++) {
    			//查看一列中是否有相同的x或o

    			if(chessboard[i][j] == 1) {
    				Atimes++;
    			}
    			if(chessboard[i][j] == 2) {
    				Btimes++;
    			}
    			if(Atimes == 3) {
    				return "A";
    			}
    			if(Btimes == 3) {
    				return "B";
    			}
    		}
    	}
    	if(chessboard[0][0] == 1 && chessboard[1][1] == 1 && chessboard[2][2] == 1) {
    		return "A";
    	}
    	if(chessboard[0][2] == 1 && chessboard[1][1] == 1 && chessboard[2][0] == 1) {
    		return "A";
    	}
    	if(chessboard[0][0] == 2 && chessboard[1][1] == 2 && chessboard[2][2] == 2) {
    		return "B";
    	}
    	if(chessboard[0][2] == 2 && chessboard[1][1] == 2 && chessboard[2][0] == 2) {
    		return "B";
    	}
    	//走到这，说明没有胜负
    	return "C";
    }
}