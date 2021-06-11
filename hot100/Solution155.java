package hot100;

public class Solution155 {
	
}
class MinStack{
	
	private int maxSize;//数组容量
	private int front;//队列头
	private int rear;//队列尾
	private int[] arr;//该数据用于存放数据，模拟队列
	
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