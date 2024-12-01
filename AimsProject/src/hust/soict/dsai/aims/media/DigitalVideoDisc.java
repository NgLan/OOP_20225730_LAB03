package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc {
	private static int nbDigitalVideoDiscs = 0;
	
	public DigitalVideoDisc(String title) {
		super(incID(), title);
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super(incID(), title, category, cost);
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(incID(), title, category, director, cost);
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(incID(), title, category, director, length, cost);
	}
	
	private static int incID() {
		return nbDigitalVideoDiscs++;
	}
	
	public boolean isMatch(String title) {
		if (this.getTitle() == title) return true;
		else return false;
	}

	@Override
	public String toString() {
		return this.getId() + ". DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - "
				+ this.getLength() + ": " + this.getCost() + "$";
	}
}