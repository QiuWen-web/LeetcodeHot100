package TreeNodeProblem;

public class Solution450 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		TreeNode rootl = new TreeNode(3);
		TreeNode rootr = new TreeNode(6);
		TreeNode rootll = new TreeNode(2);
		TreeNode rootlr = new TreeNode(4);
		TreeNode rootrr = new TreeNode(7);

		root.left = rootl;
		root.right = rootr;
		rootl.left = rootll;
		rootl.right = rootlr;
		rootr.right = rootrr;

		TreeSolution450 s = new TreeSolution450();
		TreeNode root1 = s.deleteNode01(root, 3);
		System.out.println(root1);
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
    public void print(TreeNode root) {
    	System.out.println(root.val);
    	if(root.left != null) {
    		print(root.left);
    	}
    	if(root.right != null) {
    		print(root.right);
    	}
    }
}
class TreeSolution450 {
	
	public TreeNode deleteNode(TreeNode root, int key) {
		//查询key对应的节点
		TreeNode root1 =root;
		TreeNode node = searchVal(root,key);
		if(node == null) {
			//没找到
			return root;
		}else {
			//得到node上一个节点
			TreeNode upnode = bian(root1,node);
			
			TreeNode newnode = change(node);	
			if(upnode.val > node.val) {
				upnode.left = newnode;
			}else {
				upnode.right = newnode;
			}
			return root1;
		}
    }
	public TreeNode bian(TreeNode root,TreeNode node) {
		if(root.val == node.val) {
			return null;
		}
		if(root.left.val == node.val || root.right.val == node.val) {
			return root;
		}else if(root.val>node.val){
			return bian(root.left,node);
		}else {
			return bian(root.right,node);
		}
		
	}
	public TreeNode searchVal(TreeNode node, int key) {
		if(node == null) {
			return null;
		}else if(key<node.val) {
			//key在root左子树中
			return searchVal(node.left,key);			
		}else if(key>node.val) {
			//key在root右子树中
			return searchVal(node.right,key);			
		}else {
			return node;
		}
	}
    public TreeNode deleteNode01(TreeNode root, int key) {
        //寻找root为根节点的树下面的节点 == key的节点
    	//将这个节点下面的子节点重新成为树
    	if(root == null) {
    		return null;
    	}
    	//要搜索的节点在root的左边
    	if(key<root.val) {
    		root.left =  deleteNode01(root.left,key);
    	}else if(key>root.val) {
    		root.right = deleteNode01(root.right,key);
    	}else {
    		if(root.left == null) {
    			return root.right;
    		}else if(root.right == null) {
    			return root.left;
    		}else {
    			return change(root);
    		}
    	}
    	return root;
    }
    //找到node，进行改变的方法
    public TreeNode change(TreeNode node) {
    	//先将node的右边存储起来
    	TreeNode right = node.right;
    	//将node。left上升到node位置
    	node = node.left;
    	//寻找node的最右边的节点
    	TreeNode leftright = lookFor(node);
    	leftright.right = right;
    	return node;
    }
    public TreeNode lookFor(TreeNode left) {
    	TreeNode res = left;
    	while(left.right != null) {
    		res = lookFor(left.right);
    		left = left.right;
    	}
    	return res;
    }
}