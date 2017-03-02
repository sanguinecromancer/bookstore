package fi.haagahelia.course.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Book {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	 private Long id;
	 private String title;
	 private String author;	 

	 private Long date;
	
	 
	  @ManyToOne
	  @JsonIgnore
	  @JoinColumn(name = "categoryid")
	  private Category category;

	 
	 public Book() {}
	 
	/* public Book (String title, String author, long date, long isbn, double price, Category category)
	 {
		 super();
		 this.title = title;
		 this.author = author;
		 this.date = date;
		 this.isbn = isbn;
		 this.price = price;
		 this.category = category;
	 } */
	 public Book (String title, String author, Long date, Category category)
	 {
		 super();
		 this.title = title;
		 this.author = author;		 
	
		 this.date = date;
		 this.category = category;
	 }
	 

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	

	public Long getDate() {
		return date;
	}

	public void setDate(Long date) {
		this.date = date;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		if (this.category != null)
			return "Book title=" + title + ", author=" + author +  "date" + date +  this.getCategory();		
		else 
		return "Book title=" + title + ", author=" + author;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
