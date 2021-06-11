package hot100;

public class Solution096 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HotSolution096 res = new HotSolution096();
		int x = res.numTrees(5);
		System.out.println(x);
	}

}
class HotSolution096 {
    public int numTrees(int n) {
    	int res = 0;
    	if(n == 1 || n == 0) {
    		return 1;
    	}
    	if(n == 2) {
    		return 2;
    	}
    	for(int i = 1;i<=n;i++) {
    		res += numTrees(i-1) * numTrees(n-i);
    	}
    	return res;
    }
}