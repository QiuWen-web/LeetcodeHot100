package ArrayProblem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution1331 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {37,12,28,9,100,56,80,5,12};
		ArraySolution1334 s = new ArraySolution1334();
		int[] res = s.arrayRankTransform(arr);
		System.out.println(Arrays.toString(res));
	}

}
class ArraySolution1334 {
    public int[] arrayRankTransform(int[] arr) {
    	//去重方法建立set
    	Set<Integer> set = new HashSet<>();
    	int[] res = new int[arr.length];
    	
    	for(int i = 0;i<arr.length;i++) {
    		set.add(arr[i]);
    	}
    	int[] copyarr = new int[set.size()];
    	int k = 0;
    	for(Integer i : set) {
    		copyarr[k++] = i;
    	}
    	//去重完毕
    	Arrays.sort(copyarr);
    	//排序完毕
        Map<Integer,Integer> map=new HashMap<>();
        int index=1;
        for(int i=0;i<copyarr.length;i++) {

        	map.put(copyarr[i], index);
        	index++;

        }
        for(int i=0;i<arr.length;i++) {
        	res[i]=map.get(arr[i]);
        }
    	return res;
    }
}