package server.bookserver;


import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import server.bean.Book;
import server.bean.User;
import server.dao.BookRepository;
import server.dao.UserRepository;


@Path("User")
public class UserResource {
	
	private UserRepository repo = new UserRepository();
	private BookRepository repo2 = new BookRepository();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAliens() {
		return repo.getAliens();
	}

	@GET
	@Path("/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getAlienByName(@PathParam("username") String name) {
		return repo.getAlienByName(name);
	}

	/*@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getAlien(@PathParam("id") String id) {
		return repo.getAlien(id);
	}*/
	
	@POST
	@Path("/register")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public User createAlien(User user) {
		System.out.println(user.getUserName());
		repo.create(user);
		return user;
	}
	
	@PUT
	@Path("/update/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User updateAlien(@PathParam("id") int id, User user) {
		repo.update(id,user);
		return user;
	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteAlien(@PathParam("id") int id) {
		repo.delete(id);
	}
	
	@GET
	@Path("/getbooks")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getBooks() {
		
		System.out.print("calling");
		return repo2.getBooks();
	}
	
	@POST
	@Path("/addbook")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Book createAlien(Book book) {
		//System.out.println(alien);
		repo2.addBook(book);
		System.out.println("finish adding Book");
		return book;
	}
	
	
}
