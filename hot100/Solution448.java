package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution448 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,2};
		HotSolution448 hotSolution448 = new HotSolution448();
		System.out.println(hotSolution448.findDisappearedNumbers(nums));
		System.out.println(findDisappearedNumbers2(nums));
	}
	public static List<Integer> findDisappearedNumbers2(int[] nums){
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(nums);
		if(nums.length == 2) {
			list.add(1);
			list.add(2);
			list.remove((Integer)nums[0]);
			return list; 
		}
		int index = 0;
		for(int i = 1;i<nums.length;i++) {
			if(i == nums[index]) {
				index++;
			}else if (i == nums[index+1] &&index+1<nums.length) {
				index +=2;
			}else {
				list.add(i);
			}
		}
		return list;
	}

}
class HotSolution448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
    	List<Integer> list = new ArrayList<Integer>();
    	//�������ڷ�Χ��1-n֮�䣬�����ȸ�listѭ����ֵn����
    	for(int i =1;i<nums.length+1;i++) {
    		list.add(i);
    	}
    	//Ȼ�󰤸����ң�ɾ��
    	for(int i= 0;i<nums.length;i++) {
    		//���list�д������������ɾ��
    		if(list.contains(nums[i])) {
    			list.remove((Integer)nums[i]);
    		}else {
    			continue;
    		}
    	}
    	return list;
    }
}