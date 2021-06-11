package ArrayProblem;

import java.util.ArrayList;

/*
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出并返回这两个正序数组的 中位数 。
 * */
public class Solution004 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,3};
		int[] nums2 = {2,7};
		ArraySolution004 s = new ArraySolution004();
		double result = s.findMedianSortedArrays001(nums1, nums2);
		System.out.println(result);
	}

}
class ArraySolution004 {
	//新建数组寻找法
    public double findMedianSortedArrays001(int[] nums1, int[] nums2) {
    	int m = nums1.length;
    	int n = nums2.length;
    	
    	//先合并数组
    	ArrayList<Integer> numsall = new ArrayList<Integer>();
    	
    	int i = 0,j=0;
    	while(i<m&&j<n) {
    		if(nums1[i] >= nums2[j]) {
    			numsall.add(nums2[j]);
    			j++;
    		}else {
    			numsall.add(nums1[i]);
    			i++;
    		}
    	}
    	if(i == m && j < n) {
    		while(j<n) {
    			numsall.add(nums2[j]);
    			j++;
    		}
    	}
    	if(j == n && i < m) {
    		while(i < m) {
    			numsall.add(nums1[i]);
    			i++;
    		}
    	}
    	//此时numsall已经成型了
    	//寻找中位数
    	int indexall = m + n;
    	//如果数组为奇数个
    	if(indexall % 2 == 1) {
    		return (double)numsall.get(indexall/2);
    	}else {
    		return (double)(numsall.get(indexall/2)+numsall.get(indexall/2 - 1))/2;
    	}
    	
    }
    //双指针定位法
    
}