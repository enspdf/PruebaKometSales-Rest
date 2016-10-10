package managerImpl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnection;
import entities.Book;
import manger.BookManager;

public class BookManagerImpl extends DatabaseConnection implements BookManager {

	@Override
	public List<Book> getallBooks() {
		List<Book> listBooks = new ArrayList<Book>();
		Connection connection = this.getConnection();
		
		return listBooks;
	}

	@Override
	public Book getBookById(Book book) {
		Book bookInfo = new Book();
		Connection connection = this.getConnection();
		
		return bookInfo;
	}

	@Override
	public void saveBook(Book book) {
		Connection connection = this.getConnection();
		
	}

	@Override
	public void updateBook(Book book) {
		Connection connection = this.getConnection();
		
	}

	@Override
	public void deleteBook(Book book) {
		Connection connection = this.getConnection();
		
	}

}
