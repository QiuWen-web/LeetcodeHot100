package hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution438 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abab";
		String p = "ab";
		HotSolution438 hotSolution438 = new HotSolution438();
		List<Integer> res = hotSolution438.findAnagrams(s, p);
		System.out.println(res);
		
	}

}
class HotSolution438 {
    public List<Integer> findAnagrams(String s, String p) {
    	
    	List<Integer> res = new ArrayList<Integer>();
    	//特殊情况
    	if(s.length() == 0 ||s.length()<p.length()) {
    		return res;
    	}
    	if(s == p) {
    		res.add(0);
    		return res;
    	}
    	
    	//正常情况，s长度大于p，从s0向后寻找p.length长度看是否与p是异位词
    	List<Character> temp1 = new ArrayList<Character>();
    	for(int i = 0;i<s.length();i++) {
    		temp1.add(s.charAt(i));
    	}
    	System.out.println(temp1);
   	
    	//现在我们在建立一个循环，负责开始寻找s的索引
    	
    	for(int sindex = 0;sindex<s.length()-p.length()+1;sindex++) {
        	//首先我们把p添加到新的temp中（无线添加，无线删除）
        	List<Character> temp = new ArrayList<Character>();
        	for(int i = 0;i<p.length();i++) {
        		temp.add(p.charAt(i));
        	}
        	System.out.println(temp); 
    		
    		//从索引sindex开始向后看p.length+sindex个数，
    		int index = sindex;
    		while(index<(p.length()+sindex)) {
    		//如果这个字符在temp中则temp删点这个字符
    			if(temp.contains(temp1.get(index))) {
    				System.out.println(true);
    				temp.remove(temp1.get(index));
    				index += 1;
    			}else {
    				index += 1;
    			}
//    			}else {
//    	    		//如果这个字符不在temp中，1在未删除的temp1中有，2temp1中也没有
////    				if(temp1.contains(s.charAt(index))) {
////    					//那就继续遍历，不跳字母
////    					index++;
////    				}else {
////    					//下一次遍历直接从index+1索引处开始
////    				}
//    			}
    		}
    		//最后如果temp为空，说明是异位词，把i添加到res中
    		if(temp.isEmpty()) {
    			res.add(index-p.length());
    		}
    	}
    	
    	
    	return res;
    }
}