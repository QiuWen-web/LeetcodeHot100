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
    	//�����õ�����������
    	int rows = board.length;
    	int columns = board[0].length;
    	System.out.println("����Ϊ��"+rows+"����Ϊ:"+columns);
    	
    	//���ҵ�һ���ַ���ʼ�ĵ�ַ
    	List<Integer> list = new ArrayList<Integer>();
    	char s1 = word.charAt(0);
    	int k = 1;
    	for(int i = 0;i<rows;i++) {
    		for(int j = 0;j<columns;j++) {
    			if(board[i][j] == s1) {
    				//��i��j��¼����
    				list.add(i);
    				list.add(j);
    			}
    		}
    	}
    	//���list�ĳ���Ϊ0�������һ���ַ���board�оͲ鲻��������false
    	if(list.size() == 0) {
    		return false;
    	}
    	//Ȼ������ȡ��i,j���бȽ�
    	for(int i=0,j=1;j<list.size();i+=2,j+=2) {
    		//�ó��ڶ����ַ����ж��Ƿ����
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
    //����board��������[i][j]������һ��ҪѰ�ҵ��ַ�s���������������Ƿ��ҵ����ϵ�
    
    public int[] lookAround(char[][] board,int i,int j,char s) {
    	int[] nums = {-1,-1};
    	int rows = board.length;//����
    	int columns = board[0].length;//����
    	
    	//����Ѱ��,������һ�����������0-rows֮�䣬���������==s
    	if(i-1>=0 && i-1<rows && board[i-1][j] == s) {
    		nums[0] = i-1;
    		nums[1] = j;
			return nums;
		}
		//����Ѱ��
		if(i+1 >=0 && i+1<rows && board[i+1][j] == s) {
			nums[0] = i+1;
    		nums[1] = j;
			return nums;
		}
		//����Ѱ��
		if(j-1>=0 && j-1<columns && board[i][j-1] == s) {
			nums[0] = i;
    		nums[1] = j-1;
			return nums;
		}
		//����Ѱ��
		if(j+1>=0 && j+1<columns && board[i][j+1] == s) {
			nums[0] = i;
    		nums[1] = j+1;
			return nums;
		}
		return nums;
    } 
}