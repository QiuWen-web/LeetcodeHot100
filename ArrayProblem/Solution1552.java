package ArrayProblem;

import java.util.Arrays;

public class Solution1552 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] position = {5,4,3,2,1,1000000000};
		int m = 2;
		ArraySolution1552 s = new ArraySolution1552();
		int dis = s.maxDistance(position, m);
		System.out.println(dis);
	}

}
class ArraySolution1552 {
    public int maxDistance(int[] position, int m) {
    	Arrays.sort(position);
    	int l = 0;
    	int r = position[position.length-1];
    	int ans = 1;
    	while(l<=r) {
    		int mid = (r+l)/2;
    		if(check(position,m,mid)) {
    			ans = mid;
    			l = mid+1;
    		}else {
    			r = mid-1;
    		}
    	}
    	return ans;
    }
    public boolean check(int[] position,int m,int mid) {
    	int last = 0;
    	for(int i = 1;i<position.length;i++) {
    		if(position[i] - position[last] >= mid) {
    			last = i;
    			m--;
    		}
    		if(m == 1) {
    			return true;
    		}
    	}
    	return false;    			
    }
}