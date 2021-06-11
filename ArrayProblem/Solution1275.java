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
    	//��������
    	int[][] chessboard = new int[3][3];
    	//A�µ���1��ʾB�µ���2��ʾ
    	//�ܹ�����n��
    	int n = moves.length;
    	for(int i = 0;i<n;i++) {
    		if(i%2 == 0) {
    			//A��
    			int a = moves[i][0];
    			int b = moves[i][1];
    			chessboard[a][b] = 1;
    		}else {
    			//B��
    			int a = moves[i][0];
    			int b = moves[i][1];
    			chessboard[a][b] = 2;
    		}    		
    	}
    	//�Ѿ��������ˣ��ж�һ��˭ʤ˭��
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
    			//�鿴һ�����Ƿ�����ͬ��x��o

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
    			//�鿴һ�����Ƿ�����ͬ��x��o

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
    	//�ߵ��⣬˵��û��ʤ��
    	return "C";
    }
}