package server.bookserver;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import server.bean.Book;
import server.dao.BookRepository;


@Path("Book")
public class BookResource {
		private BookRepository repo = new BookRepository();
		
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<Book> getAliens() {
			
			System.out.print("calling");
			return repo.getBooks();
		}
		
		@POST
		@Path("addbook")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public Book createAlien(Book book) {
			//System.out.println(alien);
			repo.addBook(book);
			System.out.println("finish adding Book");
			return book;
		}

	
}
