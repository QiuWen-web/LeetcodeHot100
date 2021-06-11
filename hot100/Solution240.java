package hot100;

public class Solution240 {
	public static void main(String[] args) {
		int[][] matrix = {{1,4,7,11,15},
						  {2,5,8,12,19},
						  {3,6,9,16,22},
						  {10,13,14,17,24},
						  {18,21,23,26,30}};
		int target = 5;
		
	}
	private boolean searchMatrix(int[][] matrix, int target) {
		int row = matrix.length;
		int column = matrix[0].length;
		for(int i = 0 ;i<row;i++) {
			for(int j = 0;j<column;j++) {
				if(matrix[i][j]==target) {
					return true;
				}
			}
		}
		return false;	
		
	}
	
}
