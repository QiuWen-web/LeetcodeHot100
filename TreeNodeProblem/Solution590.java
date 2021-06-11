package TreeNodeProblem;

import java.util.ArrayList;
import java.util.List;

public class Solution590 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class TreeSolution590 {
	private List<Integer> res = new ArrayList<>();
    public List<Integer> postorder(Node root) {
    	   if(root == null) {
    		   return res;
    	   } 	
    	   helper(root);
    	   return res;
    }
    public void helper(Node root) {
    	List<Node> children = root.children;
    	for(int i = 0;i<children.size();i++) {
    		Node temp = children.get(i);
    		helper(temp);
    	}
    	res.add(root.val);
    }
}