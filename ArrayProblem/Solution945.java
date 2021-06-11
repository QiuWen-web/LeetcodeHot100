package ArrayProblem;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution945 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {3,2,1,2,1,7};
		ArraySolution945 s =new ArraySolution945();
		System.out.println(s.minIncrementForUnique(A));
	}

}
class ArraySolution945 {
    public int minIncrementForUnique(int[] A) {
    	int result = 0;
        Arrays.sort(A);
        for(int i = 1;i<A.length;i++) {
        	while(A[i-1] >= A[i]) {
        		int pre = A[i];
        		A[i] = A[i-1] + 1;
        		result += A[i] - pre;
        	}
        }
        return result;
    }
}