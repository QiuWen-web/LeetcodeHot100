package ArrayProblem;

import java.util.ArrayList;
import java.util.List;

public class Solution1260 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{3,8,1,9},{19,7,2,5},{4,6,11,10},{12,0,21,13}};
		int k = 4;
		ArraySolution1260 s = new ArraySolution1260();
		List<List<Integer>> res = s.shiftGrid(grid, k);
		for(int i = 0;i<res.size();i++) {
			for(int j = 0;j<res.get(i).size();j++) {
				System.out.print(res.get(i).get(j));
			}
			System.out.println();
		}
		
	}

}
class ArraySolution1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
    	int m = grid.length;
    	int n = grid[0].length;
    	while(k>0) {
    		int[][] gridtemp = new int[m][n];
    		for(int i = 0;i<m;i++) {
    			for(int j = 0;j<n-1;j++) {
    				gridtemp[i][j+1] = grid[i][j];
    			}
    		}
    		for(int i = 0;i<m-1;i++) {
    			gridtemp[i+1][0] = grid[i][n-1];
    		}
    		gridtemp[0][0] = grid[m-1][n-1];
    		grid = gridtemp;
    		k--;
    	}
    	
    	List<List<Integer>> res = new ArrayList<>();
    	for(int[] j : grid) {
    		List<Integer> row = new ArrayList<>();
    		for(int i :j) {
    			row.add(i);
    		}
    		res.add(row);
    	}
    	return res;
    }
}