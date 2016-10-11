package Service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import entities.Author;
import entities.Book;
import entities.Editorial;
import managerImpl.AuthorManagerImpl;
import managerImpl.BookManagerImpl;
import managerImpl.EditorialManagerImpl;

@Path("api")
public class Service {
	
	AuthorManagerImpl authorManager = new AuthorManagerImpl();
	EditorialManagerImpl editorialManager = new EditorialManagerImpl();
	BookManagerImpl bookManager = new BookManagerImpl();
	
	@GET
	@Path("authors")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllAuthors() {
		List<Author> authors = authorManager.getAllAuthors();
		String data = new JSONArray(authors).toString();
		return Response.status(200)
				.entity(data).build();
	}
	
	@GET
	@Path("authors/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAuthorById(@PathParam("id") int id) {
		Author author = new Author();
		author.setId(id);
		Author authorRes = authorManager.getAuthorById(author);
		String data = new JSONObject(authorRes).toString();
		return Response.status(200).entity(data).build();
	}
	
	@POST
	@Path("authors")
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveAuthor(@FormParam("first_name") String first_name,
			                   @FormParam("initials") String initials,
			                   @FormParam("last_name") String last_name) {
		Author author = new Author();
		author.setFirst_name(first_name);
		author.setInitials(initials);
		author.setLast_name(last_name);
		authorManager.saveAuthor(author);
		String data = new JSONObject(author).toString();
		return Response.status(200).entity(data).build();
	}
	
	@PUT
	@Path("authors/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateAuthor(@FormParam("first_name") String first_name,
			                     @FormParam("initials") String initials,
			                     @FormParam("last_name") String last_name,
			                     @PathParam("id") int id) {
		Author author = new Author();
		author.setId(id);
		author.setFirst_name(first_name);
		author.setInitials(initials);
		author.setLast_name(last_name);
		authorManager.updateAuthor(author);
		String data = new JSONObject(author).toString();
		return Response.status(200).entity(data).build();
	}
	
	@DELETE
	@Path("authors/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteAuthor(@PathParam("id") int id) {
		Author author = new Author();
		author.setId(id);
		authorManager.deleteAuthor(author);
		String data = new JSONObject(author).toString();
		return Response.status(200).entity(data).build();
	}
	
	@GET
	@Path("editorials")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllEditorials() {
		List<Editorial> editorials = editorialManager.getAllEditorials();
		String data = new JSONArray(editorials).toString();
		return Response.status(200).entity(data).build();
	}
	
	@GET
	@Path("editorials/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getEditorialById(@PathParam("id") int id) {
		Editorial editorial = new Editorial();
		editorial.setId(id);
		Editorial editorialRes = editorialManager.getEditorialById(editorial);
		String data = new JSONObject(editorialRes).toString();
		return Response.status(200).entity(data).build();
	}
	
	@POST
	@Path("editorials")
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveEditorial(@FormParam("editorial_name") String editorial_name) {
		Editorial editorial = new Editorial();
		editorial.setEditorial_name(editorial_name);
		editorialManager.saveEditorial(editorial);
		String data = new JSONObject(editorial).toString();
		return Response.status(200).entity(data).build();
	}
	
	@PUT
	@Path("editorials/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateEditorial(@FormParam("editorial_name") String editorial_name,
								    @PathParam("id") int id) {
		Editorial editorial = new Editorial();
		editorial.setId(id);
		editorial.setEditorial_name(editorial_name);
		editorialManager.updateEditorial(editorial);
		String data = new JSONObject(editorial).toString();
		return Response.status(200).entity(data).build();
	}
	
	@DELETE
	@Path("editorials/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteEditorial(@PathParam("id") int id) {
		Editorial editorial = new Editorial();
		editorial.setId(id);
		editorialManager.deleteEditorial(editorial);
		String data = new JSONObject(editorial).toString();
		return Response.status(200).entity(data).build();
	}
	
	@GET
	@Path("books")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllBooks() {
		List<Book> books = bookManager.getallBooks();
		String data = new JSONArray(books).toString();
		return Response.status(200).entity(data).build();
	}
	
	@GET
	@Path("books/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBookById(@PathParam("id") int id) {
		Book book = new Book();
		book.setId(id);
		Book bookRes = new Book();
		bookRes = bookManager.getBookById(book);
		String data = new JSONObject(bookRes).toString();
		return Response.status(200).entity(data).build();
	}
	
	@POST
	@Path("books")
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveBook(@FormParam("id_author") int id_author,
							 @FormParam("book_name") String book_name,
							 @FormParam("publication_date") String publication_date,
							 @FormParam("price") double price,
							 @FormParam("id_editorial") int id_editorial,
							 @FormParam("page_count") int page_count,
							 @FormParam("book_description") String book_description) {
		Book book = new Book();
		book.getAuthor().setId(id_author);
		book.setBook_name(book_name);
		book.setPublication_date(publication_date);
		book.setPrice(price);
		book.getEditorial().setId(id_editorial);
		book.setPage_count(page_count);
		book.setBook_description(book_description);
		bookManager.saveBook(book);
		String data = new JSONObject(book).toString();
		return Response.status(200).entity(data).build();
	}
	
	@PUT
	@Path("books/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateBook(@FormParam("id_author") int id_author,
							   @FormParam("book_name") String book_name,
							   @FormParam("publication_date") String publication_date,
							   @FormParam("price") double price,
							   @FormParam("id_editorial") int id_editorial,
							   @FormParam("page_count") int page_count,
							   @FormParam("book_description") String book_description,
							   @PathParam("id") int id) {
		Book book = new Book();
		book.getAuthor().setId(id_author);
		book.setBook_name(book_name);
		book.setPublication_date(publication_date);
		book.setPrice(price);
		book.getEditorial().setId(id_editorial);
		book.setPage_count(page_count);
		book.setBook_description(book_description);
		book.setId(id);
		bookManager.updateBook(book);
		String data = new JSONObject(book).toString();
		return Response.status(200).entity(data).build();
	}
	
	@DELETE
	@Path("books/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteBook(@PathParam("id") int id) {
		Book book = new Book();
		book.setId(id);
		bookManager.deleteBook(book);
		String data = new JSONObject(book).toString();
		return Response.status(200).entity(data).build();
	}
}
