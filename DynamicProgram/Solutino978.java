package DynamicProgram;

public class Solutino978 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {100};
		DynamicSolution978 s = new DynamicSolution978();
		System.out.println(s.maxTurbulenceSize(arr));
	}

}
class DynamicSolution978 {
    public int maxTurbulenceSize(int[] arr) {
    	int a = maxTurbulenceSizeone(arr);
    	int b = maxTurbulenceSizetwo(arr);
    	return Math.max(a, b);
    }
    public int maxTurbulenceSizeone(int[] arr) {
    	int len = arr.length;
    	int maxlen = 0;
    	int curlen = 0;
    	for(int i = 0;i<len-1;i++) {
    		if(i%2 == 0) {
    			//为偶数,判断和i+1的关系
    			if(arr[i]<arr[i+1]) {
    				curlen++;
    				if(curlen > maxlen) {
    					maxlen = curlen;
    				}
    			}else {
    				curlen = 0;
    			}
    			
    		}
    		if(i%2 == 1) {
    			if(arr[i] > arr[i+1]) {
    				curlen++;
    				if(curlen > maxlen) {
    					maxlen = curlen;
    				}
    			}else {
    				curlen = 0;
    			}
    		}
    	}
    	return maxlen+1;
    }
    public int maxTurbulenceSizetwo(int[] arr) {
    	int len = arr.length;
    	int maxlen = 0;
    	int curlen = 0;
    	for(int i = 0;i<len-1;i++) {
    		if(i%2 == 0) {
    			//为偶数,判断和i+1的关系
    			if(arr[i]>arr[i+1]) {
    				curlen++;
    				if(curlen > maxlen) {
    					maxlen = curlen;
    				}
    			}else {
    				curlen = 0;
    			}
    			
    		}
    		if(i%2 == 1) {
    			if(arr[i] < arr[i+1]) {
    				curlen++;
    				if(curlen > maxlen) {
    					maxlen = curlen;
    				}
    			}else {
    				curlen = 0;
    			}
    		}
    	}
    	return maxlen+1;
    }
}