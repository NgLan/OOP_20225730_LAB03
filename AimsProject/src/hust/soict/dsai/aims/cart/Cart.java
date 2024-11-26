package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<DigitalVideoDisc> itemsOrdered = new ArrayList<>();
	private int qtyOrdered;
	
	public int getQtyOrdered() {
		return qtyOrdered;
	}

	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered.add(disc);
			qtyOrdered++;
			System.out.println("The disc " + disc.getTitle() + " has been added");
		} else {
			System.out.println("The cart is almost full");
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		for (DigitalVideoDisc disc : dvdList) {
			if (qtyOrdered < MAX_NUMBERS_ORDERED) {
				itemsOrdered.add(disc);
				qtyOrdered++;
				System.out.println("The disc " + disc.getTitle() + " has been added");
			} else {
				System.out.println("The cart is almost full");
				break;
			}
		}
	}
	
	public void addDigitalVideoDiscVarArgs(DigitalVideoDisc... dvds) {
		for (DigitalVideoDisc disc : dvds) {
			if (qtyOrdered < MAX_NUMBERS_ORDERED) {
				itemsOrdered.add(disc);
				qtyOrdered++;
				System.out.println("The disc " + disc.getTitle() + " has been added");
			} else {
				System.out.println("The cart is almost full");
				break;
			}
		}
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		addDigitalVideoDisc(dvd1);
		addDigitalVideoDisc(dvd2);
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		itemsOrdered.remove(disc);
		qtyOrdered--;
	}
	
	public float totalCost() {
		float sum = 0;
		for (DigitalVideoDisc disc : itemsOrdered) {
			sum += disc.getCost();
		}
		return sum;
	}
	
	public void search(int id) {
		boolean isFound = false;
		for (DigitalVideoDisc disc : itemsOrdered) {
			if (disc.getId() == id) {
				System.out.println(disc.toString());
				isFound = true;
			}
		}
		if (!isFound) System.out.println("No match is found");
	}
	
	public void search(String title) {
		boolean isFound = false;
		for (DigitalVideoDisc disc : itemsOrdered) {
			if (disc.isMatch(title)) {
				System.out.println(disc.toString());
				isFound = true;
			}
		}
		if (!isFound) System.out.println("No match is found");
	}
	
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		for (DigitalVideoDisc disc : itemsOrdered) {
			System.out.println(disc.toString());
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("***************************************************");
	}	
}

