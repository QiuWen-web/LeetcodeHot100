package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Solution756 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String bottom = "CCC";
		List<String> allowed = new ArrayList<>();
		allowed.add("CBB");allowed.add("ACB");allowed.add("ABD");
		allowed.add("CDB");allowed.add("BDC");allowed.add("CBC");
		allowed.add("DBA");allowed.add("DBB");allowed.add("CAB");
		allowed.add("BCB");allowed.add("BCC");allowed.add("BAA");
		allowed.add("CCD");allowed.add("BDD");allowed.add("DDD");
		allowed.add("CCA");allowed.add("CAA");allowed.add("CCC");
		allowed.add("CCB");
		dfsSolution756 s = new dfsSolution756();
		boolean flag = s.pyramidTransition(bottom, allowed);
		System.out.println(flag);
	}

}
class dfsSolution756 {
	boolean flag = false;
	Map<String,List<String>> map = new HashMap<>();
    public boolean pyramidTransition(String bottom, List<String> allowed) {
    	//dfs为bottom能否实现上一层的堆切
    	for(String s: allowed) {
    		if(!map.containsKey(s.substring(0, 2))) {
    			List<String> temp = new ArrayList<>();
    			temp.add(s.charAt(2)+"");
    			map.put(s.substring(0,2),temp);
    		}else {
    			map.get(s.substring(0,2)).add(s.charAt(2)+"");
    		}
    		
    	}
    	String upper = "";
    	dfs(bottom,upper,0);
    	return flag;
    }
    public void dfs(String bottom,String upper,int index) {
    	int n = bottom.length();
    	//如果底层为2up为1
    	if(index == bottom.length()-1) {
    		if(upper.length() == 1) {
    			flag = true;
    			return;
    		}
    	}
    	if(index == n-1) {
    		dfs(upper,"",0);
    	}else {
    		//取bottom的index-index+2；
    		String temp = bottom.substring(index, index+2);
    		for(Entry<String, List<String>> entry:map.entrySet()) {
    			String temp1 = entry.getKey();
    			if(temp1.equals(temp)) {
    				List<String> list = entry.getValue();
    				for(String s:list) {
    					dfs(bottom,upper+s,index+1);
    				}
    			}
    		}
    	}
    	
    }
}