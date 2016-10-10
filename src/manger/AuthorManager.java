package manger;

import java.util.List;

import entities.Author;

public interface AuthorManager {
	List<Author> getAllAuthors();
	Author getAuthorById(Author author);
	void saveAuthor(Author author);
	void updateAuthor(Author author);
	void deleteAuthor(Author author);
}