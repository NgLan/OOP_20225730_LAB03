package hust.soict.dsai.lab01;
import javax.swing.JOptionPane;
public class Calculate2DoubleNumbers {

	public static void main(String[] args) {
		String strNum1, strNum2;
		strNum1 = JOptionPane.showInputDialog(null, 
				"Please input the first number: ", "Input the first number", 
				JOptionPane.INFORMATION_MESSAGE);
		strNum2 = JOptionPane.showInputDialog(null, 
				"Please input the second number: ", "Input the second number", 
				JOptionPane.INFORMATION_MESSAGE);
		
		double num1 = Double.parseDouble(strNum1);
		double num2 = Double.parseDouble(strNum2);
		
		String strNotification = "Sum of " + num1 + " and " + num2 + " is " + (num1 + num2) + "\n" + 
		"Difference of " + num1 + " and " + num2 + " is " + (num1 - num2) + "\n" +
		"Product of " + num1 + " and " + num2 + " is " + (num1 * num2) + "\n" +
		"Quotient of " + num1 + " and " + num2 + " is " + (num1 / num2);

		JOptionPane.showMessageDialog(null, strNotification, 
				"Calculate of 2 double numbers", JOptionPane.INFORMATION_MESSAGE);
	}

}
