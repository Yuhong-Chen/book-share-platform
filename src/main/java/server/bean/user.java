package server.bean;


public class user {
	private int id;
	private String userName;
	private String userPwd;
	
	public user() {
		
		// TODO Auto-generated constructor stub
	}
	
	
	public user(int id, String userName, String userPwd) {
	
		this.id = id;
		this.userName = userName;
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Alien [id=" + id + ", userName=" + userName + ", userPwd=" + userPwd + "]";
	}

}
