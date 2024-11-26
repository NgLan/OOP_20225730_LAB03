import java.util.ArrayList;

public class Store {
	private ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<>();
	public void addDVD(DigitalVideoDisc disc) {
		itemsInStore.add(disc);
	}
	
	public void removeDVD(DigitalVideoDisc disc) {
		itemsInStore.remove(disc);
	}

	public void print() {
		for (DigitalVideoDisc disc : itemsInStore) {
			System.out.println(disc.toString());
		}
	}
}
