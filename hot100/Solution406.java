package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution406 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		HotSolution406 hotSolution406 = new HotSolution406();
		hotSolution406.reconstructQueue(people);
	}

}
class HotSolution406 {
    public int[][] reconstructQueue(int[][] people) {
    	//���ȵõ�peopel����len���ٽ���һ������������ؽ��
    	int len = people.length;
    	int[][] res = new int[len][2];
    	
    	List<List<Integer>> array = new ArrayList<>();
    	//Ȼ��ʼ����people��������
    	for(int i =0;i<len;i++) {
    		
    		List<Integer> list = new ArrayList<Integer>();
    		
    		list.add(people[i][0]);
    		list.add(people[i][1]);
    		System.out.println("listΪ:"+list);
    		
    		if(list.get(1) == 0) {
    			if(array.size() != 0) {
    				int index = 0;
    				for(;index<array.size();index++) {
    					if(list.get(0)<array.get(index).get(0)) {
    						array.add(index,list);
    						break;
    					}
    				}
    				if(index == array.size()) {
    					array.add(list);
    				}
    				
    			}else {
    				array.add(0,list);
    			}
    		}else {
    			//���list[2]��ֵ��Ϊ0,��{4��1}
    			//�ȵõ�1���ֵ
    			int value = list.get(1);
    			int j = 0
    			//������ֵǰ����value������list.get(0)�����飬�����
    			for(; j<array.size();j++) {
    				if(array.get(j).get(0)>=list.get(0)) {
    					value--;
    				}
    				if(value == 0) {
    					//��ʱ���Բ��뵽��j+1��λ����
    					//����Ҫ�жϺ����Ǹ����Ƿ����
    					if(array.size() == array.get(j+1).get(1)) {
    						array.add(list);
    						break;
    					}else {
    						array.add(j+1,list);
    						break;
    					}
    				}
    			}
    			if(j == array.size()) {
    				array.add(list);
    			}
    		}
    	}
    	
    	System.out.println(array);
    	
    	return res;
    }
}