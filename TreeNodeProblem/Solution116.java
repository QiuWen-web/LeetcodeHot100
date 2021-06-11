package TreePackage;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
//²ãÐò±éÀú¸Ä°æ
public class Solution116 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
class TreeSolution116 {
    public Node connect(Node root) {
        Deque<Node> list = new LinkedList<>();
        if(root == null) {
        	return root;
        }
        list.add(root);
        while(!list.isEmpty()) {
    		int size = list.size();
    		List<Node> item = new LinkedList<>();
    		while(size>0) {
    			Node node = list.removeFirst();
    			item.add(node);
    			if(node.left != null) {
    				list.add(node.left);
    			}
    			if(node.right != null) {
    				list.add(node.right);
    			}
    			size--;
    		}
    		for(int i = 0;i<item.size();i++) {
    			if(i == item.size()-1) {
    				item.get(i).next = null;
    			}else {
    				item.get(i).next = item.get(i+1);
    			}    			
    		}
    	}
        return root;
    }
}