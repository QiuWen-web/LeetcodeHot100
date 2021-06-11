package hot100;


import java.util.Stack;

public class Solution394 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "3[a]4[b]10[i]";
		HotSolution394 hotSolution394 = new HotSolution394();
		String res = hotSolution394.decodeString(s);
		System.out.println(res);
	}

}
class HotSolution394 {
    public String decodeString(String s) {
    	Stack<String> stack=new Stack<String>();
    	//���Ȱ���������
    	for(int i = 0;i<s.length();i++) {
    		
    		if(s.charAt(i) == ']') {
    			
    			//�õ�Ҫ���Ƶ��ַ���string
    			String string = "";
    			while(!stack.peek().equals("[")) {
    				string = stack.pop() + string;
    			}
    			stack.pop();
    			//�õ�stringҪ���ƵĴ���
    			String countstring = "";
    			while(!stack.empty() && stack.peek().charAt(0) >= '0'&&stack.peek().charAt(0)<='9') {
    				countstring = stack.pop() + countstring;
    			}
    			int count = Integer.parseInt(countstring);
    			
    			String resString = "";
    			for(int j = 0;j<count;j++) {
    				resString += string;
    			}
    			stack.push(resString);    			
    		}else {
    			stack.push(s.charAt(i)+"");
    		}
    	}
    	String res = "";
    	while(!stack.empty()) {
    		res = stack.pop() + res;
    	}
    	return res;
    }
}