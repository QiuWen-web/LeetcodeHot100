package ArrayProblem;

import java.util.ArrayList;
import java.util.TreeMap;

public class Solution1438 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {4,2,2,2,4,4,2,2};
		int limit = 0;
		ArraySolution1438 s = new ArraySolution1438();
		System.out.println(s.longestSubarray(nums, limit));
	}

}
class ArraySolution1438 {
	public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int n = nums.length;
        int left = 0, right = 0;
        int ret = 0;
        while (right < n) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            ret = Math.max(ret, right - left + 1);
            right++;
        }
        return ret;
    }
}