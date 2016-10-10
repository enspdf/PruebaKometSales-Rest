package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import entities.Book;

public interface BookDao {
	List<Book> getBooks(Connection connection) throws SQLException;
	Book getBookById(Connection connection, Book book) throws SQLException;
	void saveBook(Connection connection, Book book) throws SQLException;
	void updateBook(Connection connection, Book book) throws SQLException;
	void deleteBook(Connection connection, Book book) throws SQLException;
}
