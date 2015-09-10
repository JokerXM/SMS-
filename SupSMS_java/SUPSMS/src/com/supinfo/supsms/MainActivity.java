package com.supinfo.supsms;



import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

	private EditText ausername;
	private EditText apassword;
	//private String password;
	//private String username;
	private Button botton;
	private JSONObject jo;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("debug", "create now");
        
        this.apassword=(EditText)findViewById(R.id.apassword);
        this.ausername=(EditText)findViewById(R.id.ausername);
        this.botton = (Button) findViewById(R.id.loginbutten);
        //this.password=apassword.getText().toString();
        //this.username=ausername.getText().toString();
        
        Log.v("give data", "ok!");
        
        
       
       
        
    }
    
    
    public void login(View v){
    	
    	 RequestParams requestparams = new RequestParams();
    	 String username = ausername.getText().toString();
    	 String password = apassword.getText().toString();
    	 Log.v("1111", username);
    	 Log.v("2222", password);
     	requestparams.put("action", "login");
     	requestparams.put("login", username);
     	requestparams.put("password", password);
     	
     	Log.v("give params", "success!");
    	AsyncHttpClient client = new AsyncHttpClient();
    	
     	client.post("http://91.121.105.200/API/", requestparams, new JsonHttpResponseHandler()

     	{
     		 @Override  
             public void onSuccess(JSONObject jsonObject) {  
                 super.onSuccess(jsonObject);  
                 jo= jsonObject;
                 Log.v("1111", "11111111111111");
                 String hehe="meichuan";
				try {
					hehe = jo.getJSONObject("user").getString("username");
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                 Log.v("1222",hehe );
                 try {
					if(jo.getBoolean("success"))
					 {
						
						Intent intent = new Intent(MainActivity.this, LoginActivity.class);
				    	MainActivity.this.startActivity(intent);
						Log.v("1111", "11111111111111");
						//gotologin("admin", "admin"); 
						
						gotologin(jo.getJSONObject("user").getString("username"), jo.getJSONObject("user").getString("password"));
						Log.v("1111", "ok");
					 }
					else{ Log.v("1111", "failed");}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                   
             }  
     	});
    }

   /*  		 @Override  
              public void onSuccess( JSONArray timeline) {  
     			 
     			 JSONObject firstEvent = null;
				try {
					Log.v("jason", "ok");
					firstEvent = (JSONObject) timeline.get(0);
				} catch (JSONException e2) {
					// TODO Auto-generated catch block
					Log.v("jason", "failed!");
					e2.printStackTrace();
				}
                 String success = null;
				try {
					Log.v("getsuceess", "ok!");
					success = firstEvent.getString("success");
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					Log.v("getsuceess", "failed!");
					e1.printStackTrace();
				}

                 // Do something with the response
     			 
     			 
     			 Log.v("send to network", "ok");
     			 
     				 Log.v("network", "success!");
     				 if(success.equals(true) )
					 {
						Log.v("check", "success!");
// 							gotologin(this.username, this.password);
					 }
     			 

              } 
     			 
     	});*/
     		 
       
    private void gotologin(String username,String password)
    {
    	
    	
    	Log.v("2222", "11111111111111");
    	Intent intent = new Intent(MainActivity.this, LoginActivity.class);
    	intent.putExtra("username", username);
    	intent.putExtra("password", password);
    	MainActivity.this.startActivity(intent);
    	
    }
    
}
