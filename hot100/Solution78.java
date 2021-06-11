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
    	//�������,���numsΪ�գ��򷵻�[]�����Ϊ����Ϊ1,�򷵻�[[nums[0],[]]
    	if(nums.length == 0) {
    		
    		return list;    		
    	}
    	
    	for(int i = 0 ;i<nums.length;i++) {
    		//�½�һ����res
    		List<List<Integer>> res = new ArrayList<List<Integer>>();
    		//����ԭ����listԪ�أ�������µ�nums[i]���ټ��뵽res��
    		for(List<Integer> s : list) {
        		//�½�һ��res,�̳�ԭ���Ĵ�
        		List<Integer> re = new ArrayList<Integer>(s);
    			re.add(nums[i]);
    			res.add(re);
    		}
    		//�ٰѴ���õ�res���뵽ԭlist��
    		list.addAll(res);
    	}
    	return list;
    }
}