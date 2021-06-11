package DynamicProgram;

public class Solution392 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DynamicSolution392 res = new DynamicSolution392();
		String s = "axc";
		String t = "ahbgdc";
		System.out.println(res.isSubsequence(s, t));
	}

}
class DynamicSolution392 {
    public boolean isSubsequence(String s, String t) {
    	int i = 0;
    	int j =0;
    	int m = s.length();
    	int n = t.length();//t³¤Ò»µã
    	while(i<m&&j<n) {
    		if(s.charAt(i) == t.charAt(j)) {
    			i++;
    			j++;
    		}else {
    			j++;
    		}
    	}
    	if(i == m) {
    		return true;
    	}else {
    		return false;
    	}
    	
    }
}