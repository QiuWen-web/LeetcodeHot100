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
    	//�������
    	if(s.length() == 0 ||s.length()<p.length()) {
    		return res;
    	}
    	if(s == p) {
    		res.add(0);
    		return res;
    	}
    	
    	//���������s���ȴ���p����s0���Ѱ��p.length���ȿ��Ƿ���p����λ��
    	List<Character> temp1 = new ArrayList<Character>();
    	for(int i = 0;i<s.length();i++) {
    		temp1.add(s.charAt(i));
    	}
    	System.out.println(temp1);
   	
    	//���������ڽ���һ��ѭ��������ʼѰ��s������
    	
    	for(int sindex = 0;sindex<s.length()-p.length()+1;sindex++) {
        	//�������ǰ�p��ӵ��µ�temp�У�������ӣ�����ɾ����
        	List<Character> temp = new ArrayList<Character>();
        	for(int i = 0;i<p.length();i++) {
        		temp.add(p.charAt(i));
        	}
        	System.out.println(temp); 
    		
    		//������sindex��ʼ���p.length+sindex������
    		int index = sindex;
    		while(index<(p.length()+sindex)) {
    		//�������ַ���temp����tempɾ������ַ�
    			if(temp.contains(temp1.get(index))) {
    				System.out.println(true);
    				temp.remove(temp1.get(index));
    				index += 1;
    			}else {
    				index += 1;
    			}
//    			}else {
//    	    		//�������ַ�����temp�У�1��δɾ����temp1���У�2temp1��Ҳû��
////    				if(temp1.contains(s.charAt(index))) {
////    					//�Ǿͼ���������������ĸ
////    					index++;
////    				}else {
////    					//��һ�α���ֱ�Ӵ�index+1��������ʼ
////    				}
//    			}
    		}
    		//������tempΪ�գ�˵������λ�ʣ���i��ӵ�res��
    		if(temp.isEmpty()) {
    			res.add(index-p.length());
    		}
    	}
    	
    	
    	return res;
    }
}