package cn.zafu.fuwuwaibao.Others;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DatebaseHelper extends SQLiteOpenHelper{

	//登录表
	private String user= "CREATE TABLE user ("
			+"phoneNum text,"
			+"password text,"
			+"userType text,"
			+"userNum text,"
			+"PRIMARY KEY (phoneNum,userType))";

	//班级表
	private String class1 = "CREATE TABLE class1 ("
			  +"classNum text,"
			  +"className text,"
			  +"schoolNum text,"
			  +"classDescrip text,"
			  +"PRIMARY KEY (classNum))";
	//班级教师表
	private String classteacher = "CREATE TABLE classteacher ("
			  +"classNum text,"
			  +"teacherNum text,"
			  +"startTime text,"
			  +"endTime text,"
			  +"PRIMARY KEY (classNum,teacherNum))";
	//收藏表
	private String collect="CREATE TABLE collect ("
			  +"contentNum text,"
			  +"userNum text,"
			  +"time text,"
			  +"PRIMARY KEY (contentNum,userNum))";
	//评论表
	private String comment = "CREATE TABLE comment ("
			  +"contentNum text,"
			  +"comment text,"
			  +"userNum text,"
			  +"time text)";
	//内容表
	private String content = "CREATE TABLE content ("
			  +"contentNum text,"
			  +"teacherNum text,"
			  +"text text ,"
			  +"path text,"
			  +"time text,"
			  +"PRIMARY KEY (contentNum))";
	//家长表
	private String parent="CREATE TABLE parent ("
			  +"parentNum text,"
			  +"parentName text,"
			  +"parentSex text,"
			  +"stuNum text,"
			  +"phoneNum text,"
			  +"PRIMARY KEY (parentNum,stuNum))"; 
	//回复表
	private String response="CREATE TABLE response ("
			  +"responseNum text,"
			  +"responseText text,"
			  +"responsefromNum text,"
			  +"responseforNum text,"
			  +"time text)";
	//学校表
	private String school = "CREATE TABLE school ("
			  +"schoolNum text,"
			  +"schoolName text,"
			  +"schoolAddress text,"
			  +"PRIMARY KEY (schoolNum))";
	//学生表
	private String student =  "CREATE TABLE student ("
			  +"stuNum text,"
			  +"stuName text,"
			  +"stuClassNum text,"
			  +"startTime text,"
			  +"endTime text,"
			  +"graduateTime text,"
			  +"enterTime text,"
			  +"PRIMARY KEY (stuNum,stuClassNum,startTime,endTime))";
	//点赞表
	private String zan = "CREATE TABLE zan ("
			  +"contentNum text,"
			  +"userNum text,"
			  +"time text,"
			  +"PRIMARY KEY (contentNum,userNum))";
	//教师表
	private String teacher="CREATE TABLE teacher ("
			  +"teacherNum text,"
			  +"teacherName text,"
			  +"teacherSex text,"
			  +"teachCourse text,"
			  +"phoneNum text,"
			  +"PRIMARY KEY (teacherNum))";
	Context mContext;
	
	public DatebaseHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		mContext = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(user);
		db.execSQL(class1);
		db.execSQL(classteacher);
		db.execSQL(collect);
		db.execSQL(comment);
		db.execSQL(content);
		db.execSQL(parent);
		db.execSQL(response);
		db.execSQL(school);
		db.execSQL(student);
		db.execSQL(zan);
		db.execSQL(teacher);
		Toast.makeText(mContext, "成功", Toast.LENGTH_LONG).show();
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table if exists user");
		db.execSQL("drop table if exists class1");
		db.execSQL("drop table if exists classteacher");
		db.execSQL("drop table if exists collect");
		db.execSQL("drop table if exists comment");
		db.execSQL("drop table if exists content");
		db.execSQL("drop table if exists parent");
		db.execSQL("drop table if exists response");
		db.execSQL("drop table if exists school");
		db.execSQL("drop table if exists student");
		db.execSQL("drop table if exists zan");
		db.execSQL("drop table if exists teacher");
		
		onCreate(db);
		
	}

}
