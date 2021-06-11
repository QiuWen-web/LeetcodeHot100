package DynamicProgram;

import java.util.ArrayList;
import java.util.List;

public class Solution1048 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
		DynamicSolution1048 s = new DynamicSolution1048();
		System.out.println(s.longestStrChain(words));
	}

}
class DynamicSolution1048 {
    
	public int longestStrChain(String[] words) {
    	int n = words.length;
    	String[] wordsort = new String[n];
    	//建立dp数组
    	int[][] dp = new int[n][2];
    	
    	int index = 0;
    	for(int len = 1;len<17;len++) {
    		for(int i = 0;i<n;i++) {
    			if(words[i].length() == len) {
    				wordsort[index] = words[i];
    				dp[index][1] = len;
    				index++;
    			}
    		}
    	}
    	//排序完成后得到新的wordsort单词列表
    	//建立dp数组
    	
    	for(int i =0;i<n;i++) {
    		if(i==0) {
    			dp[i][0] = 1;
    		}else {
    			update(dp,wordsort,i);
    		}  		
    	}
    	int max= 0;
    	for(int i = 0;i<n;i++) {
    		if(dp[i][0]>max) {
    			max = dp[i][0];
    		}
    	}
    	return max;
     }
    public void update(int[][] dp,String[] wordsort,int n) {
    	int pre = wordsort[n].length()-1;
    	for(int i = 0;i<n;i++) {
    		if(dp[i][1] ==pre) {
//    			//任意插入，不是包含的意思
//    			if(wordsort[n].contains(wordsort[i])) {
//    				dp[n][0] = Math.max(dp[n][0], dp[i][0]+1);
//    			}
    			//即wordsort[i]中的字母wordsort[n]都有
    			char[] c1 = wordsort[n].toCharArray();
    			char[] c2 = wordsort[i].toCharArray();
    			List<Integer> list = new ArrayList<>();
    			for(int j = 0;j<c2.length;j++) {
    				for(int k = 0;k<c1.length;k++) {
    					if(c2[j] == c1[k]) {
    						if(list.size() == 0) {
    							list.add(k);
    							break;
    						}else {
    							if(!list.contains(k) && k>list.get(list.size()-1)) {
    								list.add(k);break;
    							}
    							
    						}
    					}
    				}
    			}
    			if(list.size() == pre) {
    				dp[n][0] = Math.max(dp[n][0], dp[i][0]+1);
    			}
    			list.clear();
    		}
    	}
    	if(dp[n][0] == 0) {
    		dp[n][0] = 1;
    	}
    }
}