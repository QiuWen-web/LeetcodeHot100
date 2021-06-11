package DynamicProgram;

public class Solution1105 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] books = {{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}};
		int shelf_width = 4;
		DynamicSolution1105 s = new DynamicSolution1105();
		System.out.println(s.minHeightShelves(books, shelf_width));
	}

}
class DynamicSolution1105 {
    public int minHeightShelves(int[][] books, int shelf_width) {
    	int[] dp = new int[books.length+1];
    	for(int i =1;i<dp.length;i++) {
    		dp[i] = 1000000;
    	}
    	for(int i = 1;i<dp.length;i++) {
    		int temp_width = 0;
    		int j = i;
    		int h = 0;
    		while(j>0) {
    			temp_width += books[j-1][0];
    			if(temp_width > shelf_width) {
    				break;
    			}
    			h = Math.max(h, books[j-1][1]);
    			dp[i] = Math.min(dp[i],dp[j-1]+h);
    			j -= 1;
    		}
    	}
    	return dp[books.length];
    }
}