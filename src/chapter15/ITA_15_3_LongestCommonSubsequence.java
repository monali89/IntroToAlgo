package chapter15;

public class ITA_15_3_LongestCommonSubsequence {
	
	//private static char[] c1;
	//private static char[] c2;
	private static int[][] c;
	private static char[][] b;

	public static void LCSLength(char[] c1, char[] c2){
		int m = c1.length;
		int n = c2.length;
		c = new int[m][n];
		b = new char[m][n];
		for(int i=0; i<m; i++){
			c[i][0] = 0;
		}
		for(int j=0; j<n; j++){
			c[0][j] = 0;
		}
		for(int i=1; i<m; i++){
			for(int j=1; j<n; j++){
				if(c1[i] == c2[j]){
					c[i][j] = c[i][j] + 1;
					b[i][j] = 'D';
				}else{
					if(c[i-1][j]>=c[i][j-1]){
						c[i][j] = c[i-1][j];
						b[i][j] = 'U';
					}else{
						c[i][j] = c[i][j-1];
						b[i][j] = 'L';
					}
				}
			}
		}
		
		// TEMP
		for(int i=0; i<b.length; i++){
			for(int j=0; j<b[i].length; j++){
				System.out.print(b[i][j] + " ");
			}
			System.out.println();
		}
		for(int i=0; i<c.length; i++){
			for(int j=0; j<c[i].length; j++){
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}		
	}
	
	public static void printLCS(char[] x, int i, int j){
		if(i==0 || j==0){
			return;
		}else{
			if(b[i][j] == 'D'){
				printLCS(x, i-1, j-1);
				System.out.print(x[i] + " ");
			}else{
				if(b[i][j] == 'U'){
					printLCS(x, i-1, j);
				}else{
					printLCS(x, i, j-1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		String str1 = "ABCBDAB";
		String str2 = "BDCABA";
		LCSLength(str1.toCharArray(), str2.toCharArray());
		printLCS(str1.toCharArray(), str1.length()-1, str2.length()-1);
	}

}
