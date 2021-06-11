package ArrayProblem;

public class Solution74 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
		int target = 5;
		ArraySolution74 s = new ArraySolution74();
		System.out.println(s.searchMatrix(matrix, target));
	}

}
class ArraySolution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
    	int m = matrix.length;
    	int n = matrix[0].length;
    	int targetrow = m-1;
    	for(int i = 0;i<m;i++) {
    		
    		if(target < matrix[i][0]) {
    			//即target在i-1行中
    			targetrow = i-1;
    			break;
    		}
    	}

    	if(targetrow ==-1) {
    		return false;
    	}
    	//开始在这一行中用二分查找
    	int left = 0;
    	int right = n-1;
    	while(left <= right) {
    		int mid = (left+right)/2;
    		if(matrix[targetrow][mid] > target) {
    			right = mid-1;
    		}else if(matrix[targetrow][mid] < target) {
    			left = mid+1;
    		}else {
    			return true;
    		}
    	}
    	return false;
    }
}