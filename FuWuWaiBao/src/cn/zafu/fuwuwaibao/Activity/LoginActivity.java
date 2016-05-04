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
	        //�������ݿ�
	        ConnectDB db = new ConnectDB(this);
	        
	        findViewById(R.id.login).setOnClickListener(LoginActivity.this);
	        findViewById(R.id.register).setOnClickListener(LoginActivity.this);
	    }

	@Override
	public void onClick(View v) {
		
		int i;
		switch (v.getId()) {
		
		case R.id.login:
			//�û�Id
			EditText userId1 = (EditText)findViewById(R.id.userId);
			String userId = userId1.getText().toString();
			//����
			EditText userPswd1 = (EditText)findViewById(R.id.userPswd);
			String userPswd = userPswd1.getText().toString();

			RadioGroup object =(RadioGroup)findViewById(R.id.object);
			RadioButton button=null;
			
			//�ж�ѡ���ĸ���ѡ��ť
			for(i=0; i<object.getChildCount();i++)
			{
			 button = (RadioButton)object.getChildAt(i);
			   if(button.isChecked())
				   break;
			}
			//������д��Ϣ��ȫ
			if(i == object.getChildCount() || userId.equals("") || userPswd.equals(""))
			{
				AlertDialog.Builder dialog = new AlertDialog.Builder(LoginActivity.this);
				dialog.setTitle("��ʾ");
				dialog.setMessage("����д��¼�˺ź������Լ������Ϣ��");
				dialog.setCancelable(false);
				dialog.setPositiveButton("֪����", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
					}
				});
				dialog.show();
			}
			else 
			{
				//��õ�ѡ��ť���ı�ֵ
				String userType =  button.getText().toString();
				Login lg = new Login(userId, userPswd, userType);
				ConnectDB cDb = new ConnectDB();
				boolean flag = false;
				flag = cDb.isExist(lg);
				//if(flag)
				//{
					//��¼�ɹ�
				Intent intent;
				if(userType.equals("��ʦ"))
					intent = new Intent(this,TeacherPersonalCenterActivity.class);
				else {
					intent = new Intent(this,ParentPersonalCenterActivity.class);
				}	
				intent.putExtra(USERID, userId);
				startActivity(intent);
				/*}
				else
				{
					//δע��
					AlertDialog.Builder dialog = new AlertDialog.Builder(LoginActivity.this);
					dialog.setTitle("��ʾ");
					dialog.setMessage("����û��ע�ᣬ��ע����¼��");
					dialog.setCancelable(false);
					dialog.setPositiveButton("����ע��", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							
							startActivity(new android.content.Intent(LoginActivity.this,RegisterActivity.class));
						}
					});
					dialog.setNegativeButton("֪����,����ȥע��", new DialogInterface.OnClickListener() {
						
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
