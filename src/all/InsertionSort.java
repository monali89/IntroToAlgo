package all;

public class InsertionSort {

	public static void main(String[] args) {
		
		final long startTime = System.nanoTime();
		
		int[] inputArray = {2,7,9,1,3};
		int[] returnedArray = sort(inputArray);
		
		final long duration = System.nanoTime() - startTime;
		System.out.println(duration);
		
		for(int i=0; i<returnedArray.length; i++){
			System.out.println(returnedArray[i]);
		}

	}
	
	public static int[] sort(int[] arr){
		
		int key;
		for(int j=1; j<arr.length; j++){
			key = arr[j];
			int i;
			i = j-1;
			while(i>=0 && arr[i]>key){
				arr[i+1] = arr[i];
				i = i-1;
			}
			arr[i+1] = key;
		}
		return arr;
	}

}
