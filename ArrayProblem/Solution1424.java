package ArrayProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution1424 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> num = new ArrayList<>();
		num.add(1);num.add(2);num.add(3);num.add(4);num.add(5);
		List<Integer> num1 = new ArrayList<>();
		num1.add(6);num1.add(7);//num1.add(6);
		List<Integer> num2 = new ArrayList<>();
		num2.add(8);//num2.add(8);num2.add(9);
		List<Integer> num3 = new ArrayList<>();
		num3.add(9);num3.add(10);num3.add(11);
		List<Integer> num4 = new ArrayList<>();
		num4.add(12);num4.add(13);num4.add(14);num4.add(15);num4.add(16);
		List<List<Integer>> nums = new ArrayList<>();
		nums.add(num);nums.add(num1);nums.add(num2);
		nums.add(num3);nums.add(num4);
		ArraySolution1424 s = new ArraySolution1424();
		int[] res = s.findDiagonalOrder(nums);
		System.out.println(Arrays.toString(res));
		
	}

}
class ArraySolution1424 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
    	int rows = nums.size();
    	int cols = 0;
    	int numbers = 0;
    	for(List<Integer> l : nums) {
    		int templen = l.size();
    		numbers += templen;
    		if(cols < templen) {
    			cols = templen;
    		}
    	}
    	//拿到rows行cols列了
    	

    	//创建答案容器
    	int k = 0;
    	int[] res = new int[numbers];
    	
    	//对角线遍历sqare怎么写啊!
    	
    	for(int sum = 0;sum <= rows+cols-2;sum++) {
    		int i = sum;
    		if(i<rows) {
    			
    			int j = 0;
    			while(j<=cols-1 && i >=0) {
    				if(nums.get(i).size() > j) {
    					res[k++] = nums.get(i).get(j);
    				}
    				i--;
    				j++;
    			}    			
    		}else {
    			i = rows-1;
    			
    			int j = sum - i;
    			while(j<= cols-1 && i >=0 ) {
    				if(nums.get(i).size() > j) {
    					res[k++] = nums.get(i).get(j);
    				}
    				i--;j++;
    			}
    		}
    	}
    	
    	return res;
    }
    public int[] findDiagonalOrder001(List<List<Integer>> nums) {
        int len = 0;
		Map<Integer,List<Integer>> map = new TreeMap<>();
		for(int i = 0;i < nums.size();i++) {
			len += nums.get(i).size(); // 获取最后要返回的数组的长度，即元素个数
			for(int j = 0;j < nums.get(i).size();j++) {
				if(map.containsKey(i + j)) {
					map.get(i + j).add(nums.get(i).get(j));
				}
				else {
					List<Integer> list = new ArrayList<>();
					list.add(nums.get(i).get(j));
					map.put(i + j, list);
				}
			}
		}
		int[] ans = new int[len];
		int index = 0;
		for(int key : map.keySet()) { // 遍历map
			List<Integer> list = map.get(key);
			for(int j = list.size() - 1;j >= 0;j--) { // 根据题目的输出要求确定生成数组中元素的顺序
				ans[index] = list.get(j);
				index++;
			}
		}
        return ans;
    }

}