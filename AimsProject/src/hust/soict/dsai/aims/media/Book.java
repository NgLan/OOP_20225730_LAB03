package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
	
	private List<String> authors = new ArrayList<String>();

	public Book() {
		
	}

	public Book(int id, String title, String category, float cost, List<String> authors) {
		super(id, title, category, cost);
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
		return "Book [id=" + this.getId() + ", title=" + this.getTitle() + ", category=" + this.getCategory() + ", cost=" + this.getCost() + ", authors="
				+ authors + "]";
	}
}
