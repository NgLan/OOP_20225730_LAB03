package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Media {
	private String director;
	private int length;
	private static int nbDigitalVideoDiscs = 0;
	
	public DigitalVideoDisc() {}
	
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}

	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public boolean isMatch(String title) {
		if (this.title == title) return true;
		else return false;
	}

	@Override
	public String toString() {
		return id + ". DVD - " + title + " - " + category + " - " + director + " - "
				+ length + ": " + cost + "$";
	}
}
