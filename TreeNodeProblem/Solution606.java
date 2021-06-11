package TreeNodeProblem;

public class Solution606 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode s = new TreeNode(3);
		TreeNode sl = new TreeNode(4);
		TreeNode sr = new TreeNode(5);
		TreeNode sll = new TreeNode(1);
		TreeNode slr = new TreeNode(2);
		TreeNode slrl = new TreeNode(2);
		
		s.left = sl;
		s.right = sr;
		sl.left=sll;
		sl.right=slr;
		slr.left = slrl;
		
		TreeSolution606 res = new TreeSolution606();
		System.out.println(res.tree2str(s));
	}

}
class TreeSolution606 {
	String s = "";
    public String tree2str(TreeNode t) {
    	preOrder(t);
    	String re = s;
    	return re;
//    	StringBuilder sb = new StringBuilder();
//    	//±éÀú×Ö·û´®
//    	for(int i = 0;i<re.length();i++) {
//    		if(i == re.length()-1) {
//    			sb.append(re.charAt(i));
//    		}else if(re.charAt(i) != '(' || re.charAt(i+1) !=')') {
//    			sb.append(re.charAt(i));
//    		}else if(re.charAt(i) == '(' && re.charAt(i+1) ==')'){
//    			if(i+3<re.length()) {
//    				if(re.charAt(i+2) == '(' && re.charAt(i+3) ==')') {
//    					i=i+3;
//    				}else {
//    					sb.append(re.charAt(i));
//    				}
//    			}
//    		}
//    	}
//    	return sb.toString();
    }
    //Ç°Ðò±éÀú ÖÐ ->×ó ->ÓÒ
    public void preOrder(TreeNode t) {
    	s += t.val+"";
    	if(t.left!=null) {
    		s +="(";
    		preOrder(t.left);
    		s +=")";
    	}else if(t.left == null && t.right!=null) {
    		s+="()";
    	}
    	if(t.right!=null) {
    		s +="(";
    		preOrder(t.right);
    		s +=")";
    	}
    }
}