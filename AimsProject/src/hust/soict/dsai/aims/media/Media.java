package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media {
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST =
			new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE =
			new MediaComparatorByCostTitle();
	
	private int id;
	private String title;
	private String category;
	private float cost;

	public Media() {
		
	}
	
	public Media(String title) {
		super();
		this.title = title;
	}

	public Media(int id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public Media(int id, String title, String category, float cost) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
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
	
	public boolean isMatch(String title) {
		if (this.getTitle().equals(title)) return true;
		return false;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Media) {
			Media m = (Media) obj;
			if (this.getTitle().equals(m.title)) return true;
		}
		return false;
	}
}
