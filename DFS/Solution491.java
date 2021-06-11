package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution491 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4,6,7,7};
		dfsSolution491 s = new dfsSolution491();
		List<List<Integer>> res = s.findSubsequences(nums);
	}

}
class dfsSolution491 {
	int n;
	List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
    	//Ԥ����
    	n = nums.length;
    	Arrays.sort(nums);
    	if(n <= 1) {
    		return res;
    	}
    	for(int i = 0;i<n-1;i++) {
    		List<Integer> list= new ArrayList<>();
    		list.add(nums[i]);
    		boolean[] visited = new boolean[n];
    		visited[i] = true;
    		//list���еĵ��������飬i��i����ʼ����������
    		dfs(nums,list,i,visited);
    	}
    	return res;
    }
    public void dfs(int[] nums,List<Integer> list,int i,boolean[] visited) {
    	//��������
    	if(!res.contains(list) && list.size() >= 2) {
    		res.add(list);
    	}
       	if(i==n) {
       		return;
       	}
    	for(int j = i+1;j<n;j++) {
    		int cur = nums[j];
    		int pre = list.get(list.size()-1);
    		if(cur>=pre && !visited[j]) {
    			List<Integer> temp = new ArrayList<>(list);
    			temp.add(cur);
    			visited[j] = true;
    			dfs(nums,temp,j,visited);
    			visited[j] = false;
    		}
    	}
    }
}