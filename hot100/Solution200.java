package hot100;

public class Solution200 {
	public static void main(String[] args) {
		char[][] grid = {{'1','0','1','1','0'},
						{'1','1','0','1','0'},
						{'1','1','0','0','0'},
						{'0','0','0','0','0'},};
		int hanglen = grid.length;
		int lielen = grid[0].length;
		System.out.println("���ǣ����ǣ�");
		System.out.println(hanglen+","+lielen);
		
		char[][] newgrid = new char[hanglen+2][lielen+2];
		for(int i = 1;i<hanglen+1;i++) {
			for(int j=1;j<lielen+1;j++) {
				newgrid[i][j] = grid[i-1][j-1];
			}
		}
		for(int j = 0;j<lielen+2;j++) {
			newgrid[0][j] = '0';
			newgrid[hanglen+1][j] = '0';
		}
		for(int i = 0;i<hanglen+2;i++) {
			newgrid[i][0] = '0';
			newgrid[i][lielen+1] = '0';
		}
		//����ÿһ����
		System.out.println("grid:");
		for(int i = 0;i<hanglen;i++) {
			for(int j=0;j<lielen;j++) {
				System.out.print(grid[i][j]);
			}
			System.out.println();
		}
		System.out.println("newgrid:");
		for(int i = 0;i<hanglen+2;i++) {
			for(int j=0;j<lielen+2;j++) {
				System.out.print(newgrid[i][j]);
			}
			System.out.println();
		}
		
		//��newgrid�����ж�
		int sum = 0;//���嵺������
		boolean up = false;
		boolean down = false;
		boolean left = false;
		boolean right = false;
		for(int i = 1;i<hanglen+1;i++) {
			for(int j=1;j<lielen+1;j++) {
				if(newgrid[i][j] == '1') {
					if(sum == 0) {
						sum++;
					}
					up = (newgrid[i-1][j] == '1');
					down = (newgrid[i+1][j] == '1');
					left = (newgrid[i][j-1] == '1');
					right = (newgrid[i][j+1] == '1');
					if(up||down||left||right) {
						
					}else {
						if(sum != 1) {
							sum++;
						}
					}
				}	
			
			}
		}
		
		System.out.println("�����У�" +sum);
	}
	
	
//	//�ж������������Ƿ����1
//	public static void panduan(char[][] grid,int i,int j) {
//		int hanglen = grid.length;
//		int lielen = grid[0].length;
//		//�ж����Ͻ�
//		if(i==0&&j==0) {
//			//���Ƿ�Ϊ1
//			boolean down = (grid[i+1][j] == '0');
//			//���Ƿ�Ϊ1
//			boolean right = (grid[i][j+1] == '0');
//			if(down || right) {
//				
//			}
//		}
//	}
}
