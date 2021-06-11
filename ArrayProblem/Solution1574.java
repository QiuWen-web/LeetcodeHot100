package ArrayProblem;

public class Solution1574 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {6,3,10,11,15,20,13,3,18,12};
		ArraySolution1574 s = new ArraySolution1574();
		System.out.println(s.findLengthOfShortestSubarray(arr));
	}

}
class ArraySolution1574 {
    public int findLengthOfShortestSubarray(int[] arr) {
    	int len = arr.length;
    	int left = 0;int right = len-1;
    	for(;left<len-1;left++) {
    		if(arr[left] > arr[left+1]) {
    			break;
    		}
    	}
    	if(left == len-1) {
    		return 0;
    	}
    	for(;right>1;right--) {
    		if(arr[right] < arr[right-1]) {
    			break;
    		}
    	}
    	if(arr[left] <= arr[right]) {
    		return right-left-1;
    	}
    	int deleteMinLen = Math.min(len - left - 1, right);
    	for (int i = 0; i <= left; i++){
            for (int j = right; j < len; j++){
                if (arr[i] <= arr[j]){ // 第一个大于等于
                    deleteMinLen = Math.min(deleteMinLen, j - i - 1);
                    break;
                }
            }
        }
    	return deleteMinLen;
    }
}