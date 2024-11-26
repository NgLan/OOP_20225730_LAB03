package hust.soict.dsai.lab01;
import java.util.Scanner;
import java.util.Arrays;
public class SortArray {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Nhap so phan tu cua mang: ");
		int n = keyboard.nextInt(); 
		
		System.out.println("Nhap mang: ");
		int[] arr = new int[n];
		int sum = 0; double average;
		for (int i = 0; i < n; i++) {
			arr[i] = keyboard.nextInt();
			sum += arr[i];
		}
		average = sum/n;
		
		Arrays.sort(arr);
		System.out.println("Mang sau khi sap xep: ");
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("\nTong cac phan tu cua mang la: " + sum);
		System.out.println("Trung binh cac phan tu cua mang la: " + average);
	}

}
