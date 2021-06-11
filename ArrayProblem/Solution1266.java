package ArrayProblem;

public class Solution1266 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] points = {{3,2},{-2,2}};
		ArraySolution1266 s = new ArraySolution1266();
		System.out.println(s.minTimeToVisitAllPoints(points));
	}

}
class ArraySolution1266 {
    public int minTimeToVisitAllPoints(int[][] points) {
    	//�����õ�����
    	int dianshu = points.length;
    	//�趨һ��Ҫ��timeʱ��
    	int time = 0;
    	for(int i = 0;i<dianshu-1;i++) {
    		//�ȱȽϴ�i��i+1�������ʱ������
    		int a = Math.abs(points[i][0] - points[i+1][0]);
    		int b = Math.abs(points[i][1] - points[i+1][1]);
    		int min = Math.max(a, b);
    		time += min;
    	}
    	return time;
    }
}