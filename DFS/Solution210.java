package DFS;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

//在选修某些课程之前需要一些先修课程。 例如，
//想要学习课程 0 ，你需要先完成课程 1
//，我们用一个匹配来表示他们: [0,1]
public class Solution210 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numCourses = 2;
		int[][] prerequisites =  {{1,0},{0,1}};
		dfsSolution210 s = new dfsSolution210();
		int[] res = s.findOrder(numCourses, prerequisites);
		System.out.println(Arrays.toString(res));
	}

}
class dfsSolution210 {
	int[] visited;
	int[] look;
	boolean flag = false;
	Stack<Integer> stack = new Stack<>();
	public int[] findOrder(int numCourses, int[][] prerequisites) {
    	//建立访问标记数组
        int[] res  = new int[numCourses];
    	visited = new int[numCourses];
    	look = new int[numCourses];
    	//[[1,0]] 要学习课程 1，你需要先完成课程 0

    	for(int i = 0;i<prerequisites.length;i++) {
    		int curCourse = prerequisites[i][0];
    		dfs(prerequisites,curCourse);
    	}
    	for(int i = 0;i<visited.length;i++) {
    		if(visited[i] == 0) {
    			dfs(prerequisites,i);
    		}
    	}
        int k = numCourses-1;
    	while(!stack.isEmpty()) {
    		res[k--] = stack.pop();
    	}
    	int[] zero = {};
    	if(flag) {
    		return zero;
    	}
        return res;
    }
    //curCourse为当前要学习的课程，preCourse为前置课程
    public void dfs(int[][] prerequisites,int preCourse) {
    	//首先遍历寻找前置课程是否有前置课程
    	for(int i = 0;i<prerequisites.length;i++) {
    		if(prerequisites[i][0] == preCourse) {
    			//寻找前置课程的前置课程,如果前置课程没有被访问
    			if(visited[prerequisites[i][1]] == 0 && look[preCourse] == 0) {
    				if(look[prerequisites[i][1]] == 1) {
    					//形成图
    					flag = true;
    					break;
    				}
    				look[preCourse] = 1;
    				dfs(prerequisites,prerequisites[i][1]);
    				look[preCourse] = 0;
    			}
    			
    		}
    	}
    	//寻找完毕，1找完了，2没找到
    	if(!stack.contains(preCourse)) {
    		visited[preCourse] = 1;
    		stack.push(preCourse);
    	}
    }
}