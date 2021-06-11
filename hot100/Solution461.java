package hot100;

public class Solution461 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 1,y=4;
		String x1 = Integer.toBinaryString(x);
		String y1 = Integer.toBinaryString(y);
		System.out.println(x1.length());
		System.out.println(y1.length());
		int lenx = 32-x1.length();
		int leny = 32-y1.length();
		for(int i = 0; i<lenx;i++) {
			x1 = '0'+x1;
		}
		System.out.println(x1);
		for(int i = 0; i<leny;i++) {
			y1 = '0'+y1;
		}
		System.out.println(y1);
		int index = 0;
		for(int i = 31;i>=0;i--) {
			if(x1.charAt(i) != y1.charAt(i)) {
				index++;
			}
		}
		System.out.println("res:"+index);
	}
}
