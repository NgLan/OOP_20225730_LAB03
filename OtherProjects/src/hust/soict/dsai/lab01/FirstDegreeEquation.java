package hust.soict.dsai.lab01;
import java.util.Scanner;
public class FirstDegreeEquation {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Chuong trinh giai phuong trinh bac nhat dang ax + b = 0 (a != 0)");
		
		double a;
		do {
			System.out.print("Nhap a: ");
			a = scan.nextDouble();
			if (a == 0) {
				System.out.println("Ban nhap a = 0, xin hay nhap lai!");
			}
		} while (a == 0);
		
		System.out.print("Nhap b: ");
		double b = scan.nextDouble();
		
		System.out.println("Nghiem cua phuong trinh " + a + "x + " + b + " = 0 " + "la:\nx = " + (-b/a));
	}

}
