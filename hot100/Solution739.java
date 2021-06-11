package hot100;

import java.util.Arrays;

public class Solution739 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
		HotSolution739 hotSolution739 = new HotSolution739();
		int[] res = hotSolution739.dailyTemperatures(T);
		for(int i : res) {
			System.out.print(i+" ");
		}
	}

}
class HotSolution739 {
    public int[] dailyTemperatures(int[] T) {
    	int[] res = new int[T.length];
    	Arrays.fill(res,0);
    	for(int i = 0;i<T.length-1;i++) {
    		for(int j = i+1;j<T.length;j++) {
    			if(T[i]<T[j]) {
    				res[i] = j-i;
    				break;
    			}
    		}
    	}
    	return res;
    }
}