package managerImpl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseConnection;
import entities.Author;
import manger.AuthorManager;

public class AuthorManagerImpl extends DatabaseConnection implements AuthorManager {

	@Override
	public List<Author> getAllAuthors() {
		List<Author> listAuthors = new ArrayList<Author>();
		Connection connection = this.getConnection();
		
		return listAuthors;
	}

	@Override
	public Author getAuthorById(Author author) {
		Author authorInfo = new Author();
		Connection connection = this.getConnection();
		
		return authorInfo;
	}

	@Override
	public void saveAuthor(Author author) {
		Connection connection = this.getConnection();
		
	}

	@Override
	public void updateAuthor(Author author) {
		Connection connection = this.getConnection();		
		
	}

	@Override
	public void deleteAuthor(Author author) {
		Connection connection = this.getConnection();
		
	}

}
