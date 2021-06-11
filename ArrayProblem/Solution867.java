package ArrayProblem;
/*
给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
*/
public class Solution867 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
				{2,4,-1},
				{-10,5,11},
				{18,-7,6},
		};
		ArraySolution867 s = new ArraySolution867();
		int[][] result = s.transpose001(matrix);
		for(int[] line : result) {
			for(int k : line) {
				System.out.print(k + ",");
			}
			System.out.println();
		}
	}

}
class ArraySolution867 {
    public int[][] transpose001(int[][] matrix) {
    	//遍历行写入列
    	int[][] newmatrix = new int[matrix.length][matrix.length];
    	for(int i = 0;i<matrix.length;i++) {
    		for(int j = 0;j<matrix.length;j++) {
    			newmatrix[j][i] = matrix[i][j];
    		}
    	}
    	return newmatrix;
    }
}