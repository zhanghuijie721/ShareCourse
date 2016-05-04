package cn.zafu.fuwuwaibao.Activity;
import cn.zafu.fuwuwaibao.R;
import cn.zafu.fuwuwaibao.Others.ConnectDB;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;


public class ParentPersonalCenterActivity extends Activity implements OnClickListener {
	
	public final static String USERID = "cn.zafu.fuwuwaibao.Activity.MESSAGE";
	 String userId = "";
	 ConnectDB cDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Intent intent = getIntent();
        userId = intent.getStringExtra(LoginActivity.USERID);
        Toast.makeText(this,userId, Toast.LENGTH_LONG).show();
        
        setContentView(R.layout.parent_personal_center);
        findViewById(R.id.head_portrait).setOnClickListener(this);
        findViewById(R.id.Seting).setOnClickListener(this);
        findViewById(R.id.comment).setOnClickListener(this);
        findViewById(R.id.newMessage).setOnClickListener(this);
        findViewById(R.id.myCollection).setOnClickListener(this);
        findViewById(R.id.btn_exit).setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
    	switch (v.getId()) {
    	//详情
		case R.id.head_portrait:
			Intent intent = new Intent(this,ParentDetailedInformationActivity.class);
			intent.putExtra(USERID, userId);
			startActivity(intent);
			
			break;
		//设置
		case R.id.Seting:
			startActivity(new android.content.Intent(this,SystemSetupActivity.class));
			break;
			
			//我评论的
		case R.id.comment:
		
			break;
			//新消息
		case R.id.newMessage:
			break;
			//我的收藏
		case R.id.myCollection:
			break;
			//退出系统
		case R.id.btn_exit:
			startActivity(new android.content.Intent(this,LoginActivity.class));
			break;
		default:
			break;
		}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
