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
    	//创建一个键值对，分别记录出现的数字及个数
    	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    	for(int i = 0;i<nums.length;i++) {
    		if(!map.containsKey(nums[i])) {
    			//如果没有这个键，首先添加这个键到map中，然后再给他的值赋1
    			int value = 1;
    			map.put(nums[i], value);
    		}else {
    			//如果有这个键，给他值+1
    			int value = map.get(nums[i]);
    			value++;
    			map.put(nums[i], value);
    		}
    	}
    	//现在我们得到map，显示一下
    	System.out.println(map);
    	//得到map的元素个数
    	
    	//我们要寻找到值最大的一个数，添加到res中
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