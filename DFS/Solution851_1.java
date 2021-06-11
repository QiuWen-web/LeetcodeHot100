package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Solution851_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] richer = {{1,0},{2,1},{3,1},{5,3},{4,3},{6,3},{3,7}};
		int[] quiet = {3,2,5,4,6,1,7,0};
		dfsSolution851 s = new dfsSolution851();
		int[] res = s.loudAndRich(richer, quiet);
		for(int i: res) {
			System.out.print(i+",");
		}
	}

}
class dfsSolution851{
	//数组
    ArrayList<Integer>[] graph;
    //答案
    int[] answer;
    //安静数
    int[] quiet;

    public int[] loudAndRich(int[][] richer, int[] quiet) {
    	//人数
        int N = quiet.length;
        //每个人一个图
        graph = new ArrayList[N];
        //答案
        answer = new int[N];
        this.quiet = quiet;
        //每个人对应一个数组
        for (int node = 0; node < N; ++node)
            graph[node] = new ArrayList<Integer>();
        //遍历richer
        for (int[] edge: richer)
        	//直接比较的先添加上去
            graph[edge[1]].add(edge[0]);
        //答案先填充-1
        Arrays.fill(answer, -1);
        //再深度遍历寻找是否与之相连的数组
        for (int node = 0; node < N; ++node)
            dfs(node);
        return answer;
    }
    
    //深度优先搜索
    public int dfs(int node) {
    	//如果node没变，即没有比他大的，先返回自己的id
        if (answer[node] == -1) {
            answer[node] = node;
            //再在其指向的数组中寻找最安静的数，返回
            for (int child: graph[node]) {
                int cand = dfs(child);
                if (quiet[cand] < quiet[answer[node]])
                    answer[node] = cand;
            }
        }
        return answer[node];
    }
}