package DynamicProgram;

public class Solution1504 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = {{1,1,1,1,0},{1,0,0,1,0},{0,0,1,0,1},{0,1,0,0,0}};
		int[][] mat1 = {{1,0,1},{1,1,0},{1,1,0}};
		int[][] mat2 = {{1,1,1,1,1,1}};
		int[][] mat4 = {{0,0,0},{0,0,0},{0,1,1},{1,1,0},{0,1,1}};
		DynamicSolution1504 s = new DynamicSolution1504();
		System.out.println(s.numSubmat(mat));
	}

}
class DynamicSolution1504 {
	
    public int numSubmat(int[][] mat) {
    	int m = mat.length;
    	int n = mat[0].length;
    	if(m == 1 && n == 1) {
    		if(mat[0][0] == 1) {
    			return 1;
    		}else {
    			return 0;
    		}
    	}
    	int count = 0;
    	for(int i = 0;i<m;i++) {
    		for(int j = 0;j<n;j++) {
    			count += dsf(mat,i,j);
    		}
    	}
    	return count;
    }
    public int dsf(int[][] mat,int i,int j) {
    	int count = 0;
    	int row = i;
    	int col = j;
    	for(;row<mat.length;row++) {
    		if(mat[row][j] == 0) {
    			break;
    		}
    	}
    	for(;col<mat[0].length;col++) {
    		if(mat[i][col] == 0) {
    			break;
    		}
    	}
    	for(int m = i;m<row;m++) {
    		for(int n = j;n<col;n++) {
    			if(mat[m][n] == 1 && m == i) {
    				count++;
    			}else if(mat[m][n] == 1 && m > i){
    				int k = i;
    				boolean s = true;
    				while(k<m) {
    					if(mat[k][n] == 0) {
    						s = false;
    					}
    					k++;
    				}
    				if(!s) {
    					break;
    				}else {
    					count++;
    				}
    			}else {break;}
    		}
    	}
    	return count;
    }
}