package TreeNodeProblem;
//����һ�������ظ�Ԫ�ص��������� nums ��
//һ���Դ�����ֱ�ӵݹ鹹���� �������� 
public class Solution654 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,2,1};
		TreeSolution654 res = new TreeSolution654();
		TreeNode root = res.constructMaximumBinaryTree(nums);
		System.out.println("���");
	}

}
class TreeSolution654 {
	//1 <= nums.length <= 1000
	//0 <= nums[i] <= 1000,�ز�Ϊ����
    public TreeNode constructMaximumBinaryTree(int[] nums) {
    	//�õ�����������ֵ�����������ҷֳ�����������
    	int[] res = findMaxval(nums);
    	int max = res[0];
    	int index = res[1];
    	TreeNode root = new TreeNode(max);
    	if(nums.length == 1) {
    		return root;
    	}
    	int[] left = chaiShuZuZuo(nums,index);
    	int[] right = chaiShuZuYou(nums,index);
    	if(left.length>0) {
    		root.left = constructMaximumBinaryTree(left);
    	}
    	if(right.length>0) {
    		root.right = constructMaximumBinaryTree(right);
    	}
    	return root;
    }
    public int[] findMaxval(int[] nums) {
    	int max = -1;
    	int index = 0;
    	for(int i = 0;i<nums.length;i++) {
    		if(nums[i]>max) {
    			max = nums[i];
    			index = i;
    		}
    	}
    	int[] res = new int[2];
    	res[0] = max;
    	res[1] = index;
    	return res;
    }
    public int[] chaiShuZuZuo(int[] nums,int index) {
    	int[] res  =new int[index];
    	for(int i =0;i<index;i++) {
    		res[i] = nums[i];
    	}
    	return res;
    }
    public int[] chaiShuZuYou(int[] nums,int index) {
    	int[] res  =new int[nums.length-index-1];
    	for(int i =index+1;i<nums.length;i++) {
    		res[i-index-1] = nums[i];
    	}
    	return res;
    }
}