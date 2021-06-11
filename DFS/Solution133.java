package DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution133 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
class DFSSolution133 {
    private HashMap <Node, Node> visited = new HashMap <> ();
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        // ����ýڵ��Ѿ������ʹ��ˣ���ֱ�Ӵӹ�ϣ����ȡ����Ӧ�Ŀ�¡�ڵ㷵��
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // ��¡�ڵ㣬ע�⵽Ϊ��������ǲ����¡�����ھӵ��б�
        Node cloneNode = new Node(node.val, new ArrayList());
        // ��ϣ��洢
        visited.put(node, cloneNode);

        // �����ýڵ���ھӲ����¿�¡�ڵ���ھ��б�
        for (Node neighbor: node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }
}