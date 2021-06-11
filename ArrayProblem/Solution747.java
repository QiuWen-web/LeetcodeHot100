package ArrayProblem;

import java.util.Arrays;

public class Solution747 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1};
		ArraySolution747 s = new ArraySolution747();
		System.out.println(s.dominantIndex(nums));
	}

}
class ArraySolution747 {
    public int dominantIndex(int[] nums) {
    	//最大数是否是其他个数的两倍之多？
    	//特殊情况，nums只有一个数
    	if(nums.length == 1) {
    		return 0;
    	}
    	//我觉得只要排个序，只要最后一位大于最后第二位的两倍就成立
    	int[] copynums = Arrays.copyOf(nums, nums.length);
    	Arrays.sort(copynums);
    	int last1 = copynums[copynums.length-1];
    	int last2 = copynums[copynums.length-2];
    	if(last1 >= last2 * 2) {
    		//说明符合，返回last1在nums中的索引
    		for(int i=0;i<nums.length;i++) {
    			if(nums[i] == last1) {
    				return i;
    			}
    		}
    		return 0;
       	}else {
       		//不符合
       		return -1;
       	}
    	
    }
}