package entities;

public class Book {
	private int id;
	private Author author;
	private String book_name;
	private String publication_date;
	private Double price;
	private Editorial editorial;
	private int page_count;
	private String book_description;

	public Book() {
		super();
	}

	public Book(int id, Author author, String book_name, String publication_date, Double price, Editorial editorial,
			int page_count, String book_description) {
		super();
		this.id = id;
		this.author = author;
		this.book_name = book_name;
		this.publication_date = publication_date;
		this.price = price;
		this.editorial = editorial;
		this.page_count = page_count;
		this.book_description = book_description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Author getAuthor() {
		if (author == null) {
			author = new Author();
		}
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getPublication_date() {
		return publication_date;
	}

	public void setPublication_date(String publication_date) {
		this.publication_date = publication_date;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Editorial getEditorial() {
		if (editorial == null) {
			editorial = new Editorial();
		}
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	public int getPage_count() {
		return page_count;
	}

	public void setPage_count(int page_count) {
		this.page_count = page_count;
	}

	public String getBook_description() {
		return book_description;
	}

	public void setBook_description(String book_description) {
		this.book_description = book_description;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", book_name=" + book_name + ", publication_date="
				+ publication_date + ", price=" + price + ", editorial=" + editorial + ", page_count=" + page_count
				+ ", book_description=" + book_description + "]";
	}

}
