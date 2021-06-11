package DynamicProgram;

public class Solution1314 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
		int K = 2;
		DynamicSolution314 s = new DynamicSolution314();
		int[][] res = s.matrixBlockSum(mat, K);
		for(int[] k: res) {
			for(int i :k) {
				System.out.print(i+",");
			}
			System.out.println();
		}
	}

}
class DynamicSolution314 {
    public int[][] matrixBlockSum(int[][] mat, int K) {
    	int m = mat.length;
    	int n = mat[0].length;
    	int[][] answer = new int[m][n];
    	for(int i = 0;i<m;i++) {
    		for(int j = 0;j<n;j++) {
    			answer[i][j] = sum(mat,i,j,K);
    		}
    	}
    	return answer;
    }
    public int sum(int[][] mat,int i,int j,int K) {
    	int m = mat.length;
    	int n = mat[0].length;
    	int res = 0;
    	//1
    	if(i-K<0 && i+K>=m && j-K<0 && j+K>=n) {
    		
    		for(int r = 0;r<m;r++) {
    			for(int c = 0;c<n;c++) {
    				res += mat[r][c];
    			}
    		}
    		
    	}
    	//2
    	if(i-K<0 && i+K>=m && j-K<0 && j+K<n) {
    		
    		for(int r = 0;r<m;r++) {
    			for(int c = 0;c<=j+K;c++) {
    				res += mat[r][c];
    			}
    		}
    		
    	}
    	//3
    	if(i-K<0 && i+K>=m && j-K>=0 && j+K>=n) {
    		
    		for(int r = 0;r<m;r++) {
    			for(int c = j-K;c<n;c++) {
    				res += mat[r][c];
    			}
    		}
    		
    	}
    	//4
    	if(i-K<0 && i+K>=m && j-K>=0 && j+K<n) {
    		
    		for(int r = 0;r<m;r++) {
    			for(int c = j-K;c<=j+K;c++) {
    				res += mat[r][c];
    			}
    		}
    		
    	}
    	//5
    	if(i-K<0 && i+K<m && j-K<0 && j+K>=n) {
    		
    		for(int r = 0;r<=i+K;r++) {
    			for(int c = 0;c<n;c++) {
    				res += mat[r][c];
    			}
    		}
    		
    	}
    	//6
    	if(i-K<0 && i+K<m && j-K<0 && j+K<n) {
    		
    		for(int r = 0;r<=i+K;r++) {
    			for(int c = 0;c<=j+K;c++) {
    				res += mat[r][c];
    			}
    		}
    		
    	}
    	//7
    	if(i-K<0 && i+K<m && j-K>=0 && j+K>=n) {
    		
    		for(int r = 0;r<=i+K;r++) {
    			for(int c = j-K;c<n;c++) {
    				res += mat[r][c];
    			}
    		}
    		
    	}
    	//8
    	if(i-K<0 && i+K<m && j-K>=0 && j+K<n) {
    		
    		for(int r = 0;r<=i+K;r++) {
    			for(int c = j-K;c<=j+K;c++) {
    				res += mat[r][c];
    			}
    		}
    		
    	}
    	//1
    	if(i-K>=0 && i+K>=m && j-K<0 && j+K>=n) {
    		
    		for(int r = i-K;r<m;r++) {
    			for(int c = 0;c<n;c++) {
    				res += mat[r][c];
    			}
    		}
    		
    	}
    	//2
    	if(i-K>=0 && i+K>=m && j-K<0 && j+K<n) {
    		
    		for(int r = i-K;r<m;r++) {
    			for(int c = 0;c<=j+K;c++) {
    				res += mat[r][c];
    			}
    		}
    		
    	}
    	//3
    	if(i-K>=0 && i+K>=m && j-K>=0 && j+K>=n) {
    		
    		for(int r = i-K;r<m;r++) {
    			for(int c = j-K;c<n;c++) {
    				res += mat[r][c];
    			}
    		}
    		
    	}
    	//4
    	if(i-K>=0 && i+K>=m && j-K>=0 && j+K<n) {
    		
    		for(int r = i-K;r<m;r++) {
    			for(int c = j-K;c<=j+K;c++) {
    				res += mat[r][c];
    			}
    		}
    		
    	}
    	//5
    	if(i-K>=0 && i+K<m && j-K<0 && j+K>=n) {
    		
    		for(int r = i-K;r<=i+K;r++) {
    			for(int c = 0;c<n;c++) {
    				res += mat[r][c];
    			}
    		}
    		
    	}
    	//6
    	if(i-K>=0 && i+K<m && j-K<0 && j+K<n) {
    		
    		for(int r = i-K;r<=i+K;r++) {
    			for(int c = 0;c<=j+K;c++) {
    				res += mat[r][c];
    			}
    		}
    		
    	}
    	//7
    	if(i-K>=0 && i+K<m && j-K>=0 && j+K>=n) {
    		
    		for(int r = i-K;r<=i+K;r++) {
    			for(int c = j-K;c<n;c++) {
    				res += mat[r][c];
    			}
    		}
    		
    	}
    	//8
    	if(i-K>=0 && i+K<m && j-K>=0 && j+K<n) {
    		
    		for(int r = i-K;r<=i+K;r++) {
    			for(int c = j-K;c<=j+K;c++) {
    				res += mat[r][c];
    			}
    		}
    		
    	}
    	return res;
    }
}