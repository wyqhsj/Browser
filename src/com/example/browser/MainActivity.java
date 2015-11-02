package com.example.browser;



import android.R.integer;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	private WebView webView;
	Button home;
	Button go;
	String url_text;
	String url_head = "http://";
	EditText url;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    
    {
    	// ���ر�����.
    			requestWindowFeature(Window.FEATURE_NO_TITLE);		
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
      //////////////
        //�ҵ�view��home id
        home=(Button)findViewById(R.id.home);
        //����home button�ĵ���¼�
        home.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
		webView.loadUrl(" http://shaodalovewall.sinaapp.com/w/");
				
			}
		});
       /////////// 
        //�ҵ�go ��ť��id
        //�ҵ�edit ��ť��id
        go=(Button)findViewById(R.id.go);
        url=(EditText)findViewById(R.id.urltext);
        //���� button�ĵ���¼�
        go.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
			url_text=url.getText().toString();
			if(!url_text.contains("http://")){
				url_text=url_head.concat(url_text);	
			}
			//�����޸�����.com
			webView.loadUrl(url_text+".com");
		
				
			}
		});
        
        
        /////////// 
        webView = (WebView) findViewById(R.id.webView);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.setWebViewClient(new WebViewClient() {
			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				
				view.loadUrl(url);
			
				return true;
			}
		});
		webView.loadUrl("http://m.hao123.com");
    
    }

    
    
    
    
//���ؼ��Ĵ���:���Ǵ򿪶����ҳ��,�������Ŀ���Ƿ�����һ����ҳ,
    //������ʵ�ϻ�رյ�ǰactivity,����Ҫ�Է��ؼ�������
    public boolean onKeyDown(int keyCode, KeyEvent event) {  
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {  
            webView.goBack();  
            return true;  
        } else  
            return super.onKeyDown(keyCode, event);  
    }  
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        getMenuInflater().inflate(R.menu.first, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
    	case R.id.add_item:
    	Toast.makeText(this, "You clicked Add", Toast.LENGTH_SHORT).show();
    	break;
    	case R.id.close:
    		//�˳�app
    		finish();
    	//Toast.makeText(this, "You clicked Remove", Toast.LENGTH_SHORT).show();
    	break;
    	default:
    	}
    	return true;
    }


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}





    
}
