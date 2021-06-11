package DynamicProgram;

public class Solution873 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5,6,7,8};
		int[] arr1 = {1,3,7,11,12,14,18};
		DynamicSolution873 s = new DynamicSolution873();
		System.out.println(s.lenLongestFibSubseq(arr1));
	}

}
class DynamicSolution873 {
    public int lenLongestFibSubseq(int[] arr) {
    	int n = arr.length;
    	
    	int max = 0;
    	for(int i = 0;i<n-2;i++) {
			for(int j = i+1;j<n-1;j++) {
				int res = 2+count(arr,i,j);
				max = Math.max(max, res);
			}
		}
    	if(max == 2) {
    		return 0;
    	}else {
    		return max;
    	}
    	
    }
    public int count(int[] arr,int i,int j) {
    	
    	
    	for(int k = j+1;k<arr.length;k++) {
    		if(arr[i]+arr[j] == arr[k]) {
    			return 1+count(arr,j,k);
    			
    		}
    		if(arr[i]+arr[j] < arr[k]) {
    			return 0;
    		}
    	}
    	return 0;
    }
}