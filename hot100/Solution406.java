package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution406 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		HotSolution406 hotSolution406 = new HotSolution406();
		hotSolution406.reconstructQueue(people);
	}

}
class HotSolution406 {
    public int[][] reconstructQueue(int[][] people) {
    	//首先得到peopel人数len，再建立一个结果用来返回结果
    	int len = people.length;
    	int[][] res = new int[len][2];
    	
    	List<List<Integer>> array = new ArrayList<>();
    	//然后开始遍历people进行排序
    	for(int i =0;i<len;i++) {
    		
    		List<Integer> list = new ArrayList<Integer>();
    		
    		list.add(people[i][0]);
    		list.add(people[i][1]);
    		System.out.println("list为:"+list);
    		
    		if(list.get(1) == 0) {
    			if(array.size() != 0) {
    				int index = 0;
    				for(;index<array.size();index++) {
    					if(list.get(0)<array.get(index).get(0)) {
    						array.add(index,list);
    						break;
    					}
    				}
    				if(index == array.size()) {
    					array.add(list);
    				}
    				
    			}else {
    				array.add(0,list);
    			}
    		}else {
    			//如果list[2]的值不为0,如{4，1}
    			//先得到1这个值
    			int value = list.get(1);
    			int j = 0
    			//如果这个值前面有value个大于list.get(0)的数组，则插入
    			for(; j<array.size();j++) {
    				if(array.get(j).get(0)>=list.get(0)) {
    					value--;
    				}
    				if(value == 0) {
    					//此时可以插入到（j+1）位置了
    					//但是要判断后面那个数是否合理
    					if(array.size() == array.get(j+1).get(1)) {
    						array.add(list);
    						break;
    					}else {
    						array.add(j+1,list);
    						break;
    					}
    				}
    			}
    			if(j == array.size()) {
    				array.add(list);
    			}
    		}
    	}
    	
    	System.out.println(array);
    	
    	return res;
    }
}