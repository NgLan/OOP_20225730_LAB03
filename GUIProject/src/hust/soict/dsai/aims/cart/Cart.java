package hust.soict.dsai.aims.cart;

import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

	public void clear() {
		itemsOrdered.clear();
	}
	
	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public ObservableList<Media> getMediaList() {
	    return itemsOrdered;
	}
	
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
	
	public Media search(int id) {
		for (Media m : itemsOrdered) {
			if (m.getId() == id) {
				return m;
			}
		}
		return null;
	}
	
	public Media search(String title) {
		for (Media m : itemsOrdered) {
			if (m.isMatch(title)) {
				return m;
			}
		}
		return null;
	}
	
	public int countDVD() {
		int count = 0;
		for (Media m : itemsOrdered) {
			if (m instanceof DigitalVideoDisc) 
				count++;
		}
		return count;
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

