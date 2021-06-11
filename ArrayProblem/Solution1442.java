package ArrayProblem;

public class Solution1442 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,3,1,6,7};
		ArraySolution1442 s = new ArraySolution1442();
		System.out.println(s.countTriplets(arr));
	}

}
class ArraySolution1442 {
    public int countTriplets(int[] arr) {
    	int sum = 0;
    	for(int i = 0;i<arr.length;i++) {
    		int a = 0;
    		for(int j = i+1;j<arr.length;j++) {
    			a ^= arr[j-1];
    			int b = 0; 
    			for(int k = j;k<arr.length;k++) {
    				b ^= arr[k];
    				if(a == b) {
    					sum++;
    				}
    			}
    		}
    	}
    	return sum;
    }
}