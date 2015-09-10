package com.supinfo.supsms;

import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import bean.contacts;
import bean.sms;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

public class SavesmsActivity extends Activity{
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savesms);
        Log.v("debug", "create now");
 
        
       
       
        
    }

	 private void gotosuccess() {
			// TODO Auto-generated method stub
		 Log.v("debug", "success");
			 Toast.makeText(this, "success", Toast.LENGTH_LONG).show();
			 Intent intent = new Intent(this, LoginActivity.class);
		    startActivity(intent);
		    
		}  
	    public void savesms(View v) {

	    	 Log.v("sms", "ok0000");
	    	
	    	sms s = new sms();
	    	s.setContent(((EditText)findViewById(R.id.content)).getContext().toString());
	    	 Log.v("sms", "ok0001");
	    	s.setRecieve(((EditText)findViewById(R.id.reciever)).getContext().toString());
	    	 Log.v("sms", "ok0002");
	    	s.setIfread("no");
	    	s.setSend("admin");
	    	
	    	Gson gson = new Gson();
	    	String json = gson.toJson(s);
	    	
	    	 Log.v("sms", "ok111");
	    	
	/*		 JSONObject contact;
			 JSONArray contacts=new JSONArray();
			 contact = new JSONObject();
	        try {
	            contact.put("sms", s);
	        } catch (JSONException e) {
	            e.printStackTrace();
	        }
	        contacts.put(contact);*/
	        
	        RequestParams requestparams = new RequestParams();
	      	
	      	requestparams.add("action", "backupsms");
	      	requestparams.add("box", "sent");
	      	requestparams.add("login", "admin");
	      	requestparams.add("password", "admin");
	      	requestparams.add("sms", json);
	      	
	      	Log.v("sms", "ok222");
	      	
	      	
	      	AsyncHttpClient client = new AsyncHttpClient();
	    	
	     	client.post("http://91.121.105.200/API/", requestparams, new JsonHttpResponseHandler()

	     	{
	     		 @Override  
	             public void onSuccess(JSONObject jsonObject) {  
	                 super.onSuccess(jsonObject);  
	                 JSONObject jo= jsonObject;
	                 
	                 try {
						if(jo.getBoolean("success"))
						 {
							 gotosuccess();
						 }
						else gotofail();
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                   
	             }

				

				
	     	});
	      	
	      	
	    	
	       
		 
	    }
	    
	    private void gotofail() {
			// TODO Auto-generated method stub
	    	 Log.v("debug", "fail");
	    	Toast.makeText(this, "fail", Toast.LENGTH_LONG).show();
	    	Intent intent = new Intent(this, LoginActivity.class);
	    	startActivity(intent);
	    	
		}

}
