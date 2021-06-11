package DynamicProgram;

import java.util.Arrays;

public class SolutionOffer14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OfferSolution14 s = new OfferSolution14();
		System.out.println(s.cuttingRope(120));
	}

}
class OfferSolution14 {
    public int cuttingRope(int n) {
        if(n < 4){
            return n - 1;
        }
        long res = 1;
        while(n > 4){
            res  = res * 3 % 1000000007;
            n -= 3;
        }
        return (int) (res * n % 1000000007);
    }
}
