package ArrayProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Solution84 {

	public static void main(String[] args) {
		// TODO Auto-generated mthod stub
		int[] heights = {4,3,2,3,1,2,4};
		ArraySolution84 s= new ArraySolution84();
		
		int result = s.largestRectangleArea(heights);
		System.out.println(result);
		
	}

}
class ArraySolution84 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int ans = 0;
        // 枚举左边界
        for (int left = 0; left < n; ++left) {
            int minHeight = Integer.MAX_VALUE;
            // 枚举右边界
            for (int right = left; right < n; ++right) {
                // 确定高度
                minHeight = Math.min(minHeight, heights[right]);
                // 计算面积
                ans = Math.max(ans, (right - left + 1) * minHeight);
            }
        }
        return ans;
    }
}