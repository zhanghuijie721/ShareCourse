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
	
	String result = "��ʦ";
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
			//���ص�¼ҳ��
			startActivity(new android.content.Intent(this,LoginActivity.class));
			break;
		case R.id.register1:
			    Spinner spinner = (Spinner)findViewById(R.id.spinner);
		        spinner.getSelectedItem();
		        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
					@Override
					public void onItemSelected(AdapterView<?> parent, View v,
							int pos, long id) {
						result = parent.getItemAtPosition(pos).toString();//��ȡѡ�����ֵ
					}
					@Override
					public void onNothingSelected(AdapterView<?> arg0) {
					}
				});
		        //��ϵ��ʽ
		   EditText userId1 = (EditText) findViewById(R.id.Name1);
		   String userId = userId1.getText().toString();
		   //����
		   EditText pswd1 = (EditText) findViewById(R.id.pswd1);
		   String pswd = pswd1.getText().toString();
		   //�ظ�����
		   EditText pswd2 = (EditText) findViewById(R.id.pswd2);
		   String rpswd = pswd2.getText().toString();
		   //����������벻ͬ
		   if(!pswd.equals(rpswd))
		   {
			   AlertDialog.Builder dialog = new AlertDialog.Builder(RegisterActivity.this);
				dialog.setTitle("��ʾ");
				dialog.setMessage("�뱣������������ͬ��");
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
			   //�ж��Ƿ�ע��
			   Login lg = new Login(userId, pswd, result);
			   if(cDb.isExist(lg))
			   {
				   //�Ѿ�ע��
				   AlertDialog.Builder dialog = new AlertDialog.Builder(RegisterActivity.this);
					dialog.setTitle("��ʾ");
					dialog.setMessage("���û���ע�ᣬ�Ƿ����̵�¼��");
					dialog.setCancelable(false);
					dialog.setPositiveButton("��", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							startActivity(new android.content.Intent(RegisterActivity.this,LoginActivity.class));
						}
					});
					dialog.setNegativeButton("��", new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
						}
					});
					dialog.show();
			   }
			   else 
			   {
			   Toast.makeText(RegisterActivity.this, result, Toast.LENGTH_LONG).show();
				   //�ж�ע��ĵ绰�����Ƿ�ͽ�ʦ�����һ��
				   if(cDb.identicalTeacher(userId)||cDb.identicalParent(userId))
				   {
					   try {
						   cDb.insertLogin(userId,pswd,result); 
						   //��ʾ��
						    AlertDialog.Builder dialog = new AlertDialog.Builder(RegisterActivity.this);
							dialog.setTitle("��ʾ");
							dialog.setMessage("ע��ɹ�");
							dialog.setCancelable(false);
							dialog.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
								
								@Override
								public void onClick(DialogInterface dialog, int which) {
								}
							});
							dialog.show();
					} catch (Exception e) {
						//ע��ʧ��
						 //��ʾ��
					    AlertDialog.Builder dialog = new AlertDialog.Builder(RegisterActivity.this);
						dialog.setTitle("��ʾ");
						dialog.setMessage("ע��ʧ��");
						dialog.setCancelable(false);
						dialog.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
							
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
						dialog.setTitle("��ʾ");
						dialog.setMessage("ע��ʧ��");
						dialog.setCancelable(false);
						dialog.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
							
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
