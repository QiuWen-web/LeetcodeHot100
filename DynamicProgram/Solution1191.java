package DynamicProgram;

public class Solution1191 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-5,-2,0,0,3,9,-2,-5,4};
		int k = 5;
		DynamicSolution1191 s = new DynamicSolution1191();
		System.out.println(s.kConcatenationMaxSum(arr, k));
	}

}
class DynamicSolution1191 {
    public int kConcatenationMaxSum(int[] arr, int k) {
    	int base = 1000000007;
    	//一行数组的和
    	long arrSum = 0;
    	// 当前位置子数组最大和
    	long curr = 0;
    	//k=1时的最大和
    	long maxSum = 0;
    	int n = arr.length;
    	for(int i =0;i<n;i++) {
    		arrSum += arr[i];
    		curr = Math.max(curr+arr[i], (long)arr[i]);
    		maxSum = Math.max(curr, maxSum);
    	}
    	if(k == 1) {
    		return (int)(maxSum % base);
    	}
    	
    	//k等于2
    	long maxSum2 = maxSum;
    	for(int i =0;i<n;i++) {
      		curr = Math.max(curr+arr[i], (long)arr[i]);
    		maxSum2 = Math.max(curr, maxSum2);
    	}
    	if(k == 2) {
    		return (int)(maxSum2 % base);
    	}
    	if(arrSum > 0) {
    		return (int)(maxSum2 + (k-2) * arrSum)%base;
    	}else {
    		return (int)(maxSum2 % base);
    	}
    }
}
