package hot100;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Solution347 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,1,1,2,2,3};
		int k = 2;
		HotSolution347 hotSolution347 = new HotSolution347();
		int[] res = hotSolution347.topKFrequent(nums, k);
		for(int i : res) {
			System.out.print(i+" ");
		}
	}

}
class HotSolution347 {
    public int[] topKFrequent(int[] nums, int k) {
    	
    	int[] res = new int[k];
    	//����һ����ֵ�ԣ��ֱ��¼���ֵ����ּ�����
    	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    	for(int i = 0;i<nums.length;i++) {
    		if(!map.containsKey(nums[i])) {
    			//���û�����������������������map�У�Ȼ���ٸ�����ֵ��1
    			int value = 1;
    			map.put(nums[i], value);
    		}else {
    			//����������������ֵ+1
    			int value = map.get(nums[i]);
    			value++;
    			map.put(nums[i], value);
    		}
    	}
    	//�������ǵõ�map����ʾһ��
    	System.out.println(map);
    	//�õ�map��Ԫ�ظ���
    	
    	//����ҪѰ�ҵ�ֵ����һ��������ӵ�res��
    	for(int j = 0;j<k;j++) {
    		int max = 0;
    		for(Integer value:map.values()) {
    			if(value > max) {
    				max = value;
    			}
    		}
    		for(Integer key : map.keySet()) {
    			if(map.get(key) == max) {
    				res[j] = key;
    			}
    		}
    		map.remove(res[j]);
    	}
    	
    	
    	return res;
    }
}