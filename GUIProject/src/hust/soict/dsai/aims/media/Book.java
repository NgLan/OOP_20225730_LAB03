package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	
	private List<String> authors = new ArrayList<String>();

	public Book() {
		
	}
	
	public Book(String title, String category, float cost) {
		super(title, category, cost);
	}

	public Book(String title, String category, float cost, List<String> authors) {
		super(title, category, cost);
		this.authors = authors;
	}

	public List<String> getAuthors() {
		return authors;
	}
	
	public void addAuthor(String authorName) {
		if (authors.contains(authorName))
			System.out.println(authorName + " is already exists");
		else 
			authors.add(authorName);
	}
	
	public void removeAuthor(String authorName) {
		if (authors.contains(authorName))
			authors.remove(authorName);
		else
			System.out.println(authorName + " is not exists");
	}
	
	@Override
	public String toString() {
		return "Book - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getAuthors() + 
				": " + this.getCost() + "$";
	}
}