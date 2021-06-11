package hot100;

public class Solution279 {
	public static void main(String[] args) {
		int n = 12;
		System.out.println(numSquares(n));
		
	}
	private static int numSquares(int n) {
		if(n == 0) {
			return 0;
		}
		for(int i = 1; i*i<=n;i++) {
			if(n-i*i > 0) {
				numSquares(n-i*i);
			}else {
				break;
			}
		}
	}
}
