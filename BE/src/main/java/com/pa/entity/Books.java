package com.pa.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

@Entity
@Table(name = "books")
public class Books {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	@NotNull
	@Size(min = 5, max = 100)
	private String bookName;
	@NotNull
	private float bookSize;
	@NotNull
	@PastOrPresent(message = "Date must be in the past or today")
	private Date BookDate;
	@NotNull
	private String BookDescription;
	@NotNull
	@Size(min = 5, max = 50)	
	private String bookTopic;
	@NotNull
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private BookDownload bookDownload;
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Authors authors;

	public Books(@NotNull @Size(min = 5, max = 100) String bookName, @NotNull float bookSize,
			@NotNull @PastOrPresent(message = "Date must be in the past or today") Date bookDate,
			@NotNull String bookDescription, @NotNull @Size(min = 5, max = 50) String bookTopic,
			@NotNull BookDownload bookDownload, @NotNull Authors authors) {
		super();
		this.bookName = bookName;
		this.bookSize = bookSize;
		BookDate = bookDate;
		BookDescription = bookDescription;
		this.bookTopic = bookTopic;
		this.bookDownload = bookDownload;
		this.authors = authors;
	}



	public Books() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public float getBookSize() {
		return bookSize;
	}

	public void setBookSize(float bookSize) {
		this.bookSize = bookSize;
	}

	public Date getBookDate() {
		return BookDate;
	}

	public void setBookDate(Date bookDate) {
		BookDate = bookDate;
	}

	public String getBookTopic() {
		return bookTopic;
	}

	public void setBookTopic(String bookTopic) {
		this.bookTopic = bookTopic;
	}

	public BookDownload getBookDownload() {
		return bookDownload;
	}

	public void setBookDownload(BookDownload bookDownload) {
		this.bookDownload = bookDownload;
	}

	public Authors getAuthors() {
		return authors;
	}

	public void setAuthors(Authors authors) {
		this.authors = authors;
	}

	public String getBookDescription() {
		return BookDescription;
	}

	public void setBookDescription(String bookDescription) {
		BookDescription = bookDescription;
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", bookName=" + bookName + ", bookSize=" + bookSize + ", BookDate=" + BookDate
				+ ", bookTopic=" + bookTopic + ", bookDownload=" + bookDownload + "]";
	}
}
