package chp06;

public class ITA_6_4_HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int getHeapSize(int[] a){
		return a.length;
	}
	
	public int getParent(int i){
		return i/2;
	}
	
	public int getLeft(int i){
		return 2*i;
	}
	
	public int getRight(int i){
		return (2*i)+1;
	}
	
	public void maxHeapify(int[] a, int i){
		int left = getLeft(i);
		int right = getRight(i);
		int largest;
		if(left<getHeapSize(a) && a[left]>a[i]){
			largest = left;
		}else{
			largest = i;
		}
		if(right<getHeapSize(a) && a[right]>a[i]){
			largest = right;
		}else{
			largest = i;
		}
		if(largest != i){
			int temp = a[i];
			a[i] = a[largest];
			a[largest] = temp;
			maxHeapify(a, largest);
		}else{
			return;
		}
	}

	public void buildMaxHeap(int[] a){
		for(int i=a.length/2; i>-1; i--){
			maxHeapify(a,i);
		}
	}
	
	public void maxHeapInsert(){
		
	}
	
	public void heapSort(int[] a){
		buildMaxHeap(a);
		for(int i=a.length-1; i>-1; i++){
			int temp = a[i];
			a[i] = a[0];
			a[0] = temp;
			maxHeapify(a, 0);
		}
	}
}
