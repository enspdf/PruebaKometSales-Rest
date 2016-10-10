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
		return Response.status(200).entity(data).build();
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
}
