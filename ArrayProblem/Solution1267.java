package ArrayProblem;

public class Solution1267 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}};
		ArraySolution1267 s= new ArraySolution1267();
		System.out.println(s.countServers(grid));
	}

}
class ArraySolution1267 {
    public int countServers(int[][] grid) {
    	int sum = 0;
    	for(int i = 0 ;i < grid.length;i++) {
    		for(int j = 0;j<grid[0].length;j++) {
    			if(grid[i][j] == 1) {
    				if(lookone(i,j,grid)) {
    					sum++;
    				}
    			}
    		}
    	}
    	return sum;
    }
    public boolean lookone(int i ,int j,int[][] grid) {
    	for(int m = 0 ;m<grid.length;m++) {
    		if(grid[m][j] == 1 && m != i) {
    			return true;
    		}
    	}
    	for(int n = 0 ;n<grid[0].length;n++) {
    		if(grid[i][n] == 1 && n != j) {
    			return true;
    		}
    	}
    	return false;
    }
}