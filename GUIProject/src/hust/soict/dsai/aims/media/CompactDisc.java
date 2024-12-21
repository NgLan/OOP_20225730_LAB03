package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<>();

	public CompactDisc() {
		// TODO Auto-generated constructor stub
	}

	public CompactDisc(String title, String category, String director, int length, float cost, String artist,
			ArrayList<Track> tracks) {
		super(title, category, director, length, cost);
		this.artist = artist;
		this.tracks = tracks;
	}

	public String getArtist() {
		return artist;
	}
	
	@Override
	public int getLength() {
		int CDLength = 0;
		for (Track trk : tracks) {
			CDLength += trk.getLength();
		}
		return CDLength;
	}

	public void addTrack(Track trk) {
		if (tracks.contains(trk)) 
			System.out.println(trk.getTitle() + " is already exists");
		else 
			tracks.add(trk);
	}
	
	public void removeTrack(Track trk) {
		if (tracks.contains(trk)) 
			tracks.remove(trk);
		else 
			System.out.println(trk.getTitle() + " is not exists");
	}
	
	public void play() {
		System.out.println("Playing CD: " + this.getTitle());
		System.out.println("Artist: " + this.getArtist());
		for (Track trk : tracks) {
			trk.play();
		}
	}
	
	@Override
	public String toString() {
		String result = "CD - " + this.getTitle() + " - " + this.getArtist() + " - " + this.getCategory() + " - " + this.getDirector() + 
				" - " + this.getLength() + ": " + this.getCost() + "$";
		for (Track trk : tracks) {
			result += "\n\t" + trk.toString();
		}
		return result;
	}
	
	
}
