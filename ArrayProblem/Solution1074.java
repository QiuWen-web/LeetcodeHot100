package ArrayProblem;
/*给出矩阵 matrix 和目标值 target，
 * 返回元素总和等于目标值的非空子矩阵的数量。
 * */
public class Solution1074 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
				{0,1,0},
				{1,1,1},
				{0,1,0},
		};
		int target = 0;
		ArraySolution1074 s = new ArraySolution1074();
		int result = s.numSubmatrixSumTarget(matrix, target);
		System.out.println(result);
	}

}
class ArraySolution1074 {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
    	//matrix为M*N矩阵
    	int M = matrix.length;
    	int N = matrix[0].length;
    	int[] b = new int[N];
    	int count=0;
    	for(int i = 0;i<M;i++) {
    		for(int j = 0;j < N;j++) {
    			b[j] = 0;
    		}
    		for(int il = i;il<M;il++) {
    			for(int j = 0;j<N;j++) {
    				b[j] += matrix[il][j];
    			}   
    			for(int j = 0;j<N;j++) {
    				int temp = 0;
    				for(int k = j;k<N;k++) {
    					temp += b[k];
    					if(temp == target) {
    						count++;
    					}
    				}
    			}
    		}
    		
    	}
    	return count;
    }
    public int numSubmatrixSumTarget001(int[][] matrix, int target) {
        int M = matrix.length;
        int N = matrix[0].length;
        int[] b = new int[N];
        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                b[j] = 0;
            }
            for (int i1 = i; i1 < M; i1++) {
                for (int j = 0; j < N; j++) {
                    b[j] += matrix[i1][j];
                }
                for (int j = 0; j < N; j++) {
                    int temp = 0;
                    for (int k = j; k < N; k++) {
                        temp += b[k];
                        if (temp == target)
                            count++;
                    }
                }
            }
        }
        return count;
    }

}