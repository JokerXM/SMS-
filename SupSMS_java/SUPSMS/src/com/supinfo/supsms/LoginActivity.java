package com.supinfo.supsms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends Activity{
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    
    
    public void logout(View v){
    	Intent intent = new Intent(LoginActivity.this, MainActivity.class);
    	startActivity(intent);
    }

    public void backupsms(View v){
    	
    	Intent intent = new Intent(LoginActivity.this, SavesmsActivity.class);
    	startActivity(intent);
    	
    	
    }
    
 public void backupcontacts(View v){
    	
    	Intent intent = new Intent(LoginActivity.this, SavecontactsActivity.class);
    	startActivity(intent);
    	
    	
    }
}
