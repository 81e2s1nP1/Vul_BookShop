package com.pa.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

@Entity
@Table(name = "authors")
public class Authors {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Size(min = 5, max = 100)
	private String authorName;
	
	@NotNull
	@PastOrPresent(message = "Date must be in the past or today")
	private Date authorDate;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public Date getAuthorDate() {
		return authorDate;
	}

	public void setAuthorDate(Date authorDate) {
		this.authorDate = authorDate;
	}

	public Authors(@NotNull @Size(min = 5, max = 100) String authorName,
			@NotNull @PastOrPresent(message = "Date must be in the past or today") Date authorDate,
			List<Books> books) { 
		super();
		this.authorName = authorName;
		this.authorDate = authorDate;
	}

	public Authors() {
		super();
	}
}

