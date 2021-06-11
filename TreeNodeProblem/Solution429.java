package TreeNodeProblem;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution429 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
class TreeSolution429 {
    public List<List<Integer>> levelOrder(Node root) {
    	List<List<Integer>> res = new ArrayList<>();
    	if(root == null) {
    		return res;
    	}
    	Deque<Node> nodes = new LinkedList<>();
    	nodes.add(root);
    	while(!nodes.isEmpty()) {
    		int size = nodes.size();
    		List<Integer> item = new ArrayList<>();
    		while(size-->0) {
    			Node node = nodes.removeFirst();
    			item.add(node.val);
    			List<Node> child = node.children;
    			for(int i = 0;i<child.size();i++) {
    				nodes.add(child.get(i));
    			}
    		}
    		res.add(item);
    	}
    	return res;
    }
}