package hot100;

public class Solution70 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int s = climbStairs(n);
		//根据台阶数量，判断有多少个爬法
		System.out.println(s);
	}
	public static int count = 0;
	public static int climbStairs(int n) {
		if(n == 1) {

			return 1;
		}else if(n == 2) {

			return 2;
		}
		int a = 1, b = 2, temp;
		for(int i = 3; i <= n; i++){
	        temp = a;
	        a = b;
	        b = temp + b;
	    }
		
		return b;
		
		
	}
}
