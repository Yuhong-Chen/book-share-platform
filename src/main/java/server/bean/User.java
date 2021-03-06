package server.bean;


public class User {
	private String id;
	private String userName;
	private String userPwd;

	public User() {
		//empty constructor
	}
	
	public User(String id, String userName, String userPwd) {
	
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Alien [id=" + id + ", userName=" + userName + ", userPwd=" + userPwd + "]";
	}

}
