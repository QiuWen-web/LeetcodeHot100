package ArrayProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution969 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,2,4,1};
		int k = 3;
		ArraySolution969 s = new ArraySolution969();
		List<Integer> res = s.pancakeSort(arr);
		System.out.println(res);
	}

}
class ArraySolution969 {
    public List<Integer> pancakeSort(int[] arr) {
    	//���Ƚ�����Ԫ�أ���λ�� i���±�� 1 ��ʼ��
    	//���м����ת i ���������ƶ������е���ǰ�棬
    	//Ȼ����ʹ�ü����ת A.length ���������ƶ���
    	//���е�����档
    	List<Integer> list = new ArrayList<>();
    	int len = arr.length;
    	int[] maxarr = Arrays.copyOf(arr,len);
    	Arrays.sort(maxarr);
    	//Ѱ�ҵ�j�����,һ��ҪѰ��len��
    	for(int i =0;i<arr.length;i++) {
    		   int j = i+1;
    		   int tempmax = getMaxi(maxarr,j);
    		   int maxindex = xunzhaoMaxnumber(arr,tempmax);
    		   //�����0~�������ת����ǰ��
    		   fanzhuan(arr,maxindex+1);
    		   list.add(maxindex+1);
    		   //���������ת������ĩβ
    		   fanzhuan(arr,len);
    		   list.add(len--);
    	}
    	
    	
    	return list;
    }
    public void fanzhuan(int[] arr,int k) {
    	int[] newarr = new int[k];
    	int inew = 0;
    	int iold = k-1;
    	while(inew<k) {
    		newarr[inew++] = arr[iold--];
    	}
    	for(int i = 0;i<k;i++) {
    		arr[i] = newarr[i];
    	}
    }
    public int xunzhaoMaxnumber(int[] arr,int s) {
    	//�ڲ��ϱ仯��arr��Ѱ��Ҫ�ҵ���s��λ��index;
    	for(int i = 0 ;i<arr.length;i++) {
    		if(arr[i] == s) {
    			return i;
    		}
    	}
    	return 0;
    }
    public int getMaxi(int[] maxarr,int j) {
    	//maxarr�Ѿ���������
    	return maxarr[maxarr.length-j];
    }
}