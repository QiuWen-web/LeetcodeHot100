package ArrayProblem;

public class Solution509 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArraySolution509 s = new ArraySolution509();
		System.out.println(s.fib(4));
	}

}
class ArraySolution509 {
    public int fib(int n) {
    	if(n == 0) {
    		return 0;
    	}
    	if(n == 1) {
    		return 1;
    	}
    	return fib(n-1) + fib(n-2);
    }
}