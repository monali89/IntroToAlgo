package all;

public class DP_RodCutting {

	private static int[] r;
	
	public static void main(String[] args) {

		//System.out.println(cutRod(new int[]{1,5,8,9,10,17,17,20,24,30}, 4));
		///System.out.println(memoizedCutRod(new int[]{1,5,8,9,10,17,17,20,24,30}, 4));
		System.out.println(bottomupCutRod(new int[]{1,5,8,9,10,17,17,20,24,30}, 4));
	}
	
	public static int cutRod(int[] prices, int length){
		System.out.println("RUNNING");
		for(int i=0; i< prices.length; i++){
			System.out.print(prices[i] + " ");
		}
		System.out.println();
		System.out.println("Length - " + length);
		if(length == 0){
			return 0;
		}else{
			int max_price = 0;
			for(int i=0; i<prices.length; i++){
				max_price = Math.max(max_price, prices[i] + cutRod(prices, length-i));
			}
			System.out.println("Max Price - " + max_price);
			return max_price;
		}
	}
	
	public static int memoizedCutRod(int[] prices, int length){
		
		r = new int[prices.length];
		for(int i=0; i<r.length; i++){
			r[i] = 0;
		}
		return memoizedCutRodAux(prices, length);
	}
	
	public static int memoizedCutRodAux(int[] prices, int length){
		System.out.println("RUNNING");
		for(int i=0; i< prices.length; i++){
			System.out.print(prices[i] + " ");
		}
		System.out.println();
		for(int i=0; i< r.length; i++){
			System.out.print(r[i] + " ");
		}
		System.out.println();
		System.out.println("Length - " + length);
		int max_price = 0;
		if(length <= 0){
			max_price = 0;
		}else{
			if(r[length-1] > 0){
				System.out.println("Returning - " + r[length-1]);
				return r[length-1];
			}else{
					for(int i=0; i<prices.length; i++){
						System.out.println("Calling function from for loop");
						max_price = Math.max(max_price, prices[i] + memoizedCutRodAux(prices, length-i+1));
						System.out.println("Max Price - " + max_price);
					}
					r[length-1] = max_price;
				
			}
		}
		
		System.out.println("Returning - " + max_price);
		return max_price;
	}
	
	public static int bottomupCutRod(int[] p, int n){
		
		int[] r2 = new int[p.length];
		for(int i=0; i<r2.length; i++){
			r2[i] = 0;
		}
		int max = 0;
		for(int j=0; j<n; j++){
			System.out.println("DEBUG: Calculating for lengh - " + (j+1));
			for(int i=0; i<j; i++){
				System.out.println("p[" + i + "]: " + p[i] + "   r2[" + (j-i) + "]: " + r2[j-i] + "   Max: " + max);
				max = Math.max(max, p[i]+r2[j-i]);
			}
			System.out.println("For length " + (j+1) + ", max price is " + max);
			r2[j] = max;
		}
		return max;
	}

}
