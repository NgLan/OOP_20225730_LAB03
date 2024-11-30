package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book {
	
	private int id;
	private String title;
	private String category;
	private float cost;
	private List<String> authors = new ArrayList<String>();

	public Book() {
		
	}

	public Book(int id, String title, String category, float cost, List<String> authors) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.authors = authors;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public List<String> getAuthors() {
		return authors;
	}
	
	public void addAuthor(String authorName) {
		boolean isAuthor = false;
		for (String a : authors) {
			if (a.equals(authorName)) isAuthor = true;
		}
		if (isAuthor) 
			System.out.println(authorName + " is already exists");
		else 
			authors.add(authorName);
	}
	
	public void removeAuthor(String authorName) {
		boolean isAuthor = false;
		for (String a : authors) {
			if (a.equals(authorName)) isAuthor = true;
		}
		if (isAuthor) 
			authors.remove(authorName);
		else
			System.out.println(authorName + " is not exists");
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", category=" + category + ", cost=" + cost + ", authors="
				+ authors + "]";
	}
}
