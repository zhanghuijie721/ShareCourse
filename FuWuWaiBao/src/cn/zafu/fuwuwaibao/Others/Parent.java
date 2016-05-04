package cn.zafu.fuwuwaibao.Others;

//¼Ò³¤±í 
	
public class Parent {
	private String parentNum;
	private String parentName;
	private String parentSex;
	private String stuNum;
	private String phoneNum;
	public Parent()
	{
		
	}
	public Parent(String parentNum,String parentName,String parentSex,String stuNum,String phoneNum)
	{
		this.parentNum = parentNum;
		this.parentName = parentName;
		this.parentSex = parentSex;
		this.stuNum = stuNum;
		this.phoneNum = phoneNum;
	}
	public String getParentNum() {
		return parentNum;
	}
	public void setParentNum(String parentNum) {
		this.parentNum = parentNum;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getParentSex() {
		return parentSex;
	}
	public void setParentSex(String parentSex) {
		this.parentSex = parentSex;
	}
	public String getStuNum() {
		return stuNum;
	}
	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	

}
