package hot100;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		//升序排列
		int arr[] = {4,6,8,5,9};
		heapSort(arr);
	}
	//	编写一个堆排序的方法
	public static void heapSort(int arr[]) {
		System.out.println("堆排序");
		int temp = 0;
		//分布完成
//		adjustHeap(arr,1,arr.length);
//		System.out.println("第一次："+Arrays.toString(arr));
//		adjustHeap(arr,0,arr.length);
//		System.out.println("第二次："+Arrays.toString(arr));
		//完成最终代码
		for(int i = arr.length/2-1;i>=0;i--) {
			adjustHeap(arr,i,arr.length);
		}
		for(int j = arr.length-1;j>0;j--) {
			//交换
			temp = arr[j];
			arr[j] = arr[0];
			arr[0] = temp;
			adjustHeap(arr,0,j);
		}
		System.out.println(Arrays.toString(arr));
		
	}
	//将一个数组(二叉树),调整成一个大顶堆
	//int arr[] 待调整的数组 i表示非叶子节点，length 表示对多少个元素进行调整
	public static void adjustHeap(int arr[],int i,int length) {
		//先取出当前元素的值，保存在临时变量中
		int temp = arr[i];
		for(int k = i*2+1;k<length;k = k*2+1) {
			//k为左子节点
			if(k+1<length &&arr[k]<arr[k+1]) {
				//说明这个左子节点的值小于右子节点的值
				k++;//k就指向右子节点
			}
			if(arr[k]>temp) {
				//如果子节点大于父节点
				//调顺序
				arr[i] = arr[k];
				i = k;//i指向k循环比较
			}else {
				break;
			}
			
		}
		//当for循环结束之后，我们已经将以i为父节点的树的最大值，放在了最顶上
		arr[i] = temp;
		//将Temp放到调整后的位置
	}
}
