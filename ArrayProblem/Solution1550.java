package ArrayProblem;

public class Solution1550 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,34,3,4,5,7,23,12};
		ArraySolution1550 s = new ArraySolution1550();
		System.out.println(s.threeConsecutiveOdds(arr));
	}

}
class ArraySolution1550 {
    public boolean threeConsecutiveOdds(int[] arr) {
    	int len = arr.length;
    	int i = 0 ;
    	
    	while(i<len-2) {
    		//���iλ�õ�ֵΪż��
    		if(arr[i] % 2 == 0) {
    			i++;
    		}else {
    			//iλ�õ�ֵΪ����
    			int j = i + 1;
    			if(arr[j] % 2 == 0) {
    				//����ڶ�����Ϊż��
    				i = i + 2;
    			}else {
    				//����ڶ�����Ϊ����
    				int k = j + 1;
    				if(arr[k] % 2 == 0) {
    					//�����������Ϊż��
    					i = i + 3;
    				}else {
    					//�����������Ϊ����
    					return true;
    				}
    			}
    		}
    	}
    	return false;
    }
}