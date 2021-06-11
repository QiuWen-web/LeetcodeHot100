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
	//����
    ArrayList<Integer>[] graph;
    //��
    int[] answer;
    //������
    int[] quiet;

    public int[] loudAndRich(int[][] richer, int[] quiet) {
    	//����
        int N = quiet.length;
        //ÿ����һ��ͼ
        graph = new ArrayList[N];
        //��
        answer = new int[N];
        this.quiet = quiet;
        //ÿ���˶�Ӧһ������
        for (int node = 0; node < N; ++node)
            graph[node] = new ArrayList<Integer>();
        //����richer
        for (int[] edge: richer)
        	//ֱ�ӱȽϵ��������ȥ
            graph[edge[1]].add(edge[0]);
        //�������-1
        Arrays.fill(answer, -1);
        //����ȱ���Ѱ���Ƿ���֮����������
        for (int node = 0; node < N; ++node)
            dfs(node);
        return answer;
    }
    
    //�����������
    public int dfs(int node) {
    	//���nodeû�䣬��û�б�����ģ��ȷ����Լ���id
        if (answer[node] == -1) {
            answer[node] = node;
            //������ָ���������Ѱ���������������
            for (int child: graph[node]) {
                int cand = dfs(child);
                if (quiet[cand] < quiet[answer[node]])
                    answer[node] = cand;
            }
        }
        return answer[node];
    }
}