package cn.zafu.fuwuwaibao.Activity;

import cn.zafu.fuwuwaibao.R;
import cn.zafu.fuwuwaibao.Others.ConnectDB;
import cn.zafu.fuwuwaibao.Others.Login;
import android.R.integer;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;



public class LoginActivity extends Activity implements android.view.View.OnClickListener{
	String object="";
	public final static String USERID = "cn.zafu.fuwuwaibao.Activity.MESSAGE";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.login);
	        //创建数据库
	        ConnectDB db = new ConnectDB(this);
	        
	        findViewById(R.id.login).setOnClickListener(LoginActivity.this);
	        findViewById(R.id.register).setOnClickListener(LoginActivity.this);
	    }

	@Override
	public void onClick(View v) {
		
		int i;
		switch (v.getId()) {
		
		case R.id.login:
			//用户Id
			EditText userId1 = (EditText)findViewById(R.id.userId);
			String userId = userId1.getText().toString();
			//密码
			EditText userPswd1 = (EditText)findViewById(R.id.userPswd);
			String userPswd = userPswd1.getText().toString();

			RadioGroup object =(RadioGroup)findViewById(R.id.object);
			RadioButton button=null;
			
			//判断选择哪个单选按钮
			for(i=0; i<object.getChildCount();i++)
			{
			 button = (RadioButton)object.getChildAt(i);
			   if(button.isChecked())
				   break;
			}
			//处理填写信息不全
			if(i == object.getChildCount() || userId.equals("") || userPswd.equals(""))
			{
				AlertDialog.Builder dialog = new AlertDialog.Builder(LoginActivity.this);
				dialog.setTitle("提示");
				dialog.setMessage("请填写登录账号和密码以及身份信息！");
				dialog.setCancelable(false);
				dialog.setPositiveButton("知道了", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
					}
				});
				dialog.show();
			}
			else 
			{
				//获得单选按钮的文本值
				String userType =  button.getText().toString();
				Login lg = new Login(userId, userPswd, userType);
				ConnectDB cDb = new ConnectDB();
				boolean flag = false;
				flag = cDb.isExist(lg);
				//if(flag)
				//{
					//登录成功
				Intent intent;
				if(userType.equals("教师"))
					intent = new Intent(this,TeacherPersonalCenterActivity.class);
				else {
					intent = new Intent(this,ParentPersonalCenterActivity.class);
				}	
				intent.putExtra(USERID, userId);
				startActivity(intent);
				/*}
				else
				{
					//未注册
					AlertDialog.Builder dialog = new AlertDialog.Builder(LoginActivity.this);
					dialog.setTitle("提示");
					dialog.setMessage("您还没有注册，请注册后登录！");
					dialog.setCancelable(false);
					dialog.setPositiveButton("现在注册", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							
							startActivity(new android.content.Intent(LoginActivity.this,RegisterActivity.class));
						}
					});
					dialog.setNegativeButton("知道了,等下去注册", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
						}
					});
					dialog.show();
					
				}*/
			}
			break;
		case R.id.register:
			startActivity(new android.content.Intent(this,RegisterActivity.class));
			break;
		default:
			break;
		}
		
	}

}
