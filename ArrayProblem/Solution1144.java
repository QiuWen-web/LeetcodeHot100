package ArrayProblem;

import java.util.Arrays;

public class Solution1144 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3};
		ArraySolution1144 s = new ArraySolution1144();
		System.out.println(s.movesToMakeZigzag(nums));
	}

}
class ArraySolution1144 {
	public int movesToMakeZigzag(int[] nums) {
		int[] nums1 = Arrays.copyOf(nums, nums.length);
		int[] nums2 = Arrays.copyOf(nums, nums.length);
		int min1 = movesToMakeZigzagou(nums1);
		int min2 = movesToMakeZigzagji(nums2);
		int min = Math.min(min1, min2);
		return min;
    }
    public int movesToMakeZigzagou(int[] nums) {
    	//ż��������ֵ��������������ֵ����Ҫ����С����
    	int sum = 0;
    	//�޶�ż������
    	for(int i = 0;i<nums.length;i += 2) {
    		if(i == 0) {
    			//���ż������Ϊ��һ��������ֻ��Ҫ�Ƚ��ұ�
    			if(nums[0]<=nums[1]) {
    				sum += nums[1] - nums[0] +1;
    				nums[1] = nums[0]-1;
    			}
    		}
    		if(i==nums.length-1) {
    			//���ż������Ϊ���һ��������ֻ��Ҫ�Ƚ����
    			if(nums[i]<=nums[i-1]) {
    				sum += nums[i-1] - nums[i] +1;
    				nums[i-1] = nums[i]-1;
    			}
    			
    		}
    		if(i>0 && i<nums.length-1) {
    			//���ż������������ͷ������Ҫ�Ƚ�����������
    			if(nums[i]<=nums[i-1]) {
    				sum += nums[i-1] - nums[i] + 1;
    				nums[i-1] = nums[i]-1;
    			}
    			if(nums[i]<=nums[i+1]) {
    				sum += nums[i+1] - nums[i] + 1;
    				nums[i+1] = nums[i] - 1;
    			}
    		}
    	}
    	System.out.println(Arrays.toString(nums));
    	return sum;
    }
    public int movesToMakeZigzagji(int[] nums) {
    	//����������ֵ����ż��������ֵ����Ҫ����С����
    	int sum = 0;
    	//�޶���������
    	for(int i = 1;i<nums.length;i += 2) {
    		
    		if(i==nums.length-1) {
    			//�����������Ϊ���һ��������ֻ��Ҫ�Ƚ����
    			if(nums[i]<=nums[i-1]) {
    				sum += nums[i-1] - nums[i] +1;
    				nums[i-1] = nums[i]-1;
    			}
    			
    		}
    		if(i>0 && i<nums.length-1) {
    			//���ż������������ͷ������Ҫ�Ƚ�����������
    			if(nums[i]<=nums[i-1]) {
    				sum += nums[i-1] - nums[i] + 1;
    				nums[i-1] = nums[i]-1;
    			}
    			if(nums[i]<=nums[i+1]) {
    				sum += nums[i+1] - nums[i] + 1;
    				nums[i+1] = nums[i] - 1;
    			}
    		}
    	}
    	System.out.println(Arrays.toString(nums));
    	return sum;
    }
}