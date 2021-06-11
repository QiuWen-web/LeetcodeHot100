package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution851 {

	public static void main(String[] args) {
		int[][] richer = {{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}};
		int[] quiet = {3,2,5,4,6,1,7,0};
		dfsSolution851 s = new dfsSolution851();
		int[] res = s.loudAndRich(richer, quiet);
		for(int i: res) {
			System.out.print(i+",");
		}
}
class dfsSolution851{
	//建立一个map数组记录大于等于键的id
	Map<Integer,List<Integer>> map = new HashMap<>();
	//n表示人数
	int n;
    public int[] loudAndRich(int[][] richer, int[] quiet) {
    	n = richer.length;
    	for(int i = 0;i<n;i++) {
    		map.put(i, new ArrayList<>(i));
    		dfs(richer,i);
    	}
    	//键值对设定完毕
    	int[] res = new int[n];
    	//每次拿出一个值，寻找最小的安静数
    	for(int i = 0;i<n;i++) {
    		List<Integer> list = map.get(i);
    		int min = lookformin(list,quiet);
    		res[i] = min;
    	}
    	return res;
    }
    public void dfs(int[][] richer,int index) {
    	for(int i = 0;i<n;i++) {
    		int[] item = richer[i];
    		//如果拿到的这个数组item[2]在这个map[index]的值中，则加入
    		if(map.get(index).contains(item[1])) {
    			map.get(index).add(item[1]);
    		}
    	}
    }
    public int lookformin(List<Integer> list,int[] quiet) {
    	int min = Integer.MAX_VALUE;
    	for(Integer i:list) {
    		if(quiet[i]<min) {
    			min = quiet[i];
    		}
    	}
    	return min;
    }
}