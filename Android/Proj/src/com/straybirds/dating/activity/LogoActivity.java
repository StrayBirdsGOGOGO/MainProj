package com.straybirds.dating.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.straybirds.dating.R;

public class LogoActivity extends Activity {

int MSG_INIT_OK = 1;
int MSG_INIT_INFO = 2;
int MSG_INIT_TIMEOUT = 9;
 
boolean isTimeout = false;
private ProgressBar progressBar;  
private Button backButton; 
 
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     // 去除标题  
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);  
        setContentView(R.layout.logo);  
  
        progressBar = (ProgressBar) findViewById(R.id.pgBar);  
        backButton = (Button) findViewById(R.id.btn_back);  
  
        backButton.setOnClickListener(new OnClickListener() {  
  
            @Override  
            public void onClick(View v) {  
                finish();  
  
            }  
        });  
        
        initSystem();
            
    }
    
    private void initSystem(){
    	initThread();
    	mHandler.postDelayed(timeOutTask,60000);//60秒超时
    }
    
    
    public Handler mHandler = new Handler(){     
     public void handleMessage(Message msg){
      if(msg.what == MSG_INIT_TIMEOUT){      
 
       if (mHandler != null && timeOutTask != null ){
    	   mHandler.removeCallbacks(timeOutTask);
       }
       
      	Toast.makeText(LogoActivity.this, "timeout", Toast.LENGTH_LONG).show();
       	LogoActivity.this.finish();
       	
      }else if(msg.what == MSG_INIT_OK){
       
       if (mHandler != null && timeOutTask != null ){
        mHandler.removeCallbacks(timeOutTask);
       }
       
       startActivity(new Intent(getApplication(),MainInterfaceActivity.class));
                LogoActivity.this.finish();
      }else if(msg.what == MSG_INIT_INFO){
       String info = msg.obj.toString();
      }
     }     
    };
    
    /**
     * 定义处理timeout时间的runnable接口
     */
    Runnable timeOutTask = new Runnable() {
		 public void run() {
		   
		   isTimeout = true;
		   
		   Message msg = Message.obtain();
		   msg.what = MSG_INIT_TIMEOUT;
		   mHandler.sendMessage(msg);
		 }    
    };
    
    private void initThread(){
     new Thread(){
      public void run() {
       try {
        if(!isTimeout){
        	sendInitInfo("初始化 step 1");         
        	Thread.sleep(1000);//TODO 1
        }
        
        if(!isTimeout){
         sendInitInfo("初始化 step 2");
         Thread.sleep(2000);//TODO 2        
        }
        
        if(!isTimeout){
         sendInitInfo("初始化 step 3");
         Thread.sleep(3000);//TODO 2
        }
     
     if(!isTimeout){
      //初始化完成
      sendInitInfo("初始化完成");
         
      Message msg2 = Message.obtain();
      msg2.what = MSG_INIT_OK;
      mHandler.sendMessage(msg2);
     }
     
    } catch (InterruptedException e) {
     // TODO Auto-generated catch block
     e.printStackTrace();
    }
      }           
     }.start();
    }

    private void sendInitInfo(String info){
	     Message msg1 = Message.obtain();
	     msg1.what = MSG_INIT_INFO;
	     msg1.obj = info;
	     mHandler.sendMessage(msg1);
    }
}