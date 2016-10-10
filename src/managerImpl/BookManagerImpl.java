package managerImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import daoImpl.BookDaoJdbc;
import database.DatabaseConnection;
import entities.Book;
import manger.BookManager;

public class BookManagerImpl extends DatabaseConnection implements BookManager {
	
	BookDaoJdbc dao = new BookDaoJdbc();

	@Override
	public List<Book> getallBooks() {
		List<Book> listBooks = new ArrayList<Book>();
		Connection connection = this.getConnection();
		try {
			listBooks = dao.getBooks(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listBooks;
	}

	@Override
	public Book getBookById(Book book) {
		Book bookInfo = new Book();
		Connection connection = this.getConnection();
		try {
			bookInfo = dao.getBookById(connection, book);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookInfo;
	}

	@Override
	public void saveBook(Book book) {
		Connection connection = this.getConnection();
		try {
			dao.saveBook(connection, book);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateBook(Book book) {
		Connection connection = this.getConnection();
		try {
			dao.updateBook(connection, book);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteBook(Book book) {
		Connection connection = this.getConnection();
		try {
			dao.deleteBook(connection, book);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
