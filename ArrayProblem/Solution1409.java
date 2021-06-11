package ArrayProblem;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution1409 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		
		System.out.println(list.toString());
		list.remove(0);
		System.out.println(list.toString());
		list.add(1, 0);
		System.out.println(list.toString());
		int[] queries = {7,5,5,8,3};
		int m = 8;
		ArraySolution1409 s = new ArraySolution1409();
		int[] res = s.processQueries(queries, m);
		System.out.println(Arrays.toString(res));
	}

}
class ArraySolution1409 {
    public int[] processQueries(int[] queries, int m) {
    	int len = queries.length;
    	int[] res = new int[len];
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	for(int i = 1;i<=m;i++) {
    		list.add(i);
    	}
    	for(int i = 0;i<queries.length;i++) {
    		//±éÀúqueries
    		for(int j = 0;j<list.size();j++) {
    			if(queries[i] == list.get(j)) {
    				res[i] = j;
    				list.remove(j);
    				list.add(0, queries[i]);
    			}
    		}
    	}
    	return res;
    }
}