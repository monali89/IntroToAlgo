package chp15;

import java.util.Random;

public class ITA_15_2_MatrixMultiplication {

	public static void main(String[] args) {
		
		int[][] m1 = new int[3][3];
		m1 = fillMatrix(m1, 1, 9);
		System.out.println("M1");
		printMatrix(m1);
		
		int[][] m2 = new int[3][2];
		m2 = fillMatrix(m2, 1, 9);
		System.out.println("M2");
		printMatrix(m2);
		
		
	}
	
	public static int[][] matrixMultiply(int[][] a, int[][] b){
		return null; 
	}
	
	public static int RandomBetween(int min, int max){
		Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
	}
	
	public static int[][] fillMatrix(int[][] m, int min, int max){
		for(int i=0; i<m.length; i++){
			for(int j=0; j<m[0].length; j++){
				m[i][j] = RandomBetween(min, max);
			}
		}
		return m;
	}
	
	public static void printMatrix(int[][] m){
		for(int i=0; i<m.length; i++){
			for(int j=0; j<m[0].length; j++){
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}
