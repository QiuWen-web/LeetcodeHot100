package DFS;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution967 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dfsSolution967 s = new dfsSolution967();
		int[] res = s.numsSameConsecDiff(2, 1);
		for(int I:res) {
			System.out.println(I);
		}
	}

}
class dfsSolution967 {
	int n;
	int k;
	List<Deque<Integer>> res = new ArrayList<>();
    public int[] numsSameConsecDiff(int n, int k) {
    	//n为结果是几位数，k为相邻的差
    	this.n = n;
    	this.k = k;
    	Deque<Integer> shu = new LinkedList<>();
    	dfs(shu);
    	int size = res.size();
    	int[] list = new int[size];
    	for(int i =0;i<size;i++) {
    		Deque<Integer> temp = res.get(i);
    		//将temp转换成数字
    		int item = helper(temp);
    		list[i] = item;
    	}
    	return list;
    }
    public int helper(Deque<Integer> temp) {
    	//temp的长度为n，因此每次弹出一个
    	int sum = 0;
    	int i = 0;
    	while(!temp.isEmpty()) {
    		int num = temp.pollLast();
    		sum += num*Math.pow(10, i++);
    	}
    	return sum;
    }
    public void dfs(Deque<Integer> shu) {
    	if(shu.size()==n) {
    		if(shu.peekFirst()!=0) {
    			res.add(new LinkedList<>(shu));
    			return;
    		}else {
    			return;
    		}    		
    	}
    	if(shu.size()==0) {
    		for(int i = 0;i<=9;i++) {
    			shu.addFirst(i);;
    			dfs(shu);
    			shu.removeFirst();
    		}
    	}
    	if(shu.size()>0 && shu.size()<n) {
    		int back = shu.peekFirst();
    		int ap1 = back-k;
    		int ap2 = back+k;
    		if(k==0) {
    			if(ap1>=0&&ap1<=9) {
        			shu.addFirst(ap1);;
        			dfs(shu);
        			shu.removeFirst();
        		}
    		}else {
    			if(ap1>=0&&ap1<=9) {
    				shu.addFirst(ap1);;
    				dfs(shu);
    				shu.removeFirst();
    			}
    			if(ap2>=0&&ap2<=9) {
    				shu.addFirst(ap2);;
    				dfs(shu);
    				shu.removeFirst();
    			}
    		}
    		
    	}
    }
}