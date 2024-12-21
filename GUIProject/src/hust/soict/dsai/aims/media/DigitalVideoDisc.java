package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	private static int nbDigitalVideoDiscs = 0;
	
	public DigitalVideoDisc() {
		
	}
	
	public DigitalVideoDisc(String title) {
		super(title);
		nbDigitalVideoDiscs++;
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
		nbDigitalVideoDiscs++;
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
		nbDigitalVideoDiscs++;
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
	}
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}

	@Override
	public String toString() {
		return "DVD - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - "
				+ this.getLength() + ": " + this.getCost() + "$";
	}
}
