package hust.soict.dsai.aims.media;

public class Track implements Playable {
	private String title;
	private int length;

	public Track() {
		// TODO Auto-generated constructor stub
	}

	public Track(String title, int length) {
		super();
		this.title = title;
		this.length = length;
	}

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Track) {
			Track trk = (Track) obj;
			if (this.getTitle().equals(trk.title) && (this.getLength() == trk.length)) return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "Track - " + this.getTitle() + " - " + this.getLength();
	}
}
