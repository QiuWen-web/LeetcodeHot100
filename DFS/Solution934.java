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
    	//得到地图的长R宽C
        int R = A.length, C = A[0].length;
        //找到第一座岛屿并染色1，第二座岛屿染色为2
        int[][] colors = getComponents(A);

        Queue<Node1> queue = new LinkedList();
        Set<Integer> target = new HashSet();

        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c) {
            	//当他是第一座岛屿时
                if (colors[r][c] == 1) {
                	//列表加入岛屿位置和深度
                    queue.add(new Node1(r, c, 0));
                    //当他是第二座岛屿时
                } else if (colors[r][c] == 2) {
                	//栈中加入位置
                    target.add(r * C + c);
                }
            }
        //此时已经记录好queue第一座岛屿的位置和深度，第二座岛屿的位置
        while (!queue.isEmpty()) {
        	//弹出每一个岛屿位置
            Node1 node = queue.poll();
            //如果该点也在第二座岛屿中，说明相连，返回深度-1
            if (target.contains(node.r * C + node.c))
                return node.depth - 1;
            //对于每一个没有连接到第二座岛屿的陆地，遍历其周围
            for (int nei: neighbors(A, node.r, node.c)) {
            	
                int nr = nei / C, nc = nei % C;
                //如果颜色未染则+1，并染色，记录位置
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
            	//当未染色且为岛屿时
                if (colors[r0][c0] == 0 && A[r0][c0] == 1) {
                    // Start dfs深度优先搜索
                    Stack<Integer> stack = new Stack();
                    //记录陆地位置
                    stack.push(r0 * C + c0);
                    //染色
                    colors[r0][c0] = ++t;

                    while (!stack.isEmpty()) {
                    	//取出陆地位置
                        int node = stack.pop();
                        int r = node / C, c = node % C;
                        //对于这个陆地位置的邻居
                        for (int nei: neighbors(A, r, c)) {
                            int nr = nei / C, nc = nei % C;
                            //如果还是陆地且未染色
                            if (A[nr][nc] == 1 && colors[nr][nc] == 0) {
                            	//染色
                                colors[nr][nc] = t;
                                //入栈
                                stack.push(nr * C + nc);
                            }
                        }
                    }
                }

        return colors;
    }

    public List<Integer> neighbors(int[][] A, int r, int c) {
        //从r，c的陆地位置上开始在图A中搜索四周的位置，把边界位置剔除了
    	int R = A.length, C = A[0].length;
        List<Integer> ans = new ArrayList();
        if (0 <= r-1) ans.add((r-1) * R + c);
        if (0 <= c-1) ans.add(r * R + (c-1));
        if (r+1 < R) ans.add((r+1) * R + c);
        if (c+1 < C) ans.add(r * R + (c+1));
        return ans;
    }
}


