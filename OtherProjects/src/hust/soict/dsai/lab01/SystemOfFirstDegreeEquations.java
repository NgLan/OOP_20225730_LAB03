package hust.soict.dsai.lab01;
import java.util.Scanner;
public class SystemOfFirstDegreeEquations {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Chuong trinh giai he phuong trinh bac nhat 2 an dang\na1x + b1y = c1\na2x + b2y = c2");
		
		double a1, b1, c1, a2, b2, c2;
		System.out.print("Nhap he so pt 1: ");
		a1 = scan.nextDouble();
		b1 = scan.nextDouble();
		c1 = scan.nextDouble();
		System.out.print("Nhap he so pt 2: ");
		a2 = scan.nextDouble();
		b2 = scan.nextDouble();			
		c2 = scan.nextDouble();
		double D = a1*b2 - a2*b1;
		double D1 = c1*b2 - c2*b1;
		double D2 = a1*c2 - a2*c1;
		if (D != 0) {
			System.out.println("He pt co nghiem duy nhat:\nx1 = " + (D1/D) + "\nx2 = " + (D2/D));	
		} else if (D1 == 0 && D2 == 0) {
			System.out.println("He pt co vo so nghiem");
		} else {
			System.out.println("He pt vo nghiem");
		}
	}

}
