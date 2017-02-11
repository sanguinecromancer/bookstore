package fi.haagahelia.course.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	 long id;
	 String title;
	 String author;
	 long date;
	 long isbn;
	 Double price;
	 
	 public Book() {
		 
	 }
	 
	 public Book (String title, String author, long date, long isbn, double price)
	 {
		 super();
		 this.title = title;
		 this.author = author;
		 this.date = date;
		 this.isbn = isbn;
		 this.price = price;
	 }
	 
	 public Book (String title, String author)
	 {
		 super();
		 this.title = title;
		 this.author = author;
	
	 }
		
	 public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book title=" + title + ", author=" + author + ", date=" + date
				+ ", isbn=" + isbn + ", price=" + price ;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
