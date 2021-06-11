package ArrayProblem;

import java.util.Arrays;

public class Solution832 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] image = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
		ArraySolution832 s = new ArraySolution832();
		int[][] res = s.flipAndInvertImage(image);
		for(int[] k : res) {
			System.out.println(Arrays.toString(k));
		}
	}

}
class ArraySolution832 {
    public int[][] flipAndInvertImage(int[][] image) {
    	int rows = image.length;
    	int cols = image[0].length;
    	int[][] newimage = new int[rows][cols];
    	for(int i = 0;i<rows;i++) {
    		for(int j = 0;j<cols;j++) {
    			image[i][j] = 1 - image[i][j];
    			newimage[i][cols-j-1] = image[i][j];
    		}
    	}
    	
    	return newimage;
    }
}