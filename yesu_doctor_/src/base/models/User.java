package base.models;

public class User {
	private String uId;
	private String uName;
	private String uPass;

	public User(String uId, String uName, String uPass) {
		this.uId = uId;
		this.uName = uName;
		this.uPass = uPass;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuPass() {
		return uPass;
	}

}
