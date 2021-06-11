package ArrayProblem;

public class Solution849 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] seats = {0,1};
		ArraySolution849 s = new ArraySolution849();
		System.out.println(s.maxDistToClosest(seats));
	}

}
class ArraySolution849 {
    public int maxDistToClosest(int[] seats) {
    	int result = 0;
    	for(int i = 0;i<seats.length;i++) {
    		if(seats[i] == 0) {
    			int minSize = minDist(seats,i);
    			if(minSize>result) {
        			result = minSize;
        		}
    		}
    	}
    	return result;
    }
    public int minDist(int[] seats,int index) {
    	int Maxsize1 = Integer.MAX_VALUE;
    	int Maxsize2 = Integer.MAX_VALUE;
    	for(int i = index-1;i>=0;i--) {
    		if(seats[i] == 1) {
    			Maxsize1 = index - i;
    			break;
    		}
    	}
    	for(int j = index + 1;j<seats.length;j++) {
    		if(seats[j] == 1) {
    			Maxsize2 = j - index;
    			break;
    		}
    	}
    	int minDist = Math.min(Maxsize1,Maxsize2);
    	return minDist;
    }
}