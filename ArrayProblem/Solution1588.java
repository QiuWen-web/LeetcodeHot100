package ArrayProblem;

public class Solution1588 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10,11,12};
		ArraySolution1558 s = new ArraySolution1558();
		System.out.println(s.sumOddLengthSubarrays(arr));
	}

}
class ArraySolution1558 {
    public int sumOddLengthSubarrays(int[] arr) {
    	int len = arr.length;
    	int sum = 0;
    	//������ʼ�����
    	for(int i = 0;i<len;i++) {
    		//�趨�����ĳ���
    		for(int templen = 1+i;templen<=len;templen += 2) {
    			//����������ֵ���ܺ�
        		for(int j = i; j < templen;j++) {
        			sum += arr[j];
        		}
    		}

    	}
    	return sum;
    }
}