package cn.zafu.fuwuwaibao.Others;

public class Login {
	private String userId;
	private String userPswd;
	private String userType;
	public Login(String userId,String userPswd,String userType)
	{
		this.userId = userId;
		this.userPswd = userPswd;
		this.userType = userType;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPswd() {
		return userPswd;
	}
	public void setUserPswd(String userPswd) {
		this.userPswd = userPswd;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
}
