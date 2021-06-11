package DFS;

public class Solution700 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(4);
		TreeNode l = new TreeNode(2);
		TreeNode r = new TreeNode(7);
		TreeNode ll = new TreeNode(1);
		TreeNode lr = new TreeNode(3);
		root.left = l;
		root.right = r;
		l.left = ll;
		l.right = lr;
		
		dfsSolution700 s = new dfsSolution700();
		TreeNode res = s.searchBST(root, 5);
		System.out.println("完成");
	}

}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class dfsSolution700 {
    public TreeNode searchBST(TreeNode root, int val) {
    	if(root != null) {
    		if(root.val>val) {
    			//如果此时的节点值大于要寻找的值，则寻找此节点的左子节点
    			return searchBST(root.left,val);
    		}else if(root.val<val){
    			//如果节点值小于要寻找的val，则寻找其右子节点
    			return searchBST(root.right,val);
    		}else if(root.val == val){
    			//如果相等
    			return root;
    		}
    	}
    	return null;
    }
}