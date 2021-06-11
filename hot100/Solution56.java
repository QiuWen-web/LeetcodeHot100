package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution56 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
		int len = intervals.length;
		System.out.println(len);
		if(len ==0) {
			int[][] res =  new int[0][2];
			System.out.println(res);
		}
		//对intervals按第一个数排序，重写方法
		Arrays.sort(intervals,new Comparator<int[]>(){
			public int compare(int[] interval1,int[] interval2) {
				return interval1[0]-interval2[0];
			}
		});
		//建立答案区间
		List<int[]> res = new ArrayList<int[]>();
		for(int i = 0;i<intervals.length;++i) {
			int L = intervals[i][0],R = intervals[i][1];
			if(res.size() == 0|| res.get(res.size()-1)[1] < L) {
				res.add(new int[] {L,R});
			}else {
				res.get(res.size()-1)[1] = Math.max(res.get(res.size()-1)[1], R);
			}
		}
		System.out.println(res.toArray(new int[res.size()][]));
	}

}
