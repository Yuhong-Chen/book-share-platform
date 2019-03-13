package server.bean;

public class Book {
	private int bookId;
	private String bookName;
	private String authorName;
	private String publisher;
	private String bookDescription;
	private String owner;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int bookId, String bookName, String authorName,
				String publisher, String bookDescription, String owner) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorName = authorName;
		this.publisher = publisher;
		this.bookDescription = bookDescription;
		this.owner = owner;
	}
	
	public Book(String bookName, String authorName, String publisher, String bookDescription, String owner) {
		super();
		this.bookName = bookName;
		this.authorName = authorName;
		this.publisher = publisher;
		this.bookDescription = bookDescription;
		this.owner = owner;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
}
