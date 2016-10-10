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
				bookRes.setId(resultSet.getInt("id"));
				bookRes.getAuthor().setId(resultSet.getInt("id_author"));
				bookRes.setBook_name(resultSet.getString("book_name"));
				bookRes.setPublication_date(resultSet.getString("publication_date"));
				bookRes.setPrice(resultSet.getDouble("price"));
				bookRes.getEditorial().setId(resultSet.getInt("id_editorial"));
				bookRes.setPage_count(resultSet.getInt("page_count"));
				bookRes.setBook_description(resultSet.getString("book_description"));
				bookRes.getAuthor().setFirst_name(resultSet.getString("first_name"));
				bookRes.getAuthor().setInitials(resultSet.getString("initials"));
				bookRes.getAuthor().setLast_name(resultSet.getString("last_name"));
				bookRes.getEditorial().setEditorial_name(resultSet.getString("editorial_name"));
				bookList.add(bookRes);
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
		Book bookRes = new Book();
		int index = 1;
		preparedStatement = connection.prepareStatement("SELECT boo.id, boo.id_author, boo.book_name, boo.publication_date, boo.price, boo.id_editorial, boo.page_count, boo.book_description, aut.first_name, aut.initials, aut.last_name, edit.editorial_name FROM book boo INNER JOIN author aut on boo.id_author = aut.id INNER JOIN editorial edit ON boo.id_editorial = edit.id WHERE boo.id = ?");
		preparedStatement.setInt(index++, book.getId());
		try {
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				bookRes.setId(resultSet.getInt("id"));
				bookRes.getAuthor().setId(resultSet.getInt("id_author"));
				bookRes.setBook_name(resultSet.getString("book_name"));
				bookRes.setPublication_date(resultSet.getString("publication_date"));
				bookRes.setPrice(resultSet.getDouble("price"));
				bookRes.getEditorial().setId(resultSet.getInt("id_editorial"));
				bookRes.setPage_count(resultSet.getInt("page_count"));
				bookRes.setBook_description(resultSet.getString("book_description"));
				bookRes.getAuthor().setFirst_name(resultSet.getString("first_name"));
				bookRes.getAuthor().setInitials(resultSet.getString("initials"));
				bookRes.getAuthor().setLast_name(resultSet.getString("last_name"));
				bookRes.getEditorial().setEditorial_name(resultSet.getString("editorial_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return bookRes;
	}

	@Override
	public void saveBook(Connection connection, Book book) throws SQLException {
		int index = 1;
		preparedStatement = connection.prepareStatement("INSERT INTO book (id_author, book_name, publication_date, price, id_editorial, page_count, book_description) VALUES (?,?,?,?,?,?,?)");
		preparedStatement.setInt(index++, book.getAuthor().getId());
		preparedStatement.setString(index++, book.getBook_name());
		preparedStatement.setString(index++, book.getPublication_date());
		preparedStatement.setDouble(index++, book.getPrice());
		preparedStatement.setInt(index++, book.getEditorial().getId());
		preparedStatement.setInt(index++, book.getPage_count());
		preparedStatement.setString(index++, book.getBook_description());
		try {
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	@Override
	public void updateBook(Connection connection, Book book) throws SQLException {
		int index = 1;
		preparedStatement = connection.prepareStatement("UPDATE book SET id_author = ?, book_name = ?, publication_date = ?, price = ?, id_editorial = ?, page_count = ?, book_description = ? WHERE id = ?");
		preparedStatement.setInt(index++, book.getAuthor().getId());
		preparedStatement.setString(index++, book.getBook_name());
		preparedStatement.setString(index++, book.getPublication_date());
		preparedStatement.setDouble(index++, book.getPrice());
		preparedStatement.setInt(index++, book.getEditorial().getId());
		preparedStatement.setInt(index++, book.getPage_count());
		preparedStatement.setString(index++, book.getBook_description());
		preparedStatement.setInt(index++, book.getId());
		try {
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	@Override
	public void deleteBook(Connection connection, Book book) throws SQLException {
		int index = 1;
		preparedStatement = connection.prepareStatement("DELETE FROM book WHERE id = ?");
		preparedStatement.setInt(index++, book.getId());
		try {
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		
	}

}
