package ArrayProblem;

public class jianzhioffice004 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] matrix = {{1,4,7,11,15},
//				{2,5,8,12,19},
//				{3,6,9,16,22},
//				{10,13,14,17,24},
//				{18,21,23,26,30}};
//		int[][] matrix = {{1,2,3,7,8},{5,10,14,16,19},{8,10,18,19,23},{9,12,22,24,29}};
		int[][] matrix = {{4,6,9,10,15},{9,12,13,15,16}};
		int target = 14;
		jianzhiSolution004 s = new jianzhiSolution004();
		System.out.println(s.findNumberIn2DArray(matrix, target));
		System.out.println(s.findNumberIn2DArray01(matrix, target));
	}

}
class jianzhiSolution004 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
    	int m = matrix.length;
    	int n = matrix[0].length;
    	for(int i = 0;i<m;i++) {
    		for(int j = 0;j<n;j++) {
    			if(matrix[i][j] == target) {
    				return true;
    			}
    		}
    	}
    	return false;
    }
    public boolean findNumberIn2DArray01(int[][] matrix, int target) {
    	int m = matrix.length;
        if(m == 0){
            return false;
        }
    	int n = matrix[0].length;
        if(n == 1) {
        	for(int k = 0;k<m;k++) {
        		if(matrix[k][0] == target) {
        			return true;
        		}
        	}
        	return false;
        }
        if(m == 1) {
        	for(int k = 0;k<n;k++) {
        		if(matrix[0][k] == target) {
        			return true;
        		}
        	}
        	return false;
        }
    	int i = 0;
    	int j = 0;
    	while(i<m&&j<n) {
    		if(matrix[i][j]<target) {
    			i++;
    			j++;
    		}else {
    			break;
    		}
    	}
    	//此时的matrix[i][j]已经>=target了，
    	//从i，j向左下寻找；
    	int tempi = i;
    	int tempj = j;
    	while(tempj>=0 && tempj < n &&tempi<m&&tempi>=0) {
    		if(matrix[tempi][tempj] == target) {
    			return true;
    		}else if(matrix[tempi][tempj] > target){
    			tempj--;
    		}else {
    			tempi++;
    		}
    	}
    	//从i，j向右上寻找；
    	int temi = i;
    	int temj = j;
    	while(temj<n && temj >= 0 &&temi>=0 &&temi<m) {
    		if(matrix[temi][temj] == target) {
    			return true;
    		}else if(matrix[temi][temj] > target){
    			temi--;
    		}else {
    			temj++;
    		}
    	}
    	if(i==m && j<n && j>=0) {
    		int tei = i-1;
        	int tej = j;
        	while(tej<n && tej >= 0 &&tei>=0 &&tei<m) {
        		if(matrix[tei][tej] == target) {
        			return true;
        		}else if(matrix[tei][tej] > target){
        			tei--;
        		}else {
        			tej++;
        		}
        	}
    	}
    	if( j == n && i<m && i >= 0) {
    		int temppi = i;
        	int temppj = j-1;
        	while(temppj>=0 && temppj < n &&temppi<m&&temppi>=0) {
        		if(matrix[temppi][temppj] == target) {
        			return true;
        		}else if(matrix[temppi][temppj] > target){
        			temppj--;
        		}else {
        			temppi++;
        		}
        	}
    	}
    	return false;
    }
}