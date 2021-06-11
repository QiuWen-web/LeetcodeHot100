package DynamicProgram;

public class Solution304 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{3, 0, 1, 4, 2},{5, 6, 3, 2, 1},
				{1, 2, 0, 1, 5},{4, 1, 0, 1, 7},{1, 0, 3, 0, 5}};
		DynamicNumMatrix304 s = new DynamicNumMatrix304(matrix);
		System.out.println(s.sumRegion(2, 1, 4, 3));
		System.out.println(s.sumRegion(1, 1, 2, 2));
		System.out.println(s.sumRegion(1, 2, 2, 4));
	}

}
class DynamicNumMatrix304 {
	private int[][] matrix;
    public DynamicNumMatrix304(int[][] matrix) {
    	this.matrix = matrix;
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
    	int sum = 0;
    	for(int i = row1;i<=row2;i++) {
    		for(int j = col1;j<=col2;j++) {
    			sum += this.matrix[i][j];
    		}
    	}
    	return sum;
    }
}