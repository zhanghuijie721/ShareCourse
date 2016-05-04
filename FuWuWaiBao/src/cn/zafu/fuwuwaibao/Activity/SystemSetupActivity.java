package cn.zafu.fuwuwaibao.Activity;

import cn.zafu.fuwuwaibao.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;

public class SystemSetupActivity extends Activity implements OnClickListener{
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.system_setup);
	        findViewById(R.id.accountManagement).setOnClickListener(this);
	        findViewById(R.id.feedback).setOnClickListener(this);
	        findViewById(R.id.aboutSystem).setOnClickListener(this);
	        findViewById(R.id.setup_img_head).setOnClickListener(this);
	        
	    }

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		//账号管理
		case R.id.accountManagement:
			
			break;
		//意见反馈
		case R.id.feedback:
			
			break;
		//关于系统
		case R.id.aboutSystem:
	
		break;
		//返回上一页面
		case R.id.setup_img_head:
			startActivity(new android.content.Intent(this,ParentPersonalCenterActivity.class));
			break;

		default:
			break;
		}
		
	}

}
