package ArrayProblem;

import java.util.HashMap;
import java.util.Map;

public class Solution1160 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"cat","bt","hat","tree"};
		String chars = "atach";
		ArraySolution1160 s = new ArraySolution1160();
		System.out.println(s.countCharacters(words, chars));
	}

}
class ArraySolution1160 {
    public int countCharacters(String[] words, String chars) {
    	Map<Character,Integer> map1 = new HashMap<>();
    	
    	for(int i = 0;i<chars.length();i++) {
    		map1.put(chars.charAt(i), map1.getOrDefault(chars.charAt(i), 0)+1);
    	}
    	
    	//记录学会的单词长度sumlen
    	int sumlen = 0;
    	for(int i = 0;i<words.length;i++) {
    		int tempwordlen = words[i].length();
    		String tempstring = words[i];
    		Map<Character,Integer> map2 = new HashMap<>();
    		for(int j = 0;j<tempwordlen;j++) {
    			map2.put(tempstring.charAt(j), map2.getOrDefault(tempstring.charAt(j), 0)+1);
    		}
    		boolean flag = true;
    		for(int j = 0;j<tempwordlen;j++) {
    			if(map1.getOrDefault(tempstring.charAt(j), 0)<map2.getOrDefault(tempstring.charAt(j), 0)) {
    				flag = false;
    				break;
    			}
    		}
    		if(flag) {
    			sumlen += tempwordlen;
    		}
    	}
    	return sumlen;
    }
}