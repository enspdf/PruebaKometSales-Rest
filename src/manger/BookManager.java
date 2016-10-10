package manger;

import java.util.List;

import entities.Book;

public interface BookManager {
	List<Book> getallBooks();
	Book getBookById(Book book);
	void saveBook(Book book);
	void updateBook(Book book);
	void deleteBook(Book book);
}
