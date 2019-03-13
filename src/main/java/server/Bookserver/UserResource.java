package server.Bookserver;


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

import server.bean.book;
import server.bean.user;
import server.dao.BookRepository;
import server.dao.UserRepository;


@Path("user")
public class UserResource {
	
	private UserRepository repo = new UserRepository();
	private BookRepository repo2 = new BookRepository();
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<user> getAliens() {
		return repo.getAliens();
	}

	@GET
	@Path("/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public user getAlienbyname(@PathParam("username") String name) {
		System.out.println(name);
		return repo.getAlienbyname(name);
	}

	/*@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public user getAlien(@PathParam("id") String id) {
		return repo.getAlien(id);
	}*/
	
	@POST
	@Path("/register")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public user createAlien(user user) {
		repo.create(user);
		return user;
	}
	
	@PUT
	@Path("/update/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public user updateAlien(@PathParam("id") int id,user user) {
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
	public List<book> getBooks() {
		
		System.out.print("calling");
		return repo2.getBooks();
	}
	
	@POST
	@Path("/addbook")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public book createAlien(book book) {
		//System.out.println(alien);
		repo2.addBook(book);
		System.out.println("finish adding book");
		return book;
	}
	
	
}
