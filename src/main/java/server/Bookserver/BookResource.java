package server.Bookserver;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import server.bean.book;
import server.dao.BookRepository;


@Path("book")
public class BookResource {
	
		
		BookRepository repo = new BookRepository();
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<book> getAliens() {
			
			System.out.print("calling");
			return repo.getBooks();
		}
		
		@POST
		@Path("addbook")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public book createAlien(book book) {
			//System.out.println(alien);
			repo.addBook(book);
			System.out.println("finish adding book");
			return book;
		}

	
}
