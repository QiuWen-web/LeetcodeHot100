package ArrayProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Faceproblem1710 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,5,9,5,9,5,5,5};
		ArraySolution1710 result = new ArraySolution1710();
		int res = result.majorityElement(nums);
		System.out.println(res);
	}

}
class ArraySolution1710 {
    public int majorityElement(int[] nums) {
    	//中位数
    	ArrayList<Integer> s = new ArrayList<>();
    	for(int i : nums) {
    		s.add(i);
    	}
    	s.sort(null);
    	int res = s.get(nums.length/2);
    	//验证中位数为主要元素
    	int number = 0;
    	for(int i : nums) {
    		if(res == i) {
    			number++;
    		}
    	}
    	if(number > nums.length/2) {
    		return res;
    	}else {
    		return -1;
    	}
    }  
    public int majorityElement002(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            if (hashMap.containsKey(num)){
                hashMap.put(num, hashMap.get(num)+1);
            } else {
                hashMap.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> integerEntry : hashMap.entrySet()) {
            if (integerEntry.getValue() > nums.length/2){
                return integerEntry.getKey();
            }
        }
        return -1;
    }
}