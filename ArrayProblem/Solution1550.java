package ArrayProblem;

public class Solution1550 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,34,3,4,5,7,23,12};
		ArraySolution1550 s = new ArraySolution1550();
		System.out.println(s.threeConsecutiveOdds(arr));
	}

}
class ArraySolution1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
    	int len = arr.length;
    	int i = 0 ;
    	
    	while(i<len-2) {
    		//如果i位置的值为偶数
    		if(arr[i] % 2 == 0) {
    			i++;
    		}else {
    			//i位置的值为奇数
    			int j = i + 1;
    			if(arr[j] % 2 == 0) {
    				//如果第二个数为偶数
    				i = i + 2;
    			}else {
    				//如果第二个数为奇数
    				int k = j + 1;
    				if(arr[k] % 2 == 0) {
    					//如果第三个数为偶数
    					i = i + 3;
    				}else {
    					//如果第三个数为奇数
    					return true;
    				}
    			}
    		}
    	}
    	return false;
    }
}