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
	//设定初始条件是可以分成两组的
	boolean flag = true;
	//不喜欢的情况
	int num;
	List<Integer> list1 = new ArrayList<>();
	List<Integer> list2 = new ArrayList<>();
    public boolean possibleBipartition(int n, int[][] dislikes) {
    	num = dislikes.length;
    	//按照dislike排序
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
    	//先寻找one是否出现在队里
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
/*对于每个连通的部分，我们只
 * 需试着用两种颜色对它进行着色，就可以
 * 检查它是否是二分的。如何做到这一点：将任一
 * 结点涂成红色，然后将它的所有邻居都涂成蓝色，
 * 然后将所有的邻居的邻居都涂成红色，以此类推。
 * 如果我们将一个红色结点涂成蓝色（或蓝色结点涂成
 * 红色），那么就会产生冲突。
 */
class dfsSolution886_1 {
	//答案
	boolean res = true;
	//染色
	int[] color;
	//访问
	boolean[] flag;
	//数量
	int num;
	//关系
	int[][] dislike;
    public boolean possibleBipartition(int n, int[][] dislikes) {
    	//按照dislike排序
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
    	//查找dislike中和one相关的数组，全染色
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
        //图ok了
        //开始染色
        visited = new boolean[graph.length];
        for(int i = 0;i<graph.length;i++) {
        	if(!visited[i]) {
        		visited[i] = true;
        		//对i的不一样的染色
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
