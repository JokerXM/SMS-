package com.supinfo.supsms;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import bean.contacts;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SavecontactsActivity extends Activity{

	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savecontacts);
        Log.v("debug", "create now");
 
        
       
       
        
    }
    private void gotosuccess() {
		// TODO Auto-generated method stub
		 Toast.makeText(this, "success", Toast.LENGTH_LONG).show();
		 Log.v("debug", "success");
		 Intent intent = new Intent(this, LoginActivity.class);
	    	startActivity(intent);
	}  
    public void savecontacts(View v) {
    	
    	
    	contacts c = new contacts();
    	c.setFirstname(((EditText)findViewById(R.id.firstname)).getContext().toString());
    	c.setLastname(((EditText)findViewById(R.id.lastname)).getContext().toString());
    	c.setPhonenumber(((EditText)findViewById(R.id.phonenumber)).getContext().toString());
    	c.setPostaladdress(((EditText)findViewById(R.id.postaladdress)).getContext().toString());
    	c.setEmail(((EditText)findViewById(R.id.email)).getContext().toString());
    	
    	
    	Gson gson = new Gson();
    	String json = gson.toJson(c);
    	
    	
	/*	 JSONObject contact;
		 JSONArray contacts=new JSONArray();
		 contact = new JSONObject();
        try {
            contact.put("contacts", c);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        contacts.put(contact);*/
        
        RequestParams requestparams = new RequestParams();
      	
      	requestparams.add("action", "backupcontacts");
      	requestparams.add("login", "admin");
      	requestparams.add("password", "admin");
      	requestparams.add("contacts", json);
      	
      	Log.v("param", "ok");
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
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                   
             }

			
     	});
      	
      	
    	
       
	 
    }

		 
}
