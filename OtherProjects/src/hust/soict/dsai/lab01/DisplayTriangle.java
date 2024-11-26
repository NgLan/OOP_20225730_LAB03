package hust.soict.dsai.lab01;
import java.util.Scanner;
import java.util.Arrays;
public class DisplayTriangle {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Nhap n: ");
		int n = keyboard.nextInt();
		
		String[] stars = new String[n];
		String[] spaces = new String[n];
		stars[0] = "*"; spaces[0] = "";
		
		for (int i = 1; i < n; i++) {
			stars[i] = stars[i-1] + "**";
			spaces[i] = spaces[i-1] + " ";
		}
		
		for (int i = 0; i < n; i++) {
			System.out.println(spaces[n-i-1] + stars[i] + spaces[n-i-1]);
		}
	}

}
