package ArrayProblem;

import java.util.ArrayList;
import java.util.List;

public class Solution120 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		List<Integer> list3 = new ArrayList<Integer>();
		List<Integer> list4 = new ArrayList<Integer>();
		List<List<Integer>> triangle = new ArrayList<>();
		list1.add(-1);
		list2.add(2);list2.add(3);
		list3.add(1);list3.add(-1);list3.add(-3);
//		list4.add(4);list4.add(1);list4.add(8);list4.add(3);
		triangle.add(list1);
		triangle.add(list2);
		triangle.add(list3);
//		triangle.add(list4);
		
		ArraySolution120 s= new ArraySolution120();
		System.out.println(s.minimumTotal(triangle));
	}

}
class ArraySolution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
    	int height = triangle.size();
    	int[][] f = new int[height][height];
    	f[0][0] = triangle.get(0).get(0);
    	for(int i = 1;i<height;i++) {
    		f[i][0] = f[i-1][0] + triangle.get(i).get(0);
    		for(int j = 1;j<i;j++) {
    			f[i][j] = Math.min(f[i-1][j], f[i-1][j-1]) + triangle.get(i).get(j); 
    		}
    		f[i][i] = f[i-1][i-1] + triangle.get(i).get(i);
    	}
    	int min = f[height-1][0];
    	for(int i = 1 ;i<height;i++) {
    		if(min>f[height-1][i]) {
    			min = f[height-1][i];
    		}
    	}
    	return min;
    }
}