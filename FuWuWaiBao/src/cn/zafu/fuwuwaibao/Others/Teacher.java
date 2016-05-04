package cn.zafu.fuwuwaibao.Others;

//ΩÃ ¶±Ì	
public class Teacher {
	private String teacherNum;
	private String teacherName;
	private String teacherSex;
	private String teachCourse;
	private String phoneNum;
	public Teacher()
	{
		
	}
	
	public Teacher(String teacherNum,String teacherName,String teacherSex,String teachCourse,String phoneNum)
	{
		this.teacherNum = teacherNum;
		this.teacherName = teacherName;
		this.teacherSex = teacherSex;
		this.teachCourse = teachCourse;
		this.phoneNum = phoneNum;
	}
	public String getTeacherNum() {
		return teacherNum;
	}
	public void setTeacherNum(String teacherNum) {
		this.teacherNum = teacherNum;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTeacherSex() {
		return teacherSex;
	}
	public void setTeacherSex(String teacherSex) {
		this.teacherSex = teacherSex;
	}
	public String getTeachCourse() {
		return teachCourse;
	}
	public void setTeachCourse(String teachCourse) {
		this.teachCourse = teachCourse;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	

}
