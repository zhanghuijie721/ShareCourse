package cn.zafu.fuwuwaibao.Others;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class ConnectDB {
	// ���ݿ���
	public static final String DB_NAME = "ShareCourse.db";

	// ���ݿ�汾
	public static final int VERSION = 6;

	//
	private static DatebaseHelper helper;

	private SQLiteDatabase db;
	Context mContext;

	public ConnectDB() {

	}

	public ConnectDB(Context context) {
		helper = new DatebaseHelper(context, DB_NAME, null,
				VERSION);
		mContext = context;
	}

	// �ж��Ƿ�ע��
	public boolean isExist(Login lg) {
		db = helper.getWritableDatabase();
		Cursor cursor = db
				.rawQuery(
						"select * from user where phoneNum=? and password = ? and userType = ?",
						new String[] { String.valueOf(lg.getUserId()),
								String.valueOf(lg.getUserPswd()),
								String.valueOf(lg.getUserType())});
		if (cursor.moveToNext()) {
			cursor.close();
			return true;
		} else {
			cursor.close();
			return false;
		}
		
	}

	// �ж�ע��ĵ绰�����Ƿ�ͽ�ʦ�����һ��
	public boolean identicalTeacher(String userId) 
	{
		db = helper.getWritableDatabase();
		
		  Cursor cursor = db.rawQuery("select * from teacher where phoneNum=? ", new String[]{String.valueOf(userId)});
		  if(cursor.moveToNext()) 
		  {
			  cursor.close();
			  return true; 
		  }
		  else 
		  { 
			  cursor.close();
			  return false; 
		  }
	}
	// ע��ɹ���ע����Ϣд��ע���
	public void insertLogin(String userId, String pswd, String result) {
		db = helper.getWritableDatabase();
		String num = "";
		Cursor cursor = null;
		if (result.equals("��ʦ"))
		{
				cursor = db.rawQuery(
						"select teacherNum from teacher where phoneNum=? ",
						new String[] { String.valueOf(userId) });
		} 
		else 
		{
				cursor = db.rawQuery(
						"select parentNum from parent where phoneNum=? ",
						new String[] { String.valueOf(userId) });
				num = cursor.getString(cursor.getColumnIndex("parentNum"));
		}
		db.execSQL("insert into user(phoneNum,password,userType,userNum) values("
				+ String.valueOf(userId)
				+ ","
				+ String.valueOf(pswd)
				+ ","
				+ String.valueOf(result) + "," + String.valueOf(num) + ")");
		cursor.close();
	}

	// �ж�ע��ĵ绰�����Ƿ�ͼҳ������һ��
	public boolean identicalParent(String userId) {
		   db = helper.getWritableDatabase();
		  Cursor  cursor =db.rawQuery("select * from parent where phoneNum=?",
				  new String[]{String.valueOf(userId)}); 
		  if(cursor != null)
		  {
			  cursor.close();
			  return true; 
		  }
		  else 
		  {
			  cursor.close(); 
			  return false; 
		  }
	}

	public Parent selectParent(String userNum) {
		db = helper.getWritableDatabase();
		
		Cursor cursor = db.rawQuery("select * from parent where phoneNum = ?",
				new String[] { userNum });
		Parent parent = new Parent();
		if (cursor.moveToFirst()) {
			parent.setParentNum(cursor.getString(cursor
					.getColumnIndex("parentNum")));
			parent.setParentName(cursor.getString(cursor
					.getColumnIndex("parentName")));
			parent.setParentSex(cursor.getString(cursor
					.getColumnIndex("parentSex")));
			parent.setPhoneNum(cursor.getString(cursor
					.getColumnIndex("phoneNum")));
			parent.setStuNum(cursor.getString(cursor.getColumnIndex("stuNum")));
		}
		cursor.close();
		return parent;
	}

	public Teacher selectTeacher(String userNum) {
		db = helper.getWritableDatabase();
		Cursor cursor = db.rawQuery("select * from teacher where phoneNum = ?",
				new String[] { userNum });
		Teacher teacher = new Teacher();
		if (cursor.moveToFirst()) {
			teacher.setTeacherNum(cursor.getString(cursor
					.getColumnIndex("teacherNum")));
			teacher.setTeacherName(cursor.getString(cursor
					.getColumnIndex("teacherName")));
			teacher.setTeacherSex(cursor.getString(cursor
					.getColumnIndex("teacherSex")));
			teacher.setPhoneNum(cursor.getString(cursor
					.getColumnIndex("phoneNum")));
			teacher.setTeachCourse(cursor.getString(cursor
					.getColumnIndex("teachCourse")));
		}
		cursor.close();
		return teacher;
	}

	public boolean updateParentAccount(String account, String userId) {
		db = helper.getWritableDatabase();
		try {
			db.execSQL("update parent set phoneNum = ? where phoneNum = ? ",new String[]{account,userId});
			db.execSQL("update user set phoneNum = " + account
					+ " where phoneNum = " + userId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean updateParentName(String name, String userId) {
		db = helper.getWritableDatabase();
		try {
			db.execSQL("update parent set parentName = " + name
					+ " where parentNum = " + userId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean updateParentSex(String sex, String userId) {
		db = helper.getWritableDatabase();
		try {
			db.execSQL("update parent set parentSex = " + sex
					+ " where parentNum = " + userId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
