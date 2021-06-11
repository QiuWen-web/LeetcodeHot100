package ArrayProblem;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution88 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1};
		int[] nums2 = {};
		int m = 1;
		int n = 0;
		ArraySolution088 s = new ArraySolution088();
		s.merge(nums1, m, nums2, n);
		System.out.println(Arrays.toString(nums1));
	}

}
class ArraySolution088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	for(int i = 0;i<m;i++) {
    		list.add(nums1[i]);
    	}
    	for(int i =0;i<n;i++) {
    		list.add(nums2[i]);
    	}
    	list.sort(null);
    	for(int i = 0;i<m+n;i++) {
    		nums1[i] = list.get(i);
    	}
    }
}