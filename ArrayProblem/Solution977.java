package ArrayProblem;

import java.util.ArrayList;

public class Solution977 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-7,-3,2,3,11};
		ArraySolution977 s = new ArraySolution977();
		int[] res = s.sortedSquares(nums);
		for(int i : res) {
			System.out.print(i+",");
		}
	}

}
class ArraySolution977 {
    public int[] sortedSquares(int[] nums) {
    	int len = nums.length;
    	ArrayList<Integer> numssquares = new ArrayList<Integer>();
    	for(int i = 0 ; i < len ; i++) {
    		numssquares.add(nums[i] * nums[i]);
    	}
    	numssquares.sort(null);
    	int[] squares = new int[len];
    	for(int i = 0 ;i<len;i++) {
    		squares[i] = numssquares.get(i);
    	}
    	return squares;
    }
}