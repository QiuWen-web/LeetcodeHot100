package TreeNodeProblem;

import java.util.List;
//N ²æÊ÷µÄ²ãÊý
public class Solution559 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class TreeSolution559 {
    public int maxDepth(Node root) {
        int res = 0;
        if(root == null){
            return 0;
        }
        List<Node> children = root.children;
        for(int i = 0;i<children.size();i++){
            res = Math.max(maxDepth(children.get(i)),res);
        }
        return res+1;
    }
}