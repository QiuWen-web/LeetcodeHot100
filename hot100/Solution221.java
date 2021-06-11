package hot100;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeSet;

public class Solution221 {
	public static void main(String[] args) {
		char[][] matrix = {{'1','1','1','1','1'},
							{'1','1','1','1','1'},
							{'1','1','1','1','1'},
							{'1','1','1','1','1'}};
		
		int line = matrix.length;
		int column = matrix[0].length;
		int size = 0;
		ArrayList<Integer> array = new ArrayList<Integer>();
		for(int i =0;i<line;i++) {
			for(int j=0;j<column;j++) {
				int maxSize = Math.min(line - i, column - j);
				
				System.out.println("����ѡ�����α߳�Ϊ��"+maxSize);
				
				if(matrix[i][j] == '1') {
					System.out.println("��ʱ������Ϊ��"+i + ","+j);
					size = 1;
					for(int k = 1;k<maxSize;k++) {
						boolean res = yanzheng(i,j,matrix,k);
						System.out.println("��"+k+"ʱ�Ľ��Ϊ��"+res);
						if(res) {
							size++;
						}else {
							break;
						}
					}
					System.out.print(size);
					array.add(size);
					
				}else {
					System.out.println("��ʱ������Ϊ��"+i + ","+j+"���ǲ�Ϊ1");
					array.add(0);
				}
				System.out.println("----------------------");
			}
		}
		System.out.println("*************************");
		int max = 0;
		for(int i : array) {
			if(i>max) {
				max = i;
			}
		}
		System.out.println("���������Ϊ"+max*max);
		
	}
	
	public static boolean yanzheng(int i,int j,char[][] matrix,int k) {
		int s = k-1;
		if(matrix[i+k][j+k] == '1') {
			for(;s>-1;s--) {
				if(matrix[i+s][j+k]!='1'||matrix[i+k][j+s]!='1') {
					return false;
				}else {
					continue;
				}
			}
			return true;
		}else {
			return false;
		}
	}
}