package DFS;

import java.util.ArrayList;
import java.util.List;

public class Solution797 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] graph = {{4,3,1},{3,2,4},{3},{4},{}};
		int[][] graph1 = {{2},{},{1}};
		dfsSolution797 s = new dfsSolution797();
		List<List<Integer>> res = s.allPathsSourceTarget(graph1);
		for(List<Integer> item : res) {
			for(Integer i:item) {
				System.out.print(i+",");
			}
			System.out.println();
		}
	}

}
class dfsSolution797 {
	int n;
	List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    	int num = graph[0].length;
    	n = graph.length-1;
    	List<Integer> item = new ArrayList<>();
    	
    	dfs(item,graph,0);
    	return res;
    }
    public void dfs(List<Integer> item,int[][] graph,int index) {
    	//����
    	List<Integer> temp = new ArrayList<>();
    	for(Integer i:item) {
    		temp.add(i);
    	}
    	
    	temp.add(index);
    	if(index == n) {
    		//��;�;���ĩβ������Լ���
    		res.add(temp);
    	}
    	
    	//�õ������ָ���λ�õ��������
    	int len = graph[index].length;
    	
    	if(len==0) {
    		//���Ϊ0,���ʾ����ĩβ��
    	}else {
    		//�����Ϊ0���Լ�������
    		for(int i = 0;i<len;i++) {
    			dfs(temp,graph,graph[index][i]);
    		}
    	}
    	
    	
    	
    	
    	
    }
}