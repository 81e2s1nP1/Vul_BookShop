package com.pa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "bookdownload")
public class BookDownload {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private int id;
	@NotNull
	private String bookURL;
	@NotNull
	private String bookIMG;
	
	public BookDownload(@NotNull String bookURL, @NotNull String bookIMG) {
		super();
		this.bookURL = bookURL;
		this.bookIMG = bookIMG;
	}
	
	public BookDownload() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookURL() {
		return bookURL;
	}

	public void setBookURL(String bookURL) {
		this.bookURL = bookURL;
	}

	public String getBookIMG() {
		return bookIMG;
	}

	public void setBookIMG(String bookIMG) {
		this.bookIMG = bookIMG;
	}

	@Override
	public String toString() {
		return "BookDownload [id=" + id + ", bookURL=" + bookURL + ", bookIMG=" + bookIMG + "]";
	}
}
