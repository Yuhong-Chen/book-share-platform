package server.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import server.bean.Book;

public class BookRepository {


	private Connection con = null;
	
	public BookRepository () {
		
		String url = "jdbc:mysql://localhost:3306/test1";
		String url2 = "jdbc:mysql://ww39.host.cs.st-andrews.ac.uk:3306/ww39_CS5031p2";

		String user = "root";
		String user2 = "ww39";

		String password = "123456wwz";
		String password2 = "h01F667.24beES";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//con =DriverManager.getConnection(url,User,password);
			con = DriverManager.getConnection(url2,user2,password2);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		}
		if(con == null) {
			System.out.println("not connected");
		}else {
			System.out.println("connect successful");
		}
	}
	
	public List<Book> getBooks() {
		List<Book> books = new ArrayList<Book>();
		String sql1 = "select * from Book";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql1);

			while (rs.next()) {
				Book b = new Book();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthorName(rs.getString(3));
				b.setPublisher(rs.getString(4));
				b.setBookDescription(rs.getString(5));
				b.setOwner(rs.getString(6));
				
				books.add(b);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return books;
	}
	
	
	public void addBook(Book b1) {
		String sql3 = "insert into Book values (?,?,?,?,?,?)";

		try {
			PreparedStatement pt =  (PreparedStatement) con.prepareStatement(sql3);

			pt.setInt(1, b1.getBookId());
			pt.setString(2, b1.getBookName());
			pt.setString(3, b1.getAuthorName());
			pt.setString(4, b1.getPublisher());
			pt.setString(5, b1.getBookDescription());
			pt.setString(6, b1.getOwner());

			pt.executeUpdate();
			System.out.println("add Book to the database");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
