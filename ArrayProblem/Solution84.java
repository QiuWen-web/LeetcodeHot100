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
        // ö����߽�
        for (int left = 0; left < n; ++left) {
            int minHeight = Integer.MAX_VALUE;
            // ö���ұ߽�
            for (int right = left; right < n; ++right) {
                // ȷ���߶�
                minHeight = Math.min(minHeight, heights[right]);
                // �������
                ans = Math.max(ans, (right - left + 1) * minHeight);
            }
        }
        return ans;
    }
}