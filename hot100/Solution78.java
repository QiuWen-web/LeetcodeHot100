package hot100;

import java.util.ArrayList;
import java.util.List;

public class Solution78 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3};
		HotSolution78 hotSolution78 = new HotSolution78();
		List<List<Integer>> res = hotSolution78.subsets(nums);
		System.out.println(res);
	}

}
class HotSolution78 {
    public List<List<Integer>> subsets(int[] nums) {
    	List<Integer> item = new ArrayList<Integer>();
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	list.add(item);
    	//特殊情况,如果nums为空，则返回[]，如果为长度为1,则返回[[nums[0],[]]
    	if(nums.length == 0) {
    		
    		return list;    		
    	}
    	
    	for(int i = 0 ;i<nums.length;i++) {
    		//新建一个空res
    		List<List<Integer>> res = new ArrayList<List<Integer>>();
    		//复制原来的list元素，在添加新的nums[i]，再加入到res中
    		for(List<Integer> s : list) {
        		//新建一个res,继承原来的答案
        		List<Integer> re = new ArrayList<Integer>(s);
    			re.add(nums[i]);
    			res.add(re);
    		}
    		//再把处理好的res加入到原list中
    		list.addAll(res);
    	}
    	return list;
    }
}