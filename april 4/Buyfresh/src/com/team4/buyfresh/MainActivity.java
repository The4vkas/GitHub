package com.team4.buyfresh;


import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;


import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	JSONParser jsonParser = new JSONParser();
	 Button submit,vsubmit;
	  
	 EditText v_code; 
	 String phoneno,gen_vcode,vno,username,pass,repass,email,area,pincode;
	 	static String code,result;
	 // JSON Node names
	 //private static final String TAG_MESSAGE = "message";
	 private static final String TAG_CODE = "getcode";
	 protected void onCreate(Bundle savedInstanceState) 
	 {
		    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

		    StrictMode.setThreadPolicy(policy); 

			super.onCreate(savedInstanceState);

			setContentView(R.layout.activity_main);
			
			vsubmit=(Button) findViewById(R.id.submit);
			v_code=(EditText) findViewById(R.id.editverify);
			
			addListenerOnButton();
			
		  
	}
	private void addListenerOnButton()
	{
		// TODO Auto-generated method stub
		
		submit=(Button) findViewById(R.id.regdone);
		submit.setOnClickListener(new OnClickListener() {
			
	 
			@Override
			public void onClick(View v) {
				//Comparing  password & re password
				pass= ((EditText) findViewById(R.id.editpass)).getText().toString();
				repass=((EditText) findViewById(R.id.editrepass)).getText().toString();
				if(pass.equals(repass))
				{
				    phoneno  = ((EditText) findViewById(R.id.editmobileno)).getText().toString();
			        Log.e("inside",phoneno.toString());
				    List<NameValuePair> param = new ArrayList<NameValuePair>();
					param.add(new BasicNameValuePair("phoneno",phoneno.trim()));
					JSONObject jsons = jsonParser.makeHttpRequest("http://10.0.2.2:8080/buyfresh/user_registration.php","GET", param);
	                Log.d("checking jsons",jsons.toString());
	                       	

	            	try {
						 //getting success value and generated code 
						 
						   code=jsons.getString(TAG_CODE);
				           String c1="1";
				           Log.d("verification code:",code.toString());
				           sendvalue(code);
				           
				           
							if (code.equals(c1))
							  {
								//USE TOAST//
								
								Toast.makeText(getApplicationContext(), "You are already registered" , Toast.LENGTH_SHORT).show();
								   
							  }else 
							  { 
								 
							     //USE TOAST//
						    	
						    	 Toast.makeText(getApplicationContext(), "plz enter your verification code" , Toast.LENGTH_SHORT).show();
								 v_code.setVisibility(View.VISIBLE);
								 vsubmit.setVisibility(View.VISIBLE);
							  }
						 
					    } catch (JSONException e) 
					       {
							//TODO Auto-generated catch block
							e.printStackTrace();
					       }
				}else
				{
					Toast.makeText(getApplicationContext(), "Password Doesnt match", Toast.LENGTH_LONG).show();
				}
				
				 
			}  
	 
		});
		vsubmit=(Button) findViewById(R.id.submit);
	    vsubmit.setOnClickListener(new View.OnClickListener() {
	    	
			@Override
			public void onClick(View v) {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                
				// TODO Auto-generated method stub
				username=((EditText) findViewById(R.id.editname)).getText().toString();
				vno = ((EditText) findViewById(R.id.editverify)).getText().toString();
				pass= ((EditText) findViewById(R.id.editpass)).getText().toString();
				repass=((EditText) findViewById(R.id.editrepass)).getText().toString();
				email=((EditText) findViewById(R.id.editemail)).getText().toString();
				area=((EditText) findViewById(R.id.editarea)).getText().toString();
				pincode=((EditText) findViewById(R.id.editpin)).getText().toString();
				
				 if (vno.equals(result))
				  {  
				     //save phoneno and verification code in database
					    List<NameValuePair> params = new ArrayList<NameValuePair>();
						params.add(new BasicNameValuePair("phoneno",phoneno.trim()));
						params.add(new BasicNameValuePair("vno",vno.trim()));
						params.add(new BasicNameValuePair("username",username.trim()));
						params.add(new BasicNameValuePair("pass",pass.trim()));
						params.add(new BasicNameValuePair("email",email.trim()));
						params.add(new BasicNameValuePair("area",area.trim()));
						params.add(new BasicNameValuePair("pincode",pincode.trim()));
						JSONObject jsons = jsonParser.makeHttpRequest("http://10.0.2.2/buyfresh/insert_userdata1.php","POST", params);
		                Log.d("checking jsons",jsons.toString());
					//display second page
					Toast.makeText(getApplicationContext(), "working", Toast.LENGTH_SHORT).show();
					//Intent in = new Intent(Mobile_verify.this,MainActivity.class);
					//in.putExtra("phoneno",phoneno);
		            //startActivity(in); 
					
				}
				else
				{
				  Toast.makeText(getApplicationContext(), "invalid code", Toast.LENGTH_SHORT).show();
				 					
				}
				
				
				
			}
	    	
	    });
	}
	public void sendvalue(String a)
	{
	 result= a;
	 
	}

		
					    
	}
	 
