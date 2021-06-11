package hot100;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		//��������
		int arr[] = {4,6,8,5,9};
		heapSort(arr);
	}
	//	��дһ��������ķ���
	public static void heapSort(int arr[]) {
		System.out.println("������");
		int temp = 0;
		//�ֲ����
//		adjustHeap(arr,1,arr.length);
//		System.out.println("��һ�Σ�"+Arrays.toString(arr));
//		adjustHeap(arr,0,arr.length);
//		System.out.println("�ڶ��Σ�"+Arrays.toString(arr));
		//������մ���
		for(int i = arr.length/2-1;i>=0;i--) {
			adjustHeap(arr,i,arr.length);
		}
		for(int j = arr.length-1;j>0;j--) {
			//����
			temp = arr[j];
			arr[j] = arr[0];
			arr[0] = temp;
			adjustHeap(arr,0,j);
		}
		System.out.println(Arrays.toString(arr));
		
	}
	//��һ������(������),������һ���󶥶�
	//int arr[] ������������ i��ʾ��Ҷ�ӽڵ㣬length ��ʾ�Զ��ٸ�Ԫ�ؽ��е���
	public static void adjustHeap(int arr[],int i,int length) {
		//��ȡ����ǰԪ�ص�ֵ����������ʱ������
		int temp = arr[i];
		for(int k = i*2+1;k<length;k = k*2+1) {
			//kΪ���ӽڵ�
			if(k+1<length &&arr[k]<arr[k+1]) {
				//˵��������ӽڵ��ֵС�����ӽڵ��ֵ
				k++;//k��ָ�����ӽڵ�
			}
			if(arr[k]>temp) {
				//����ӽڵ���ڸ��ڵ�
				//��˳��
				arr[i] = arr[k];
				i = k;//iָ��kѭ���Ƚ�
			}else {
				break;
			}
			
		}
		//��forѭ������֮�������Ѿ�����iΪ���ڵ���������ֵ�����������
		arr[i] = temp;
		//��Temp�ŵ��������λ��
	}
}
