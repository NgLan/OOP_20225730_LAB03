package hust.soict.dsai.aims.store;


import java.util.ArrayList;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}

	public void addMedia(Media...medias) {
		for (Media m : medias) {
			if (itemsInStore.contains(m)) {
				System.out.println(m.getTitle() + " is already in the store");
			} else {
				itemsInStore.add(m);
				System.out.println(m.getTitle() + " has been added to the store");
			}
		}
	}
	
	public void removeMedia(Media...medias) {
		for (Media m : medias) {
			if (itemsInStore.contains(m)) {
				itemsInStore.remove(m);
				System.out.println(m.getTitle() + " has been removed from the store");
			} else {
				System.out.println(m.getTitle() + " is not in the store");
			}
		}
	}
	
	public Media search(String title) {
		for (Media m : itemsInStore) {
			if (m.isMatch(title)) {
				return m;
			}
		}
		return null;
	}

	public void print() {
		System.out.println("***********************STORE***********************");
		System.out.println("Items in store:");
		int i = 0;
		for (Media m : itemsInStore) {
			System.out.println((++i) + ". " + m.toString());
		}
		System.out.println("***************************************************");
	}
}
