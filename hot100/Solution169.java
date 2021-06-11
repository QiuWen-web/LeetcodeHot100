package hot100;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution169 {
	public static void main(String[] args) {
		int[] nums = {3,2,3};
		int len = nums.length;
		int flag = len/2;
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i =0;i<len;i++) {
			if(map.containsKey(nums[i])) {
				int value = map.get(nums[i]);
				value++;
				map.put(nums[i], value);
			}else {
				map.put(nums[i],1);
			}
		}
		System.out.println(map);
		Set<Map.Entry<Integer,Integer>> entrySet = map.entrySet();
	    for(Map.Entry<Integer,Integer> me:entrySet){
	            int key = me.getKey();
	            int value = me.getValue();
	            if(value > flag) {
	            	System.out.println(key);
	            }
	    }
	}
}
