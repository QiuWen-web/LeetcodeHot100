package hot100;

public class Solution155 {
	
}
class MinStack{
	
	private int maxSize;//��������
	private int front;//����ͷ
	private int rear;//����β
	private int[] arr;//���������ڴ�����ݣ�ģ�����
	
	public MinStack() {
		
	}
	public void push(int x) {
		arr[rear] = x;
		rear++;
	}
	public void pop() {
		
    }
	public int top() {
		return arr[arr.length-1];
    }
	public int getMin() {
		
    }
}