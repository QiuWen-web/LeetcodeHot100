package DFS;

import java.util.ArrayList;
import java.util.List;

public class Solution802 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] graph1 = {{1,2},{2,3},{5},{0},{5},{},{}};
		int[][] graph2 = {{1,2,3,4},{1,2},{3,4},{0,4},{}};
		dfsSolution802 s = new dfsSolution802();
		List<Integer> res = s.eventualSafeNodes(graph2);
		for(Integer i:res) {
			System.out.print(i+",");
		}
	}

}
class dfsSolution802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int N = graph.length;
        int[] color = new int[N];
        List<Integer> ans = new ArrayList();

        for (int i = 0; i < N; ++i)
            if (dfs(i, color, graph))
                ans.add(i);
        return ans;
    }

    // colors: WHITE 0, GRAY 1, BLACK 2;
    public boolean dfs(int node, int[] color, int[][] graph) {
        if (color[node] > 0)
            return color[node] == 2;

        color[node] = 1;
        for (int nei: graph[node]) {
            if (color[node] == 2)
                continue;
            if (color[nei] == 1 || !dfs(nei, color, graph))
                return false;
        }

        color[node] = 2;
        return true;
    }
}