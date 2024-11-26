package hust.soict.dsai.lab01;
import java.util.Scanner;
import java.util.Arrays;

public class AddTwoMatrices {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Chuong trinh tinh tong 2 ma tran cung kich co");
		System.out.print("Nhap so hang va cot cua ma tran: ");
		int n = keyboard.nextInt(); 
		int m = keyboard.nextInt(); 
		
		System.out.println("Nhap ma tran 1: ");
		int[][] matrix1 = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix1[i][j] = keyboard.nextInt();
			}
		}
		
		System.out.println("Nhap ma tran 2: ");
		int[][] matrix2 = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				matrix2[i][j] = keyboard.nextInt();
			}
		}
		
		int[][] sumMatrix = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
			}
		}
		
		System.out.println("Tong 2 ma tran la:");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(sumMatrix[i][j] + "\t");
			}
			System.out.println();
		}
	}

}
