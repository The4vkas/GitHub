package com.team4.buyfresh;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class passchange extends Activity {
	
	EditText e1,e2,e3;
	Button b1,b2;
	String value1;
	JSONParser jsonParser = new JSONParser();
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.passchange);
	e1=(EditText) findViewById(R.id.editText1);
	e2=(EditText) findViewById(R.id.editText2);
	e3=(EditText) findViewById(R.id.editText3);
	
	Bundle extras= getIntent().getExtras();
	value1= extras.getString("tag");
	e1.setText(value1);
	
	b1=(Button) findViewById(R.id.button1);
	b2=(Button) findViewById(R.id.button2);
	
	b2.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			startActivity(new Intent(passchange.this, LoginActivity.class));
		}
		
	});
	
	
	
	b1.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			String w= e1.getText().toString();
			String q= e2.getText().toString();
			String t= e3.getText().toString();
			Log.d("inside e1:", w);
			Log.d("inside e2:", q);
			Log.d("inside e3:", t);
			
			 if (q.toString().equals(t.toString()))
			  {  
			     //save phoneno and verification code in database
				    List<NameValuePair> params = new ArrayList<NameValuePair>();
					params.add(new BasicNameValuePair("phoneno",value1.trim()));
					params.add(new BasicNameValuePair("password",q.trim()));
					Log.d("inside:", value1);
					Log.d("inside:", q);
					JSONObject jsons = jsonParser.makeHttpRequest("http://10.0.2.2:8080/buyfresh/password_change.php","POST", params);
					Log.d("checking jsons",jsons.toString());
				//display second page
				Toast.makeText(getApplicationContext(), "Password has been changed", Toast.LENGTH_SHORT).show();
				//Intent in = new Intent(Mobile_verify.this,MainActivity.class);
				//in.putExtra("phoneno",phoneno);
	            //startActivity(in); 
				e2.setText("");
				e3.setText("");
				
			}
			else
			{
			  Toast.makeText(getApplicationContext(), "Password Mismatch", Toast.LENGTH_SHORT).show();
			 					
			}
			
		}
			
		
	});
	

}
}
