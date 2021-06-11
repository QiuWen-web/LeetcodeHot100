package ArrayProblem;

import java.util.Arrays;

public class Solution1053 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,9,4,6,7};
		ArraySolution1053 s = new ArraySolution1053();
		int[] res = s.prevPermOpt1(arr);
		System.out.println(Arrays.toString(res));
	}

}
class ArraySolution1053 {
    public int[] prevPermOpt1(int[] arr) {
    	int len = arr.length;
    	boolean flag = false;
    	for(int i = len-2;i>=0;i--) {
    		//寻找第一个降序位置
    		if(arr[i] > arr [i+1]) {
    			flag = true;
    			//从i+1位置到len-1寻找小于arr[i]的最大数
    			int curmax = arr[i+1];
    			int index = i+1;
    			for(int j = i+1;j<len;j++) {
    				if(arr[j]<arr[i] && arr[j]>curmax) {
    					index = j;
    					curmax = arr[j];
    				}
    			}
    			//结束寻找
    			arr[index] = arr[i];
    			arr[i] = curmax;
    			return arr;
    		}     		
    	}
    	return arr;
    }
}