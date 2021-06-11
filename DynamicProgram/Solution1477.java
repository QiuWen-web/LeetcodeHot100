package DynamicProgram;

public class Solution1477 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,1,1,2,2,2,4,4};
		int target = 6;
		DynamicSolution1477 s = new DynamicSolution1477();
		System.out.println(s.minSumOfLengths(arr, target));
	}

}
class DynamicSolution1477 {
	private int INF =100000005;
    public int minSumOfLengths(int[] arr, int target) {
    	int n = arr.length;
    	int cnt = 0;
    	int ans = INF;
    	int[] pre = new int[n+1];
    	for(int i =0;i<pre.length;i++) {
    		pre[i] = INF;
    	}
    	for(int l = 0,r = 1;r<=n;++r) {
    		cnt += arr[r-1];
    		while(cnt > target) {
    			cnt -= arr[l++];
    		}
    		if(cnt == target) {
    			pre[r] = Math.min(pre[r-1], r-l);
    			ans = Math.min(ans, pre[l] + r-l);
    		}else {
    			pre[r] = pre[r-1];
    		}
    	}
    	return ans == INF? -1:ans;
    }
}