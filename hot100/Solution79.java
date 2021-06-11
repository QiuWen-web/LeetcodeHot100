package hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution79 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "ABCCED";
		HotSolution79 hotSolution79 = new HotSolution79();
		Boolean flag = hotSolution79.exist(board, word);
		System.out.println(flag);
	}

}
class HotSolution79 {
    public boolean exist(char[][] board, String word) {
    	//首先拿到行数和列数
    	int rows = board.length;
    	int columns = board[0].length;
    	System.out.println("行数为："+rows+"列数为:"+columns);
    	
    	//查找第一个字符开始的地址
    	List<Integer> list = new ArrayList<Integer>();
    	char s1 = word.charAt(0);
    	int k = 1;
    	for(int i = 0;i<rows;i++) {
    		for(int j = 0;j<columns;j++) {
    			if(board[i][j] == s1) {
    				//把i，j记录下来
    				list.add(i);
    				list.add(j);
    			}
    		}
    	}
    	//如果list的长度为0，代表第一个字符在board中就查不到，返回false
    	if(list.size() == 0) {
    		return false;
    	}
    	//然后依次取出i,j进行比较
    	for(int i=0,j=1;j<list.size();i+=2,j+=2) {
    		//拿出第二个字符，判断是否存在
    		int[] nums = {list.get(i),list.get(j)};
    		
    		while(true) {
    			nums = lookAround(board,nums[0],nums[1],word.charAt(k));
    			k++;
    			if(nums[0] == -1) {
    				return false;
    			}
    		}
    	}
    	return false;
    }
    //给出board，和坐标[i][j]，和下一个要寻找的字符s，返回上下左右是否找到符合的
    
    public int[] lookAround(char[][] board,int i,int j,char s) {
    	int[] nums = {-1,-1};
    	int rows = board.length;//行数
    	int columns = board[0].length;//列数
    	
    	//向上寻找,行数减一，如果行数在0-rows之间，并且这个数==s
    	if(i-1>=0 && i-1<rows && board[i-1][j] == s) {
    		nums[0] = i-1;
    		nums[1] = j;
			return nums;
		}
		//向下寻找
		if(i+1 >=0 && i+1<rows && board[i+1][j] == s) {
			nums[0] = i+1;
    		nums[1] = j;
			return nums;
		}
		//向左寻找
		if(j-1>=0 && j-1<columns && board[i][j-1] == s) {
			nums[0] = i;
    		nums[1] = j-1;
			return nums;
		}
		//向右寻找
		if(j+1>=0 && j+1<columns && board[i][j+1] == s) {
			nums[0] = i;
    		nums[1] = j+1;
			return nums;
		}
		return nums;
    } 
}