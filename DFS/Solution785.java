package DFS;

import java.util.ArrayList;
import java.util.List;

public class Solution785 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] graph = {{1,3},{0,2},{1,3},{0,2}};
		dfsSolution785 s = new dfsSolution785();
		boolean res = s.isBipartite(graph);
		System.out.println(res);
	}

}
class dfsSolution785 {
	//默认答案
	boolean flag = true;
	//graph的长度
	int n;
	//记录已经访问过的节点
	boolean[] visited;
	//新建两个列表
	List<List<Integer>> list = new ArrayList<>();
    public boolean isBipartite(int[][] graph) {
    	list.add(new ArrayList<>());
    	list.add(new ArrayList<>());
    	n = graph.length;
    	visited = new boolean[n];
    	//深度优先搜索grapg[index]位置处的值 
    	int index = 0;
    	for(int i= 0;i<n;i++) {
    		dfs(graph,i,0);
    	}
    	
    	return flag;
    }
    public void dfs(int[][] graph,int index,int listindex) {
    	if(visited[index] == true) {
    		//被访问过，跳过
    		return;
    	}
    	list.get(listindex).add(index);
    	visited[index] = true;
    	//拿到graph[index]
    	int[] cur = graph[index];
    	int len = cur.length;
    	
    	//cur中不包含index因此只要看cur中是否和index同一侧
    	for(int i=0;i<len;i++) {
    		if(list.get(listindex).contains(cur[i])) {
    			//如果同一侧
    			flag = false;
    			
    		}else {
    			//不在同一侧
    			dfs(graph,cur[i],1-listindex);
    		}
    	}
    	if(!flag) {
    		return;
    	}
    }
}