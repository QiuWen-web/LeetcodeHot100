package DynamicProgram;

public class Solution1139 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{0,0,0,1}};
		DynamicSolution1139 s = new DynamicSolution1139();
		System.out.println(s.largest1BorderedSquare(grid));
	}

}
class DynamicSolution1139 {
    public int largest1BorderedSquare(int[][] grid) {
    	int m = grid.length;
    	int n = grid[0].length;
    	int maxbian = Math.min(m,n);
    	int res = 0;
    	for(int k = maxbian;k>0;k--) {
    		if(lookforissquare(grid,k,m,n)) {
    			res = k;
    			break;
    		}
    	}
    	return res;
    }
    public boolean lookforissquare(int[][] grid,int k,int m,int n) {
    	for(int i = 0;i<=m-k;i++) {
    		for(int j = 0;j<=n-k;j++) {
    			//从grid[i][j]为起点向一周寻找是否都为1
    			if(isaroundsquare(grid,i,j,k)) {
    				return true;
    			}
    		}
    	}
    	return false;
    }
    public boolean isaroundsquare(int[][] grid,int i,int j,int k) {
    	//先找横向
    	for(int n = j;n<k+j;n++) {
    		if(grid[i][n] != 1) {
    			return false;
    		}
    		if(grid[i+k-1][n] != 1) {
    			return false;
    		}
    	}
    	for(int m = i;m<k+i;m++) {
    		if(grid[m][j] != 1) {
    			return false;
    		}
    		if(grid[m][j+k-1] != 1) {
    			return false;
    		}
    	}
    	return true;
    }
}