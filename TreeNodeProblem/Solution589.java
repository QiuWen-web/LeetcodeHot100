package TreeNodeProblem;
// N²æÊ÷µÄÇ°Ðò±éÀú
import java.util.ArrayList;
import java.util.List;

public class Solution589 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class TreeSolution589 {
	private List<Integer> res = new ArrayList<>();
    public List<Integer> preorder(Node root) {
    	   if(root == null) {
    		   return res;
    	   } 	
    	   helper(root);
    	   return res;
    }
    public void helper(Node root) {
    	res.add(root.val);
    	List<Node> children = root.children;
    	for(int i = 0;i<children.size();i++) {
    		Node temp = children.get(i);
    		helper(temp);
    	}
    }
}