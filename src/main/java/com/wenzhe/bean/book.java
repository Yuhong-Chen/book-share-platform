package com.wenzhe.bean;

public class book {
	private int bookid;
	private String bookname;
	private String authorname;
	private String publisher;
	private String bookdiscription;
	private String owner;
	public book(int bookid, String bookname, String authorname, String publisher, String bookdiscription,
			String owner) {
		super();
		this.bookid = bookid;
		this.bookname = bookname;
		this.authorname = authorname;
		this.publisher = publisher;
		this.bookdiscription = bookdiscription;
		this.owner = owner;
	}
	
	public book(String bookname, String authorname, String publisher, String bookdiscription, String owner) {
		super();
		this.bookname = bookname;
		this.authorname = authorname;
		this.publisher = publisher;
		this.bookdiscription = bookdiscription;
		this.owner = owner;
	}


	public book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getBookdiscription() {
		return bookdiscription;
	}
	public void setBookdiscription(String bookdiscription) {
		this.bookdiscription = bookdiscription;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	

}
