package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import entities.Author;

public interface AuthorDao {
	List<Author> getAuthors(Connection connection) throws SQLException;

	Author getAuthorById(Connection connection, Author author) throws SQLException;

	void saveAuthor(Connection connection, Author author) throws SQLException;

	void updateAuthor(Connection connection, Author author) throws SQLException;

	void deleteAuthor(Connection connection, Author author) throws SQLException;
}
