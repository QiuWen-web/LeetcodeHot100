package ArrayProblem;

public class Solution1476 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] rectangle = {{1,2,1},{4,3,4},{3,2,1},{1,1,1}};
		SubrectangleQueries subrectangleQueries = new SubrectangleQueries(rectangle);
		System.out.println(subrectangleQueries.getValue(0, 2));
		
		subrectangleQueries.updateSubrectangle(0, 2, 3, 2, 5);
		
		int s = subrectangleQueries.getValue(0, 2);
		System.out.println(s);
		s = subrectangleQueries.getValue(3, 1);
		System.out.println(s);
		subrectangleQueries.updateSubrectangle(3, 0, 3, 2, 10);
		
		s = subrectangleQueries.getValue(3, 1); // ·µ»Ø 10
		System.out.println(s);
		s = subrectangleQueries.getValue(0, 2); // ·µ»Ø 5
		System.out.println(s);
	}

}
class SubrectangleQueries {
	private int[][] rectangle;
    public SubrectangleQueries(int[][] rectangle) {
    	this.rectangle = rectangle;
    }
    
    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
    	for(int i = row1;i<=row2;i++) {
    		for(int j =col1;j<=col2;j++) {
    			this.rectangle[i][j] = newValue;
    		}
    	}
    }
    
    public int getValue(int row, int col) {    	
		return this.rectangle[row][col];
    }
}