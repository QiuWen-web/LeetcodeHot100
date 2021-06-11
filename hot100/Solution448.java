package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution448 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,2};
		HotSolution448 hotSolution448 = new HotSolution448();
		System.out.println(hotSolution448.findDisappearedNumbers(nums));
		System.out.println(findDisappearedNumbers2(nums));
	}
	public static List<Integer> findDisappearedNumbers2(int[] nums){
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(nums);
		if(nums.length == 2) {
			list.add(1);
			list.add(2);
			list.remove((Integer)nums[0]);
			return list; 
		}
		int index = 0;
		for(int i = 1;i<nums.length;i++) {
			if(i == nums[index]) {
				index++;
			}else if (i == nums[index+1] &&index+1<nums.length) {
				index +=2;
			}else {
				list.add(i);
			}
		}
		return list;
	}

}
class HotSolution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
    	List<Integer> list = new ArrayList<Integer>();
    	//首先由于范围在1-n之间，所以先给list循环赋值n个数
    	for(int i =1;i<nums.length+1;i++) {
    		list.add(i);
    	}
    	//然后挨个查找，删除
    	for(int i= 0;i<nums.length;i++) {
    		//如果list中存在这个数，则删除
    		if(list.contains(nums[i])) {
    			list.remove((Integer)nums[i]);
    		}else {
    			continue;
    		}
    	}
    	return list;
    }
}