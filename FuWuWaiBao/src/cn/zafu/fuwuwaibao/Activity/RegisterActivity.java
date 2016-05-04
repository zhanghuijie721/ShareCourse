package cn.zafu.fuwuwaibao.Activity;

import cn.zafu.fuwuwaibao.R;
import cn.zafu.fuwuwaibao.Others.ConnectDB;
import cn.zafu.fuwuwaibao.Others.Login;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;


public class RegisterActivity extends Activity implements OnClickListener{
	
	String result = "教师";
	ConnectDB cDb = new ConnectDB();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.register);
	        findViewById(R.id.return1).setOnClickListener(this);
	        findViewById(R.id.register1).setOnClickListener(this);
	    }

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.return1:
			//返回登录页面
			startActivity(new android.content.Intent(this,LoginActivity.class));
			break;
		case R.id.register1:
			    Spinner spinner = (Spinner)findViewById(R.id.spinner);
		        spinner.getSelectedItem();
		        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
					@Override
					public void onItemSelected(AdapterView<?> parent, View v,
							int pos, long id) {
						result = parent.getItemAtPosition(pos).toString();//获取选择项的值
					}
					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
					}
				});
		        //联系方式
		   EditText userId1 = (EditText) findViewById(R.id.Name1);
		   String userId = userId1.getText().toString();
		   //密码
		   EditText pswd1 = (EditText) findViewById(R.id.pswd1);
		   String pswd = pswd1.getText().toString();
		   //重复密码
		   EditText pswd2 = (EditText) findViewById(R.id.pswd2);
		   String rpswd = pswd2.getText().toString();
		   //如果两次密码不同
		   if(!pswd.equals(rpswd))
		   {
			   AlertDialog.Builder dialog = new AlertDialog.Builder(RegisterActivity.this);
				dialog.setTitle("提示");
				dialog.setMessage("请保持两个密码相同！");
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
			   //判断是否注册
			   Login lg = new Login(userId, pswd, result);
			   if(cDb.isExist(lg))
			   {
				   //已经注册
				   AlertDialog.Builder dialog = new AlertDialog.Builder(RegisterActivity.this);
					dialog.setTitle("提示");
					dialog.setMessage("该用户已注册，是否立刻登录？");
					dialog.setCancelable(false);
					dialog.setPositiveButton("是", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							startActivity(new android.content.Intent(RegisterActivity.this,LoginActivity.class));
						}
					});
					dialog.setNegativeButton("否", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
						}
					});
					dialog.show();
			   }
			   else 
			   {
			   Toast.makeText(RegisterActivity.this, result, Toast.LENGTH_LONG).show();
				   //判断注册的电话号码是否和教师表里的一致
				   if(cDb.identicalTeacher(userId)||cDb.identicalParent(userId))
				   {
					   try {
						   cDb.insertLogin(userId,pswd,result); 
						   //提示框
						    AlertDialog.Builder dialog = new AlertDialog.Builder(RegisterActivity.this);
							dialog.setTitle("提示");
							dialog.setMessage("注册成功");
							dialog.setCancelable(false);
							dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
								
								@Override
								public void onClick(DialogInterface dialog, int which) {
								}
							});
							dialog.show();
					} catch (Exception e) {
						//注册失败
						 //提示框
					    AlertDialog.Builder dialog = new AlertDialog.Builder(RegisterActivity.this);
						dialog.setTitle("提示");
						dialog.setMessage("注册失败");
						dialog.setCancelable(false);
						dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
							}
						});
						dialog.show();
					}
					
				   }
				   else 
				   {
					    AlertDialog.Builder dialog = new AlertDialog.Builder(RegisterActivity.this);
						dialog.setTitle("提示");
						dialog.setMessage("注册失败");
						dialog.setCancelable(false);
						dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
							}
						});
						dialog.show();
			    	}
			   }
		   }
			break;
		default:
			break;
		}
		
	}

}
