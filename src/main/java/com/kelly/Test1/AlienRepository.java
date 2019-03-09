package com.kelly.Test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.*;

public class AlienRepository {

	
	Connection con = null;
	
	public AlienRepository () {
		
		String url="jdbc:mysql://localhost:3306/test1";
		//String url="jdbc:mysql://ww39.host.cs.st-andrews.ac.uk:3306/ww39_CS5031p2";
		String username ="root";
		String password = "123456wwz";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =DriverManager.getConnection(url,username,password);
			
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
	
	public List<Alien> getAliens() {
		List<Alien> aliens = new ArrayList<Alien>();
		String sql1 = "select * from user";
		try {
			Statement st = con.createStatement();
			ResultSet rs= st.executeQuery(sql1);
			while (rs.next()) {
				Alien a = new Alien();
				a.setId(rs.getInt(1));
				a.setUserName(rs.getString(2));
				a.setUserPwd(rs.getString(3));
				
				aliens.add(a);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return aliens;
		
		
	}
	
	public Alien getAlien(int id) {
		Alien a=new Alien();
		String sql2 = "select * from user where id="+id;
		try {
			Statement st = con.createStatement();
			ResultSet rs= st.executeQuery(sql2);
			if (rs.next()) {
				a.setId(rs.getInt(1));
				a.setUserName(rs.getString(2));
				a.setUserPwd(rs.getString(3));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return a;
	}
	
	public void create(Alien a1) {
		String sql3 = "insert into user values (?,?,?)";
		try {
			PreparedStatement pt =  (PreparedStatement) con.prepareStatement(sql3);
			pt.setInt(1, a1.getId());
			pt.setString(2, a1.getUserName());
			pt.setString(3, a1.getUserPwd());
			pt.executeUpdate();
			System.out.println("add to the database");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	public void update(int id, Alien a1) {
		String sql4="updata user set username='"+a1.getUserName()+"', userpwd='"+a1.getUserPwd()+"' where id='"+id+"'";
		try {
			PreparedStatement pt =  (PreparedStatement) con.prepareStatement(sql4);
			pt.executeUpdate();
			System.out.println("update to the database");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	public void delete(int id) {
		String sql5= "delete from user where id ='"+id+"'";
		try {
			PreparedStatement pt =  (PreparedStatement) con.prepareStatement(sql5);
			pt.executeUpdate();
			System.out.println("update to the database");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
