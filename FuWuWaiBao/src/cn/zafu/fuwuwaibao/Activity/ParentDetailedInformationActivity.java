package cn.zafu.fuwuwaibao.Activity;

import cn.zafu.fuwuwaibao.R;
import cn.zafu.fuwuwaibao.Others.ConnectDB;
import cn.zafu.fuwuwaibao.Others.Parent;
import cn.zafu.fuwuwaibao.Others.Teacher;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ParentDetailedInformationActivity extends Activity implements OnClickListener {
	 
	private TextView userId,Account,userName,userSex,stuNum;
	private ConnectDB cDb;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.parent_detailed_information);
        //��ȡ��¼�ߵ���Ϣ
        Intent intent = getIntent();
        String userNum = intent.getStringExtra(ParentPersonalCenterActivity.USERID); 
        Parent parent = new Parent();
        //parent = cDb.selectParent(userNum);
    
        Toast.makeText(this,intent.getStringExtra(ParentPersonalCenterActivity.USERID) , Toast.LENGTH_LONG).show();
        userId = (TextView) findViewById(R.id.userId2);
       // userId.setText(parent.getParentNum());
       
        //�û��˺�/��ϵ��ʽ
      	Account = (TextView) findViewById(R.id.userAccount2);
      	Account.setText(userNum);
      	
      	userName = (TextView) findViewById(R.id.userName2);
      	//userName.setText(parent.getParentName());
      	
      	userSex = (TextView) findViewById(R.id.userSex2);
      	//userSex.setText(parent.getParentSex());
      	
      	stuNum = (TextView) findViewById(R.id.stuNum2);
      	//stuNum.setText(parent.getStuNum());
      	
        findViewById(R.id.img_head).setOnClickListener(this);
        findViewById(R.id.userAccount).setOnClickListener(this);
        findViewById(R.id.userName).setOnClickListener(this);
        findViewById(R.id.userSex).setOnClickListener(this);
        findViewById(R.id.stuNum).setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		final EditText et = new EditText(this);
		
		switch (v.getId()) {
		//������һҳ��
		case R.id.img_head:
			startActivity(new android.content.Intent(this, ParentPersonalCenterActivity.class));
			break;
		//�û��˺�/��ϵ��ʽ
		case R.id.userAccount:
		    new AlertDialog.Builder(this).setTitle("��������ϵ��ʽ��")  
			            .setIcon(android.R.drawable.ic_dialog_info).setView(et)  
			            .setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {  
			                    @Override  
			                    public void onClick(DialogInterface arg0, int arg1) {
			                    	
			                    	Toast.makeText(ParentDetailedInformationActivity.this,Account.getText().toString(), Toast.LENGTH_LONG).show();
			                    	
			                    	if(cDb.updateParentAccount(et.getText().toString(),Account.getText().toString()))
			                    	{
			                    	 Account.setText(et.getText().toString());
			                    	}
			                    	else
			                    	{
			                    		AlertDialog.Builder dialog = new AlertDialog.Builder(ParentDetailedInformationActivity.this);
			            				dialog.setTitle("��ʾ");
			            				dialog.setMessage("�޸�ʧ�ܣ�����ϵ��ʽ�Ѿ�����ʹ�ã�");
			            				dialog.setCancelable(false);
			            				dialog.setPositiveButton("֪����", new DialogInterface.OnClickListener() {
			            					
			            					@Override
			            					public void onClick(DialogInterface dialog, int which) {
			            					}
			            				});
			            				dialog.show();
									}
			                    	
			                    	        		
			             }  
			       }).setNegativeButton("ȡ��", null).show();  

			break;
			//�û���
		case R.id.userName:
		    new AlertDialog.Builder(this).setTitle("�������û�����")  
			            .setIcon(android.R.drawable.ic_dialog_info).setView(et)  
			            .setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {  
			                    @Override  
			                    public void onClick(DialogInterface arg0, int arg1) {
			                    	if(cDb.updateParentName(et.getText().toString(),userId.getText().toString()))
			                    		{
			                    			userName.setText(et.getText().toString());
			                    		}
			                    	else 
			                    	{
			                    		AlertDialog.Builder dialog = new AlertDialog.Builder(ParentDetailedInformationActivity.this);
			            				dialog.setTitle("��ʾ");
			            				dialog.setMessage("�޸�ʧ�ܣ�");
			            				dialog.setCancelable(false);
			            				dialog.setPositiveButton("֪����", new DialogInterface.OnClickListener() {
			            					
			            					@Override
			            					public void onClick(DialogInterface dialog, int which) {
			            					}
			            				});
			            				dialog.show();
									}
			                    	Toast.makeText(ParentDetailedInformationActivity.this, et.getText().toString(), Toast.LENGTH_LONG).show();        		
			                    }  
			       }).setNegativeButton("ȡ��", null).show();  
			break;
			//�û��Ա�
		case R.id.userSex:
			 new AlertDialog.Builder(this).setTitle("�������û�����")  
	            .setIcon(android.R.drawable.ic_dialog_info).setView(et)  
	            .setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {  
	                    @Override  
	                    public void onClick(DialogInterface arg0, int arg1) {
	                    	if(cDb.updateParentSex(et.getText().toString(),userId.getText().toString()))
	                    	{
	                    		userSex.setText(et.getText().toString());
	                    	}
	                    	else
	                    	{
	                    		AlertDialog.Builder dialog = new AlertDialog.Builder(ParentDetailedInformationActivity.this);
	            				dialog.setTitle("��ʾ");
	            				dialog.setMessage("�޸�ʧ�ܣ�");
	            				dialog.setCancelable(false);
	            				dialog.setPositiveButton("֪����", new DialogInterface.OnClickListener() {
	            					
	            					@Override
	            					public void onClick(DialogInterface dialog, int which) {
	            					}
	            				});
	            				dialog.show();
							}
	                    	Toast.makeText(ParentDetailedInformationActivity.this, et.getText().toString(), Toast.LENGTH_LONG).show();        		
	             }  
	       }).setNegativeButton("ȡ��", null).show();  
			break;
		}
	}

}
