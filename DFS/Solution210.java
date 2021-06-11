package DFS;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

//��ѡ��ĳЩ�γ�֮ǰ��ҪһЩ���޿γ̡� ���磬
//��Ҫѧϰ�γ� 0 ������Ҫ����ɿγ� 1
//��������һ��ƥ������ʾ����: [0,1]
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
    	//�������ʱ������
        int[] res  = new int[numCourses];
    	visited = new int[numCourses];
    	look = new int[numCourses];
    	//[[1,0]] Ҫѧϰ�γ� 1������Ҫ����ɿγ� 0

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
    //curCourseΪ��ǰҪѧϰ�Ŀγ̣�preCourseΪǰ�ÿγ�
    public void dfs(int[][] prerequisites,int preCourse) {
    	//���ȱ���Ѱ��ǰ�ÿγ��Ƿ���ǰ�ÿγ�
    	for(int i = 0;i<prerequisites.length;i++) {
    		if(prerequisites[i][0] == preCourse) {
    			//Ѱ��ǰ�ÿγ̵�ǰ�ÿγ�,���ǰ�ÿγ�û�б�����
    			if(visited[prerequisites[i][1]] == 0 && look[preCourse] == 0) {
    				if(look[prerequisites[i][1]] == 1) {
    					//�γ�ͼ
    					flag = true;
    					break;
    				}
    				look[preCourse] = 1;
    				dfs(prerequisites,prerequisites[i][1]);
    				look[preCourse] = 0;
    			}
    			
    		}
    	}
    	//Ѱ����ϣ�1�����ˣ�2û�ҵ�
    	if(!stack.contains(preCourse)) {
    		visited[preCourse] = 1;
    		stack.push(preCourse);
    	}
    }
}