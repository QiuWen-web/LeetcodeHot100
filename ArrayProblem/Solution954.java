package ArrayProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Solution954 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,1,2,6};
		ArraySolution954 s = new ArraySolution954();
		System.out.println(s.canReorderDoubled(arr));
		System.out.println(-5%2);
	}

}
class ArraySolution954 {
    public boolean canReorderDoubled(int[] A) {
        // count[x] = the number of occurrences of x in A
        Map<Integer, Integer> count = new HashMap();
        for (int x: A)
            count.put(x, count.getOrDefault(x, 0) + 1);

        // B = A as Integer[], sorted by absolute value
        Integer[] B = new Integer[A.length];
        for (int i = 0; i < A.length; ++i)
            B[i] = A[i];
        Arrays.sort(B, Comparator.comparingInt(Math::abs));

        for (int x: B) {
            // If this can't be consumed, skip
            if (count.get(x) == 0) continue;
            // If this doesn't have a doubled partner, the answer is false
            if (count.getOrDefault(2*x, 0) <= 0) return false;

            // Write x, 2*x
            count.put(x, count.get(x) - 1);
            count.put(2*x, count.get(2*x) - 1);
        }

        // If we have written everything, the answer is true
        return true;
    }
}
