package DFS;

public class Solution542 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = {{1,0,1,1,0,0,1,0,0,1},{0,1,1,0,1,0,1,0,1,1},
		               {0,0,1,0,1,0,0,1,0,0},{1,0,1,0,1,1,1,1,1,1},
		               {0,1,0,1,1,0,0,0,0,1},{0,0,1,0,1,1,1,0,1,0},
		               {0,1,0,1,0,1,0,0,1,1},{1,0,0,0,1,1,1,1,0,1},
		               {1,1,1,1,1,1,1,0,1,0},{1,1,1,1,0,1,0,0,1,1}};
		dfsSolution542 s = new dfsSolution542();
		int[][] res = s.updateMatrix(mat);
		for(int[] i:res) {
			for(int j :i) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}

}
class dfsSolution542 {
	int rows;
	int cols;
	int m;
	int n;
    public int[][] updateMatrix(int[][] mat) {
    	rows = mat.length;
    	cols = mat[0].length;
    	int[][] res = new int[rows][cols];
    	for(int i = 0;i<rows;i++) {
    		for(int j = 0;j<cols;j++) {
    			res[i][j] = Integer.MAX_VALUE;
    		}
    	}
    	for(int i = 0;i<rows;i++) {
    		for(int j = 0;j<cols;j++) {
    			if(mat[i][j] ==0) {
    				//��Ѱ���λ�õ���������
    				//�������0�򲻶�
    				//���������0��ֵ��1�����Ѱ��
    				
    				dfs(mat,i,j,res);
    			}
    		}
    	}
    	return res;
    }
    public void dfs(int[][] mat,int i,int j,int[][] res) {
    	//����mat[i][j] == 0 ����ÿһ��λ�õ�ֵ
    	for(int m = 0;m<rows;m++) {
    		for(int n = 0;n<cols;n++) {
    			res[m][n] = Math.min(res[m][n],Math.abs(m-i)+Math.abs(n-j));
    		}
    	}
    	
    }
}