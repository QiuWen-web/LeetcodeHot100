package ArrayProblem;

import java.util.ArrayList;
import java.util.List;

public class Solution228 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0};
		int s = 0;
		int e = 1;
		String s1 = s+"->"+e;
		System.out.println(s1);
		ArraySolution228 result = new ArraySolution228();
		List<String> res = result.summaryRanges(nums);
		System.out.println(res.toString());
	}

}
class ArraySolution228 {
    public List<String> summaryRanges(int[] nums) {
    	if(nums.length == 0) {
    		return new ArrayList<>();
    	}
    	if(nums.length == 1) {
    		List<String> list1 = new ArrayList<>();
    		list1.add(nums[0]+"");
    		return list1;
    			
    	}
    	List<String> list = new ArrayList<>();
    	int start = nums[0];
    	int end = nums[0];
    	for(int i = 1;i<nums.length;i++) {
    		if(nums[i] - end == 1) {
    			end = nums[i];
    		}else {
    			if(end - start != 0) {
    				list.add(start + "->" + end);
    			}else {
    				list.add(end +"");
    			}
    			end = nums[i];
    			start = nums[i];
    		}
    	}
    	if(end - start != 0) {
			list.add(start + "->" + end);
		}else {
			list.add(end +"");
		}
    	return list;
    }
}