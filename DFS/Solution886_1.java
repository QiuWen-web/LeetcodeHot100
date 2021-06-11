package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution886_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int[][] dislikes = {{1,2},{2,3},{3,4},{4,5},{1,5}};
		dfsSolution886_2 s=new dfsSolution886_2();
		
		boolean res = s.possibleBipartition(n, dislikes);
		System.out.println(res);
	}

}
class dfsSolution886 {
	//�趨��ʼ�����ǿ��Էֳ������
	boolean flag = true;
	//��ϲ�������
	int num;
	List<Integer> list1 = new ArrayList<>();
	List<Integer> list2 = new ArrayList<>();
    public boolean possibleBipartition(int n, int[][] dislikes) {
    	num = dislikes.length;
    	//����dislike����
    	Arrays.sort(dislikes, new Comparator<int[]>(){
    		@Override
    		public int compare(int[] o1,int[] o2) {
    			if(o1[0]==o2[0]) {
    				return o1[1]-o2[1];
    			}
    			return o1[0]-o2[0];
    		}
    	});

    	for(int i = 0;i<num;i++) {
    		dfs(dislikes[i]);
    		if(!flag) {
    			return false;
    		}
    	}
    	return flag;
    }
    public void dfs(int[] item) {
    	int one = item[0];
    	int two = item[1];
    	//��Ѱ��one�Ƿ�����ڶ���
    	if(list1.contains(one)&&!list1.contains(two)) {
    		if(!list2.contains(two)) {
    			list2.add(two);
    		}
    	}else if(list2.contains(one)&&!list2.contains(two)) {
    		if(!list1.contains(two)) {
    			list1.add(two);
    		}
    	}else if(list1.contains(one)&&list1.contains(two)) {
    		flag = false;
    		return;
    	}else if(list2.contains(one)&&list2.contains(two)) {
    		flag = false;
    		return;
    	}else {
    		list1.add(one);
    		list2.add(two);
    	}
    	
    }
}
/*����ÿ����ͨ�Ĳ��֣�����ֻ
 * ��������������ɫ����������ɫ���Ϳ���
 * ������Ƿ��Ƕ��ֵġ����������һ�㣺����һ
 * ���Ϳ�ɺ�ɫ��Ȼ�����������ھӶ�Ϳ����ɫ��
 * Ȼ�����е��ھӵ��ھӶ�Ϳ�ɺ�ɫ���Դ����ơ�
 * ������ǽ�һ����ɫ���Ϳ����ɫ������ɫ���Ϳ��
 * ��ɫ������ô�ͻ������ͻ��
 */
class dfsSolution886_1 {
	//��
	boolean res = true;
	//Ⱦɫ
	int[] color;
	//����
	boolean[] flag;
	//����
	int num;
	//��ϵ
	int[][] dislike;
    public boolean possibleBipartition(int n, int[][] dislikes) {
    	//����dislike����
    	Arrays.sort(dislikes, new Comparator<int[]>(){
    		@Override
    		public int compare(int[] o1,int[] o2) {
    			if(o1[0]==o2[0]) {
    				return o1[1]-o2[1];
    			}
    			return o1[0]-o2[0];
    		}
    	});
    	dislike = dislikes;
    	color = new int[n+1];
    	
    	num = dislikes.length;
    	flag = new boolean[num];
    	for(int i = 0;i<num;i++) {
    		if(!flag[i]) {
    			flag[i] = true;
    			dfs(dislike[i]);   			
    		}
    		if(!res) {
    			return false;
    			
    		}
    	}
    	return res;
    }
    public void dfs(int[] item) {
    	int one = item[0];
    	int two = item[1];
    	if(color[one] == color[two] && color[one] != 0) {
    		res= false;
    		return;
    	}
    	if(color[one] == 0 && color[two] == 0) {
    		color[one] = 1;
    		color[two] = 2;
    	}else if(color[one] == 1 && color[two] ==0) {
    		color[two] = 2;
    	}else if(color[one] == 2 && color[two] ==0) {
    		color[two] = 1;
    	}
    	//����dislike�к�one��ص����飬ȫȾɫ
    	for(int i = 0;i<num;i++) {
    		if(dislike[i][0] == two && !flag[i]) {
    			flag[i] = true;
    			dfs(dislike[i]);
    		}
    	}
    }
}
class dfsSolution886_2 {
	boolean res = true;
    ArrayList<Integer>[] graph;
    int[] color;
    boolean[] visited;
    public boolean possibleBipartition(int N, int[][] dislikes) {
        graph = new ArrayList[N+1];
        color = new int[N+1];
        for (int i = 1; i <= N; ++i)
            graph[i] = new ArrayList();

        for (int[] edge: dislikes) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        //ͼok��
        //��ʼȾɫ
        visited = new boolean[graph.length];
        for(int i = 0;i<graph.length;i++) {
        	if(!visited[i]) {
        		visited[i] = true;
        		//��i�Ĳ�һ����Ⱦɫ
        		dfs(graph[i],i);
        	}
        	if(!res) {
        		return false;
        	}
        }
        return res;

    }

    public void dfs(ArrayList<Integer> list,int index) {
        if(color[index] == 0 ||color[index] == 1) {
        	color[index] = 1;
        	for(Integer j :list) {
        		if(color[j] == 1) {
        			res = false;
        			return;
        		}else {
        			color[j] = 2;
        			visited[j] = true;
        			dfs(graph[j],j);
        		}
        		
        	}
        }else if(color[index] == 2) {
        	for(Integer j :list) {
        		if(color[j] == 2) {
        			res = false;
        			return;
        		}else {
        			color[j] = 1;
        			visited[j] = true;
        			dfs(graph[j],j);
        		}
        	}
        }
        
        
    }
}
