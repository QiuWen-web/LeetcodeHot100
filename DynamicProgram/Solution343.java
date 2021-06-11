package DynamicProgram;

public class Solution343 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DynamicSolution343 s = new DynamicSolution343();
		System.out.println(s.integerBreak(11));
	}

}
class DynamicSolution343 {
    public int integerBreak(int n) {
    	if(n==2) {
    		return 1;
    	}
    	if(n==3) {
    		return 2;
    	}
    	if(n==4) {
    		return 4;
    	}
    	if(n==5) {
    		return 6;
    	}
    	
    	int res = 1;
    	while(n>5) {
			res = res * 3;
			n = n-3;
		}
		
		if(n==5) {
			res = res * 3 * 2;
		}else if(n == 4) {
			res = res * 4;
		}else if(n == 3) {
			res = res*3;
		}
    	return res;
    }
}