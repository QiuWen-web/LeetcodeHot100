package DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//请你设计一个数据结构，支持
//添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 
public class Solution211 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class WordDictionary {
	Set<String> list;
    /** Initialize your data structure here. */
    public WordDictionary() {
    	list = new HashSet<>();
    }
    
    public void addWord(String word) {
    	list.add(word);
    	
    }
    
    public boolean search(String word) {
    	//首先定义状态没有找到
    	boolean flag = false;
    	for(String temp:list) {
    		//挨个寻找
    		
    		int lenS = word.length();
    		int lenT = temp.length();
    		
    		if(lenS == lenT) {
    			//符合第一个长度条件
    			flag = flag || helper(word,temp);
    			if(flag){
                    break;
                }
    		}
    		
    	}
    	return flag;
    }
    public boolean helper(String word,String temp) {
    	boolean flag = true;
		for(int j = 0;j<word.length();j++) {
			//继续对比
			if(word.charAt(j) == '.') {
				continue;
			}else {
				if(word.charAt(j) != temp.charAt(j)) {
					//如果有一个不等于
					flag = false;
					break;
				}
			}
		}
		return flag;
    }
}