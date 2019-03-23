package server.dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import server.bean.User;

public class UserRepository {
	public static int idCounter = 100;
	private Connection con = null;
	
	public UserRepository () {
		
		String url="jdbc:mysql://ww39.host.cs.st-andrews.ac.uk:3306/ww39_CS5031p2";
		String username ="ww39";
		String password = "h01F667.24beES";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		}
		if (con == null) {
			System.out.println("not connected");
		}else {
			System.out.println("connect successful");
		}
		
		
	}
	
	public List<User> getAliens() {
		List<User> users = new ArrayList<User>();
		String sql1 = "select * from user";

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql1);

			while (rs.next()) {
				User a = new User();

				a.setId(rs.getString(1));
				a.setUserName(rs.getString(2));
				a.setUserPwd(rs.getString(3));
				
				users.add(a);
			}

			System.out.println("returned all users");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return users;
		
		
	}
	public User getAlienByName(String name) {
		User a = new User();
		String sql2 = "select * from user where username=\"" + name + "\"";

		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql2);

			if (rs.next()) {
				a.setId(rs.getString(1));
				a.setUserName(rs.getString(2));
				a.setUserPwd(rs.getString(3));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return a;
	}
	public User getAlien(String id) {
		User a = new User();
		String sql2 = "select * from user where id=" + id;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql2);

			if (rs.next()) {
				a.setId(rs.getString(1));
				a.setUserName(rs.getString(2));
				a.setUserPwd(rs.getString(3));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return a;
	}
	
	public void create(User a1) {
		String sql3 = "insert into user values (?,?,?)";

		try {
			PreparedStatement pt = (PreparedStatement) con.prepareStatement(sql3);

			pt.setInt(1, ++idCounter );
			pt.setString(2, a1.getUserName());
			pt.setString(3, a1.getUserPwd());
			
			pt.executeUpdate();
			System.out.println("add to the database");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void update(int id, User a1) {
		String sql4 = "update user set username='" + a1.getUserName() + "', userpwd='" + a1.getUserPwd() + "' where id='" + id + "'";

		try {
			PreparedStatement pt = (PreparedStatement) con.prepareStatement(sql4);
			pt.executeUpdate();
			System.out.println("update to the database");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void delete(int id) {
		String sql5= "delete from user where id ='" + id + "'";

		try {
			PreparedStatement pt =  (PreparedStatement) con.prepareStatement(sql5);
			pt.executeUpdate();
			System.out.println("deleted in the database");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}
