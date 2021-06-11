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
    	//首先将最大的元素（在位置 i，下标从 1 开始）
    	//进行煎饼翻转 i 操作将它移动到序列的最前面，
    	//然后再使用煎饼翻转 A.length 操作将它移动到
    	//序列的最后面。
    	List<Integer> list = new ArrayList<>();
    	int len = arr.length;
    	int[] maxarr = Arrays.copyOf(arr,len);
    	Arrays.sort(maxarr);
    	//寻找第j大的数,一共要寻找len次
    	for(int i =0;i<arr.length;i++) {
    		   int j = i+1;
    		   int tempmax = getMaxi(maxarr,j);
    		   int maxindex = xunzhaoMaxnumber(arr,tempmax);
    		   //将这个0~最大数翻转到最前面
    		   fanzhuan(arr,maxindex+1);
    		   list.add(maxindex+1);
    		   //将这个数翻转到数组末尾
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
    	//在不断变化的arr中寻找要找的数s的位置index;
    	for(int i = 0 ;i<arr.length;i++) {
    		if(arr[i] == s) {
    			return i;
    		}
    	}
    	return 0;
    }
    public int getMaxi(int[] maxarr,int j) {
    	//maxarr已经排完序了
    	return maxarr[maxarr.length-j];
    }
}