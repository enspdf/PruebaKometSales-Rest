package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BookDao;
import entities.Book;

public class BookDaoJdbc implements BookDao {
	
	protected PreparedStatement preparedStatement;
	protected ResultSet resultSet;

	@Override
	public List<Book> getBooks(Connection connection) throws SQLException {
		List<Book> bookList = new ArrayList<Book>();
		preparedStatement = connection.prepareStatement("SELECT boo.id, boo.id_author, boo.book_name, boo.publication_date, boo.price, boo.id_editorial, boo.page_count, boo.book_description, aut.first_name, aut.initials, aut.last_name, edit.editorial_name FROM book boo INNER JOIN author aut on boo.id_author = aut.id INNER JOIN editorial edit ON boo.id_editorial = edit.id");
		try {
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				Book bookRes = new Book();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return bookList;
	}

	@Override
	public Book getBookById(Connection connection, Book book) throws SQLException {
		
		return null;
	}

	@Override
	public void saveBook(Connection connection, Book book) throws SQLException {
		
		
	}

	@Override
	public void updateBook(Connection connection, Book book) throws SQLException {
		
		
	}

	@Override
	public void deleteBook(Connection connection, Book book) throws SQLException {
		
		
	}

}
