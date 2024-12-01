package hust.soict.dsai.aims.cart;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	public void addMedia(Media...medias) {
		for (Media m : medias) {
			if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
				itemsOrdered.add(m);
				System.out.println(m.getTitle() + " has been added to the cart");
			} else {
				System.out.println("The cart is almost full");
				break;
			}
		}
	}
	
	public void removeMedia(Media...medias) {
		for (Media m : medias) {
			if (itemsOrdered.contains(m)) {
				itemsOrdered.remove(m);
				System.out.println(m.getTitle() + " has been removed from the cart");
			} else {
				System.out.println(m.getTitle() + " is not in the cart");
			}
		}
	}
	
	public float totalCost() {
		float sum = 0;
		for (Media m : itemsOrdered) {
			sum += m.getCost();
		}
		return sum;
	}
	
	public void search(int id) {
		boolean isFound = false;
		for (Media m : itemsOrdered) {
			if (m.getId() == id) {
				System.out.println(m.toString());
				isFound = true;
				break;
			}
		}
		if (!isFound) System.out.println("No match is found");
	}
	
	public void search(String title) {
		boolean isFound = false;
		for (Media m : itemsOrdered) {
			if (m.isMatch(title)) {
				System.out.println(m.toString());
				isFound = true;
				break;
			}
		}
		if (!isFound) System.out.println("No match is found");
	}
	
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		int i = 0;
		for (Media m : itemsOrdered) {
			System.out.println((++i) + ". " + m.toString());
		}
		System.out.println("Total cost: " + totalCost());
		System.out.println("***************************************************");
	}	
}

