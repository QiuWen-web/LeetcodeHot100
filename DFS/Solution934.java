package DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Solution934 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] A = {{1,1,1,1,1},{1,0,0,0,1},{1,0,1,0,1},{1,0,0,0,1},{1,1,1,1,1}};
		dfsSolution934 s = new dfsSolution934();
		int lu = s.shortestBridge(A);
		System.out.println(lu);
	}

}
class Node1 {
    int r, c, depth;
    Node1(int r, int c, int d) {
        this.r = r;
        this.c = c;
        depth = d;
    }
}
class dfsSolution934 {
    public int shortestBridge(int[][] A) {
    	//�õ���ͼ�ĳ�R��C
        int R = A.length, C = A[0].length;
        //�ҵ���һ�����첢Ⱦɫ1���ڶ�������ȾɫΪ2
        int[][] colors = getComponents(A);

        Queue<Node1> queue = new LinkedList();
        Set<Integer> target = new HashSet();

        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c) {
            	//�����ǵ�һ������ʱ
                if (colors[r][c] == 1) {
                	//�б���뵺��λ�ú����
                    queue.add(new Node1(r, c, 0));
                    //�����ǵڶ�������ʱ
                } else if (colors[r][c] == 2) {
                	//ջ�м���λ��
                    target.add(r * C + c);
                }
            }
        //��ʱ�Ѿ���¼��queue��һ�������λ�ú���ȣ��ڶ��������λ��
        while (!queue.isEmpty()) {
        	//����ÿһ������λ��
            Node1 node = queue.poll();
            //����õ�Ҳ�ڵڶ��������У�˵���������������-1
            if (target.contains(node.r * C + node.c))
                return node.depth - 1;
            //����ÿһ��û�����ӵ��ڶ��������½�أ���������Χ
            for (int nei: neighbors(A, node.r, node.c)) {
            	
                int nr = nei / C, nc = nei % C;
                //�����ɫδȾ��+1����Ⱦɫ����¼λ��
                if (colors[nr][nc] != 1) {
                    queue.add(new Node1(nr, nc, node.depth + 1));
                    colors[nr][nc] = 1;
                }
            }
        }

        throw null;
    }

    public int[][] getComponents(int[][] A) {
        int R = A.length, C = A[0].length;
        int[][] colors = new int[R][C];
        int t = 0;

        for (int r0 = 0; r0 < R; ++r0)
            for (int c0 = 0; c0 < C; ++c0)
            	//��δȾɫ��Ϊ����ʱ
                if (colors[r0][c0] == 0 && A[r0][c0] == 1) {
                    // Start dfs�����������
                    Stack<Integer> stack = new Stack();
                    //��¼½��λ��
                    stack.push(r0 * C + c0);
                    //Ⱦɫ
                    colors[r0][c0] = ++t;

                    while (!stack.isEmpty()) {
                    	//ȡ��½��λ��
                        int node = stack.pop();
                        int r = node / C, c = node % C;
                        //�������½��λ�õ��ھ�
                        for (int nei: neighbors(A, r, c)) {
                            int nr = nei / C, nc = nei % C;
                            //�������½����δȾɫ
                            if (A[nr][nc] == 1 && colors[nr][nc] == 0) {
                            	//Ⱦɫ
                                colors[nr][nc] = t;
                                //��ջ
                                stack.push(nr * C + nc);
                            }
                        }
                    }
                }

        return colors;
    }

    public List<Integer> neighbors(int[][] A, int r, int c) {
        //��r��c��½��λ���Ͽ�ʼ��ͼA���������ܵ�λ�ã��ѱ߽�λ���޳���
    	int R = A.length, C = A[0].length;
        List<Integer> ans = new ArrayList();
        if (0 <= r-1) ans.add((r-1) * R + c);
        if (0 <= c-1) ans.add(r * R + (c-1));
        if (r+1 < R) ans.add((r+1) * R + c);
        if (c+1 < C) ans.add(r * R + (c+1));
        return ans;
    }
}


