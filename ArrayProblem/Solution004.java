package ArrayProblem;

import java.util.ArrayList;

/*
 * ����������С�ֱ�Ϊ m �� n �����򣨴�С�������� nums1 �� nums2��
 * �����ҳ���������������������� ��λ�� ��
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
	//�½�����Ѱ�ҷ�
    public double findMedianSortedArrays001(int[] nums1, int[] nums2) {
    	int m = nums1.length;
    	int n = nums2.length;
    	
    	//�Ⱥϲ�����
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
    	//��ʱnumsall�Ѿ�������
    	//Ѱ����λ��
    	int indexall = m + n;
    	//�������Ϊ������
    	if(indexall % 2 == 1) {
    		return (double)numsall.get(indexall/2);
    	}else {
    		return (double)(numsall.get(indexall/2)+numsall.get(indexall/2 - 1))/2;
    	}
    	
    }
    //˫ָ�붨λ��
    
}