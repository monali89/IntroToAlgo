package all;

public class MergeSort {

	public static void main(String[] args) {
		
	}
	
	public void mergeSort(int[] array){
		mergeSort(array, 0, array.length-1);
	}
	
	public void mergeSort(int[] array, int leftStart, int rightEnd){
		int middle = (leftStart + rightEnd)/2;
		mergeSort(array, leftStart, middle);
		mergeSort(array, middle+1, rightEnd);
		
	}
	

}
