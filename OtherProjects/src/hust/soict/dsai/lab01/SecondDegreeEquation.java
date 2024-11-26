package hust.soict.dsai.lab01;
import java.util.Scanner;
public class SecondDegreeEquation {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Chuong trinh giai phuong trinh bac hai dang ax^2 + bx + c = 0 (a != 0)");
		
		double a, b, c;		
		do {
			System.out.print("Nhap a: ");
			a = scan.nextDouble();
			if (a == 0) System.out.println("Ban nhap a = 0, xin hay nhap lai!");
		} while (a == 0);
		System.out.print("Nhap b: ");
		b = scan.nextDouble();
		System.out.print("Nhap c: ");
		c = scan.nextDouble();
		
		double delta = b*b - 4*a*c;
		if (delta > 0) {
			System.out.println("Pt co 2 nghiem phan biet:\nx1 = " + (-b + Math.sqrt(delta))/(2*a) + 
					"\nx2 = " + (-b - Math.sqrt(delta))/(2*a));	
		} else if (delta == 0) {
			System.out.println("Pt co nghiem kep: x = " + (-b/(2*a)));
		} else {
			System.out.println("Pt vo nghiem");
		}
	}

}
