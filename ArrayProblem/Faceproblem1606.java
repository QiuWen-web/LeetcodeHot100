package ArrayProblem;

import java.util.Arrays;

public class Faceproblem1606 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,11,15};
		int[] b = {8,19,23,127,235};
		FaceSolution1606 s = new FaceSolution1606();
		System.out.println(s.smallestDifference(a, b));
	}

}
class FaceSolution1606 {
    public int smallestDifference(int[] a, int[] b) {
    	Arrays.sort(a);
    	Arrays.sort(b);
    	int prevalue = Integer.MAX_VALUE;
    	int mincha = Integer.MAX_VALUE;
    	for(int i = 0;i<a.length;i++) {
    		for(int j = 0;j<b.length;j++) {
    			int curvalue = Math.abs(a[i] - b[j]);
    			if(curvalue == Integer.MIN_VALUE) {
    				break;
    			}
    			if(prevalue < curvalue) {    				
    				break;
    			}else {
    				prevalue = curvalue;
    				if(mincha > prevalue) {
    					mincha = prevalue;
    				}
    			}
    		}
    		prevalue = Integer.MAX_VALUE;
    	}
    	return mincha;
    }
}