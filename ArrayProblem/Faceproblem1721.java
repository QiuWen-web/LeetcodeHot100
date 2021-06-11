package ArrayProblem;

public class Faceproblem1721 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = {2,1,0,1,0,3,1,2,4,0,1};
		ArraySolution1721 s = new ArraySolution1721();
		System.out.println(s.trap(height));
	}

}
class ArraySolution1721 {
    public int trap(int[] height) {
    	int len = height.length;
    	int[] water = new int[len];
    	int waterall = 0;
    	//遍历每一个位置
    	for(int i = 0;i<len;i++) {
    		int leftmax = height[i];
    		int rightmax = height[i];
    		//寻找左右最大的柱子
    		for(int l = i-1;l>=0;l--) {
    			if(height[l]>leftmax) {
    				leftmax = height[l];
    			}
    		}
    		for(int r = i+1;r<len;r++) {
    			if(height[r]>rightmax) {
    				rightmax = height[r];
    			}
    		}
    		//得到左右最高柱子
    		water[i] = Math.min(leftmax, rightmax)-height[i];
    	}
    	for(int i : water) {
    		waterall += i;
    	}
    	return waterall;
    }    
}