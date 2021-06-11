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
    	//首先拿到点数
    	int dianshu = points.length;
    	//设定一共要走time时间
    	int time = 0;
    	for(int i = 0;i<dianshu-1;i++) {
    		//先比较从i到i+1这两点的时间消耗
    		int a = Math.abs(points[i][0] - points[i+1][0]);
    		int b = Math.abs(points[i][1] - points[i+1][1]);
    		int min = Math.max(a, b);
    		time += min;
    	}
    	return time;
    }
}