package hust.soict.dsai.garbage;

import java.io.File;  
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NoGarbage {

	public static void main(String[] args) {
		try {
			File f = new File("D:\\OOP_20225730_LAB03\\OtherProjects\\src\\hust\\soict\\dsai\\garbage\\test.txt");
			Scanner reader = new Scanner(f);
			StringBuilder data = new StringBuilder();
			long start = System.currentTimeMillis();
			while (reader.hasNextLine()) {
				data.append(reader.nextLine()).append('\n');
			}
			System.out.println(System.currentTimeMillis() - start);
			reader.close();
	    } catch (FileNotFoundException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	    }
	}

}
