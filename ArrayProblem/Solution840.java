package ArrayProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution840 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{3,2,9,2,7},{6,1,8,4,2},{7,5,3,2,7},{2,9,4,9,6},{4,3,8,2,5}};
		ArraySolution840 s = new ArraySolution840();
		System.out.println(s.isSquare(grid, 1, 0));
		System.out.println(s.numMagicSquaresInside(grid));
	}

}
class ArraySolution840 {
    public int numMagicSquaresInside(int[][] grid) {
    	int rows = grid.length;
    	int cols = grid[0].length;
    	if(rows<3 || cols <3) {
    		return 0;
    	}
    	int iend = rows-2;
    	int jend = cols-2;
    	int sum = 0;
    	for(int i = 0;i<iend;i++) {
    		for(int j = 0;j<jend;j++) {
    			if(isSquare(grid,i,j)) {
    				sum++;
    			}
    		}
    	}
    	return sum;
    }
    public boolean isSquare(int[][] grid,int istart,int jstart) {
    	for(int i = istart;i<3+istart;i++) {
    		int rowsum = 0;
    		for(int j = jstart;j<3+jstart;j++) {
    			rowsum = rowsum + grid[i][j];
    		}
    		if(rowsum != 15) {
    			return false;
    		}
    	}
    	for(int j = jstart;j<3+jstart;j++) {
    		int colsum = 0;
    		for(int i = istart;i<3+istart;i++) {
    			colsum = colsum + grid[i][j];
    		}
    		if(colsum != 15) {
    			return false;
    		}
    	}
    	if(grid[istart][jstart] + grid[istart+1][jstart+1] +grid[istart+2][jstart+2] != 15 ||grid[istart+2][jstart] + grid[istart+1][jstart+1] +grid[istart][jstart+2] != 15) {
    		return false;
    	}
    	HashMap<Integer, Integer> list = new HashMap<>();
    	list.put(1, 1);
    	list.put(2, 1);
    	list.put(3, 1);
    	list.put(4, 1);
    	list.put(5, 1);
    	list.put(6, 1);
    	list.put(7, 1);
    	list.put(8, 1);
    	list.put(9, 1);
    	for(int i = istart;i<istart+3;i++) {
    		for(int j = jstart;j<jstart+3;j++) {
    			if(!list.containsKey(grid[i][j])) {
    				return false;
    			}else {
    				list.remove(grid[i][j]);
    			}
    		}
    	}
    	return true;
    }
}