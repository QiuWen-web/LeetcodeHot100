package DynamicProgram;

public class Solution718 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,3,2,1,4};
		int[] B = {3,2,2,4,7};
		DynamicSolution718 s = new DynamicSolution718();
		System.out.println(s.findLength(A, B));
	}

}
class DynamicSolution718 {
    public int findLength(int[] A, int[] B) {
    	int alen = A.length;
    	int blen = B.length;
    	int maxlen = 0;
    	
    	
    	
    	//最多匹配到A[0]位置
    	for(int i =1;i<=alen;i++) {
    		int count = 0;
    		for(int j=0;j<i;j++) {
    			if(A[alen-i+j] == B[j]) {
    				count++;
    			}else {
    	    		if(count > maxlen) {
    	    			maxlen = count;
    	    		}
    				if(count != 0) {
    					count = 0;
    				}
    			}
    		}
    		if(count > maxlen) {
    			maxlen = count;
    		}
    	}
    	//最多匹配到A[0]位置
    	for(int i =1;i<=blen;i++) {
    		int count = 0;
    		for(int j=0;j<i;j++) {
    			if(B[blen-i+j] == A[j]) {
    				count++;
    			}else {
    	    		if(count > maxlen) {
    	    			maxlen = count;
    	    		}
    				if(count != 0) {
    					count = 0;
    				}
    			}
    		}
    		if(count > maxlen) {
    			maxlen = count;
    		}
    	}
    	return maxlen;
    }
}