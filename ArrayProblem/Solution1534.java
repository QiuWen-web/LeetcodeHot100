package ArrayProblem;

import java.util.Arrays;

public class Solution1534 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {7,3,7,3,12,1,12,2,3};
		int a = 5;
		int b = 8;
		int c = 1;
		ArraySolution1534 s = new ArraySolution1534();
		System.out.println(s.countGoodTriplets(arr, a, b, c));
	}

}
class ArraySolution1534 {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
    	
    	int count = 0;
    	for(int i = 0;i<arr.length-2;i++) {
    		for(int j = i+1;j<arr.length-1;j++) {
    			for(int k = j+1;k<arr.length;k++) {
    				if(Math.abs(arr[j]-arr[i]) <= a && Math.abs(arr[k]-arr[j]) <= b && Math.abs(arr[k]-arr[i]) <= c) {
    					count++;
    				}
    			}    			
    		}
    	}
    	return count;
    }
}