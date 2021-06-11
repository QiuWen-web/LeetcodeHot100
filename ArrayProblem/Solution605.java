package ArrayProblem;

public class Solution605 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] flowerbed = {1};
		int n = 0;
		ArraySolution605 s = new ArraySolution605();
		System.out.println(s.canPlaceFlowers(flowerbed, n));
	}

}
class ArraySolution605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
    	int len  = flowerbed.length;
    	int[] nums = new int[len];
    	for(int i = 0 ;i< len;i++) {
    		if(i == 0 && flowerbed[0] == 1) {
    			nums[0] = 1;
    			if(1 <= len-1) {
    				nums[1] = 1;
    			}
    		}
    		if(flowerbed[i] == 1 && i != 0 && i != len-1) {
    			nums[i-1] = 1;
    			nums[i] = 1;
    			nums[i+1] = 1;
    		}
    		if(i == len-1 && flowerbed[len-1] == 1) {
    			nums[len-1] = 1;
    			if(len-2 >= 0) {
    				nums[len-2] = 1;
    			}
    		}
    	}
    	for(int j = 0;j < len;j++) {
    		if(nums[j] == 0) {
    			if(j-1 >= 0) {
    				nums[j-1] = 1;
    			}
    			
    			nums[j] = 1;
    			
    			if(j+1 <= len-1) {
    				nums[j+1] = 1;
    			}
    			
    			n--;
    		}
    	}
    	if(n <= 0) {
    		return true;
    	}else {
    		return false;
    	}
    }
}