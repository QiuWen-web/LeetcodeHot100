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
    	//������Ƿ�����������������֮�ࣿ
    	//���������numsֻ��һ����
    	if(nums.length == 1) {
    		return 0;
    	}
    	//�Ҿ���ֻҪ�Ÿ���ֻҪ���һλ�������ڶ�λ�������ͳ���
    	int[] copynums = Arrays.copyOf(nums, nums.length);
    	Arrays.sort(copynums);
    	int last1 = copynums[copynums.length-1];
    	int last2 = copynums[copynums.length-2];
    	if(last1 >= last2 * 2) {
    		//˵�����ϣ�����last1��nums�е�����
    		for(int i=0;i<nums.length;i++) {
    			if(nums[i] == last1) {
    				return i;
    			}
    		}
    		return 0;
       	}else {
       		//������
       		return -1;
       	}
    	
    }
}