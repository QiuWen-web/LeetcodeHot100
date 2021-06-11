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
	//Ĭ�ϴ�
	boolean flag = true;
	//graph�ĳ���
	int n;
	//��¼�Ѿ����ʹ��Ľڵ�
	boolean[] visited;
	//�½������б�
	List<List<Integer>> list = new ArrayList<>();
    public boolean isBipartite(int[][] graph) {
    	list.add(new ArrayList<>());
    	list.add(new ArrayList<>());
    	n = graph.length;
    	visited = new boolean[n];
    	//�����������grapg[index]λ�ô���ֵ 
    	int index = 0;
    	for(int i= 0;i<n;i++) {
    		dfs(graph,i,0);
    	}
    	
    	return flag;
    }
    public void dfs(int[][] graph,int index,int listindex) {
    	if(visited[index] == true) {
    		//�����ʹ�������
    		return;
    	}
    	list.get(listindex).add(index);
    	visited[index] = true;
    	//�õ�graph[index]
    	int[] cur = graph[index];
    	int len = cur.length;
    	
    	//cur�в�����index���ֻҪ��cur���Ƿ��indexͬһ��
    	for(int i=0;i<len;i++) {
    		if(list.get(listindex).contains(cur[i])) {
    			//���ͬһ��
    			flag = false;
    			
    		}else {
    			//����ͬһ��
    			dfs(graph,cur[i],1-listindex);
    		}
    	}
    	if(!flag) {
    		return;
    	}
    }
}