package DynamicProgram;

public class Solution1706 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{-1}};
		DynamicSolution1706 s = new DynamicSolution1706();
		int[] res = s.findBall(grid);
		for(int i : res) {
			System.out.print(i + ",");
		}
	}

}
class DynamicSolution1706 {
    public int[] findBall(int[][] grid) {
    	int[] answer = new int[grid[0].length];
    	for(int col = 0;col<answer.length;col++) {
    		answer[col] = answerfunction(col,grid);
    	}
    	return answer;
    }
    public int answerfunction(int col,int[][] grid) {
    	int i = 0;
    	int j = col;
    	while(i<grid.length) {
    		if(grid[i][j] == 1) {
    			j++;
    			//判断向右可以滑下去不
    			if(j<0 || j >= grid[0].length || grid[i][j] == -1) {
    				return -1;
    			}
    		}
    		if(grid[i][j] == -1) {
    			j--;
    			//判断向右可以滑下去不
    			if(j<0 || j >= grid[0].length || grid[i][j] == 1) {
    				return -1;
    			}
    		}
    		i++;
    	}
    	return j;
    }
}