package com.wenzhe.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wenzhe.bean.book;
import com.wenzhe.bean.user;

public class BookRepository {


	Connection con = null;
	
	public BookRepository () {
		
		String url="jdbc:mysql://localhost:3306/test1";
		String url2="jdbc:mysql://ww39.host.cs.st-andrews.ac.uk:3306/ww39_CS5031p2";
		String user ="root";
		String user2="ww39";
		String password = "123456wwz";
		String password2 = "h01F667.24beES";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//con =DriverManager.getConnection(url,user,password);
			con =DriverManager.getConnection(url2,user2,password2);
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		}
		if(con==null) {
			System.out.println("not connecte");
		}else {
			System.out.println("connect successful");
		}
		
		
	}
	
	
	public List<book> getBooks() {
		List<book> books = new ArrayList<book>();
		String sql1 = "select * from book";
		try {
			Statement st = con.createStatement();
			ResultSet rs= st.executeQuery(sql1);
			while (rs.next()) {
				book b = new book();
				b.setBookid(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthorname(rs.getString(3));
				b.setPublisher(rs.getString(4));
				b.setBookdiscription(rs.getString(5));
				b.setOwner(rs.getString(6));
				
				books.add(b);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return books;
	}
	
	
	public book getBook(int id) {
		book a=new book();
		String sql2 = "select * from book where bookid="+id;
		try {
			Statement st = con.createStatement();
			ResultSet rs= st.executeQuery(sql2);
			if (rs.next()) {
				a.setBookid(rs.getInt(1));
				a.setBookname(rs.getString(2));
				a.setAuthorname(rs.getString(3));
				a.setPublisher(rs.getString(4));
				a.setBookdiscription(rs.getString(5));
				a.setOwner(rs.getString(6));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return a;
	}
	
	
	public void addBook(book b1) {
		String sql3 = "insert into book values (?,?,?,?,?,?)";
		try {
			PreparedStatement pt =  (PreparedStatement) con.prepareStatement(sql3);
			pt.setInt(1, b1.getBookid());
			pt.setString(2, b1.getBookname());
			pt.setString(3, b1.getAuthorname());
			pt.setString(4, b1.getPublisher());
			pt.setString(5, b1.getBookdiscription());
			pt.setString(6, b1.getOwner());
			pt.executeUpdate();
			System.out.println("add book to the database");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
