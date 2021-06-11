package TreeNodeProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution655 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m = 4;
    	int n = 1;
    	for(int i = 1;i<m;i++) {
    		n += 2<<(i-1);
    	}
    	System.out.println(m);
    	System.out.println(n);
	}

}
class TreeSolution655 {
	public List<List<String>> printTree(TreeNode root) {
		//�õ��������
        int height = getHeight(root);
        String[][] res = new String[height][(1 << height) - 1];
        //�õ�����
        for(String[] arr:res)
            Arrays.fill(arr,"");
        //��ÿһ��Ԫ����Ϊ"";
        //�½�һ���������
        List<List<String>> ans = new ArrayList<>();
        //�ݹ���䣬�ڵ�0�е�0-res[0].length�����root��ֵ
        fill(res, root, 0, 0, res[0].length);
        //�������ת������Ҫ����ʽ����
        for(String[] arr:res)
            ans.add(Arrays.asList(arr));
        return ans;
    }
    public void fill(String[][] res, TreeNode root, int i, int l, int r) {
        //���rootΪnull����
    	if (root == null)
            return;
    	//���µ�i�е�j��Ϊroot��ֵ��
        res[i][(l + r) / 2] = "" + root.val;
        //�ݹ����root.left��root.right������������
        fill(res, root.left, i + 1, l, (l + r) / 2);
        fill(res, root.right, i + 1, (l + r + 1) / 2, r);
    }
    //������ȴ���
    public int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}