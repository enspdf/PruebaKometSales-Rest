package managerImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import daoImpl.AuthorDaoJdbc;
import database.DatabaseConnection;
import entities.Author;
import manger.AuthorManager;

public class AuthorManagerImpl extends DatabaseConnection implements AuthorManager {
	
	AuthorDaoJdbc dao = new AuthorDaoJdbc();

	@Override
	public List<Author> getAllAuthors() {
		List<Author> listAuthors = new ArrayList<Author>();
		Connection connection = this.getConnection();
		try {
			listAuthors = dao.getAuthors(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listAuthors;
	}

	@Override
	public Author getAuthorById(Author author) {
		Author authorInfo = new Author();
		Connection connection = this.getConnection();
		try {
			authorInfo = dao.getAuthorById(connection, author);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return authorInfo;
	}

	@Override
	public void saveAuthor(Author author) {
		Connection connection = this.getConnection();
		try {
			dao.saveAuthor(connection, author);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateAuthor(Author author) {
		Connection connection = this.getConnection();		
		try {
			dao.updateAuthor(connection, author);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteAuthor(Author author) {
		Connection connection = this.getConnection();
		try {
			dao.deleteAuthor(connection, author);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
