package ArrayProblem;

import java.util.ArrayList;

public class Solution1535 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,11,22,33,44,55,66,77,88,99};
		int k = 1000000000;
		ArraySolution1535 s = new ArraySolution1535();
		int res = s.getWinner(arr,k);
		System.out.println(res);
	}
}
class ArraySolution1535 {
    public int getWinner(int[] arr, int k) {
    	ArrayList<Integer> arrs = new ArrayList<Integer>();
    	for(int i = 0;i<arr.length;i++) {
    		arrs.add(arr[i]);
    	}
    	if(k>=arr.length) {
    		arrs.sort(null);
    		return arrs.get(arr.length-1);
    	}
    	int win = 0;
    	int lastwin;
    	int wintimes=1;
    	
    	while(true) {
    		if(arrs.get(0) > arrs.get(1)) {
    			lastwin = win;
    			win = arrs.get(0);
    			
    			if(lastwin == win) {
    				wintimes++;
    			}else {
    				lastwin = win;
    				wintimes = 1;
    			}
    			
    			sort01(arrs);
    		}else {
    			lastwin = win;
    			win = arrs.get(1);
    			
    			if(lastwin == win) {
    				wintimes++;
    			}else {    				
    				wintimes = 1;
    			}
    			
    			sort01(arrs);
    		}
    		if(wintimes == k) {
    			break;
    		}
    	}
    	return win;
    }
    public void sort01(ArrayList<Integer> arrs) {
    	int temp;
    	if(arrs.get(0) > arrs.get(1)) {
    		temp = arrs.get(1);
    		arrs.remove(1);
    		arrs.add(temp);
    	}else {
    		temp = arrs.get(0);
    		arrs.remove(0);
    		arrs.add(temp);
    	}
    }
    public int getWinner002(int[] arr, int k) {
    	//在第一回合游戏之后，无论arr[0] 和arr[1] 当中谁取得胜利
    	//，第二回合游戏的另一个整数一定是 arr 中的下一个整数。
    	//推广到一般的情况，当 2  ≤i<arr.length 时，第 i 回合
    	//游戏一定在第i−1 回合游戏中取得胜利的整数
    	//和arr[i] 之间进行。

        int prev = Math.max(arr[0], arr[1]);
        if (k == 1) {
            return prev;
        }
        int consecutive = 1;
        int maxNum = prev;
        int length = arr.length;
        for (int i = 2; i < length; i++) {
            int curr = arr[i];
            if (prev > curr) {
                consecutive++;
                if (consecutive == k) {
                    return prev;
                }
            } else {
                prev = curr;
                consecutive = 1;
            }
            maxNum = Math.max(maxNum, curr);
        }
        return maxNum;
    }
}