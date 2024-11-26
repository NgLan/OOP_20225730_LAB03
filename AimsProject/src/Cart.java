import java.util.ArrayList;

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

