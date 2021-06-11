package ArrayProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Solution442 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4,3,2,7,8,2,3,1};
		ArraySolution442 s = new ArraySolution442();
		List<Integer> res = s.findDuplicates(nums);
		System.out.println(res.toString());
	}

}
class ArraySolution442 {
    public List<Integer> findDuplicates(int[] nums) {
    	List<Integer> res = new ArrayList<>();
    	Map<Integer,Integer> map = new HashMap<>();
    	for(int i = 0;i<nums.length;i++) {
    		if(!map.containsKey(nums[i])) {
    			map.put(nums[i], 1);
    		}else {
    			map.put(nums[i], map.get(nums[i]) + 1);
    		}
    	}
    	//遍历所有键的值，如果==2，则加入res中
    	for(Map.Entry<Integer, Integer> e:map.entrySet()) {
    		int key = e.getKey();
    		int value = e.getValue();
    		if(value == 2) {
    			res.add(key);
    		}
    	}
    	return res;
    }
}