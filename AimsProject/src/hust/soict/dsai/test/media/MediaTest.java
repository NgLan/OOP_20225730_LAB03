package hust.soict.dsai.test.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Track;

public class MediaTest {
	
	public static void main(String[] args) {
		ArrayList<Track> tracks = new ArrayList<Track>();
		Track trk1 = new Track("abc", 10);
		Track trk2 = new Track("cde", 20);
		tracks.add(trk1);
		tracks.add(trk2);
		
		CompactDisc cd = new CompactDisc(1, "Aladin", "Animation", "Ai do", 10, 18.99f, "naknsanks", tracks);
		DigitalVideoDisc dvd = new DigitalVideoDisc("abc");
		
		ArrayList<String> authors = new ArrayList<String>();
		authors.add("Lan");
		authors.add("Ai do 2");
		
		Book book = new Book(1, "Aladin", "Animation", 18.99f, authors);
		
		List<Media> media = new ArrayList<Media>();
		media.add(cd);
		media.add(dvd);
		media.add(book);
		
		for(Media m : media) {
			System.out.println(m.toString());
		}
	}

}
