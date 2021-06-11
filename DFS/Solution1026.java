package DFS;

public class Solution1026 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(8);
		
		TreeNode l = new TreeNode(3);
		TreeNode r = new TreeNode(10);
		
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(6);
		TreeNode t4 = new TreeNode(14);
		
		TreeNode f3 = new TreeNode(4);
		TreeNode f4 = new TreeNode(7);
		TreeNode f7 = new TreeNode(13);
		
		root.left = l;
		root.right = r;
		
		l.left = t1;
		l.right = t2;
		
		r.right = t4;
		
		t2.left = f3;
		t2.right = f4;
		t4.left = f7;
		dfsSolution1026 s = new dfsSolution1026();
		int res = s.maxAncestorDiff(root);
		System.out.println(res);
	}

}
class dfsSolution1026 {
    //����𰸴�ŵ�ַ
    int max = 0;
    public int maxAncestorDiff(TreeNode root) {
        //������ȱ�����������root��ֵ��ȥ������������������ӽڵ��ֵ��Ȼ�󱣴����ľ���ֵ�max��
        //������������Ҫ���䣬���Ҫ�������нڵ�
        midOrder(root);
        return max;
    }
    public void midOrder(TreeNode node){
        dfs(node,node.val);
        if(node.left != null){
            midOrder(node.left);
        }
        if(node.right !=null){
            midOrder(node.right);
        }
    }
    //���dfsֻ����һ��node�µ����нڵ�ľ���ֵ
    public void dfs(TreeNode node,int value){
        max = Math.max(Math.abs(value-node.val),max);
        if(node.left!=null){
            dfs(node.left,value);
        }
        if(node.right!=null){
            dfs(node.right,value);
        }
    }
}