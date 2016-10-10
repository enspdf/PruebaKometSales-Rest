package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.AuthorDao;
import entities.Author;

public class AuthorDaoJdbc implements AuthorDao {
	
	protected PreparedStatement preparedStatement;
	protected ResultSet resultSet;

	@Override
	public List<Author> getAuthors(Connection connection) throws SQLException {
		List<Author> authorsList = new ArrayList<Author>();
		preparedStatement = connection.prepareStatement("SELECT id, first_name, initials, last_name FROM author");
		try {
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Author resAuthor = new Author();
				resAuthor.setId(resultSet.getInt("id"));
				resAuthor.setFirst_name(resultSet.getString("first_name"));
				resAuthor.setInitials(resultSet.getString("initials"));
				resAuthor.setLast_name(resultSet.getString("last_name"));
				authorsList.add(resAuthor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return authorsList;
	}

	@Override
	public Author getAuthorById(Connection connection, Author author) throws SQLException {
		Author authorRes = new Author();
		int index = 1;
		preparedStatement = connection.prepareStatement("SELECT id, first_name, initials, last_name FROM author WHERE id = ?");
		preparedStatement.setInt(index++, author.getId());
		try {
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				authorRes.setId(resultSet.getInt("id"));
				authorRes.setFirst_name(resultSet.getString("first_name"));
				authorRes.setInitials(resultSet.getString("initials"));
				authorRes.setLast_name(resultSet.getString("last_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		return authorRes;
	}

	@Override
	public void saveAuthor(Connection connection, Author author) throws SQLException {
		int index = 1;
		preparedStatement = connection.prepareStatement("INSERT INTO author (first_name, initials, last_name) VALUES (?,?,?)");
		preparedStatement.setString(index++, author.getFirst_name());
		preparedStatement.setString(index++, author.getInitials());
		preparedStatement.setString(index++, author.getLast_name());
		try {
			preparedStatement.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	@Override
	public void updateAuthor(Connection connection, Author author) throws SQLException {
		int index = 1;
		preparedStatement = connection.prepareStatement("UPDATE author SET first_name = ?, initials = ?, last_name = ? WHERE id = ?");
		preparedStatement.setString(index++, author.getFirst_name());
		preparedStatement.setString(index++, author.getInitials());
		preparedStatement.setString(index++, author.getLast_name());
		preparedStatement.setInt(index++, author.getId());
		try {
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

	@Override
	public void deleteAuthor(Connection connection, Author author) throws SQLException {
		int index = 1;
		preparedStatement = connection.prepareStatement("DELETE FROM author WHERE id = ?");
		preparedStatement.setInt(index++, author.getId());
		try {
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
	}

}
