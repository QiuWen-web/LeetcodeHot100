package DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//�������һ�����ݽṹ��֧��
//����µ��� �� �����ַ����Ƿ����κ���ǰ��ӵ��ַ���ƥ�� 
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
    	//���ȶ���״̬û���ҵ�
    	boolean flag = false;
    	for(String temp:list) {
    		//����Ѱ��
    		
    		int lenS = word.length();
    		int lenT = temp.length();
    		
    		if(lenS == lenT) {
    			//���ϵ�һ����������
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
			//�����Ա�
			if(word.charAt(j) == '.') {
				continue;
			}else {
				if(word.charAt(j) != temp.charAt(j)) {
					//�����һ��������
					flag = false;
					break;
				}
			}
		}
		return flag;
    }
}