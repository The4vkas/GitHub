package com.team4.buyfresh;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class forgetpass extends Activity {
	Button ok,back;
	EditText mobi;
	String value1;
	TextView e2,e3,e4;
	JSONParser jsonParser = new JSONParser();
	static String code,result;
	private static final String tag_password="password";
	private static String TAG_GET = "getcode";
	private static final String TAG = "DialogActivity";
    private static final int DLG_EXAMPLE1 = 0;
    private static final int TEXT_ID = 0;
    private static final String TAG_SUCCESS = "success";
	private static final String TAG_PRODUCT = "product";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.forgetpas);
		
		ok= (Button) findViewById(R.id.button1);
		mobi= (EditText) findViewById(R.id.editText1);
		e2=(TextView) findViewById(R.id.textView2);
		e3=(TextView) findViewById(R.id.textView3);
		e4=(TextView) findViewById(R.id.textView4);
		
		e2.setVisibility(View.GONE);
		e3.setVisibility(View.GONE);
		e4.setVisibility(View.GONE);
		
		Bundle extras= getIntent().getExtras();
		value1= extras.getString("tag");

				
		mobi.setText(value1);
		
		ok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
				// TODO Auto-generated method stub
			
				String phoneno	= mobi.getText().toString();
								
				Log.d("inside:", phoneno);
				   
				    List<NameValuePair> param = new ArrayList<NameValuePair>();
					param.add(new BasicNameValuePair("phoneno",phoneno.trim()));
					JSONObject jsons = jsonParser.makeHttpRequest("http://10.0.2.2:8080/buyfresh/forget_verfication.php","GET", param);
	                Log.d("checking jsons",jsons.toString());
	                       	

	            	try {
						 //getting success value and generated code 
						 
						   code=jsons.getString(TAG_GET);
				           String c1="1";
				           Log.d("verification code:",code.toString());
				           sendvalue(code);
				           
				           
							if (code.equals(c1))
							  {
								//USE TOAST//
								
								Toast.makeText(getApplicationContext(), "Invalid User" , Toast.LENGTH_SHORT).show();
								   
							  }else 
							  { 
								 
							     //USE TOAST//
								  showDialog(DLG_EXAMPLE1);
						    	
						    	 Toast.makeText(getApplicationContext(), "plz enter your verification code" , Toast.LENGTH_SHORT).show();
									
							  }
						 
					    } catch (JSONException e) 
					       {
							//TODO Auto-generated catch block
							e.printStackTrace();
					       }
	            
		
			}});
		back= (Button) findViewById(R.id.button2);
		back.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				startActivity(new Intent(forgetpass.this, LoginActivity.class));
			}
		});
		
		e4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String phoneno	= mobi.getText().toString();
		startActivity(new Intent(forgetpass.this, passchange.class));
		Intent inte= new Intent(getBaseContext(),passchange.class);
		inte.putExtra("tag", phoneno);
		startActivity(inte);
			}
		});
	
		
	}
	
	@Override
    protected Dialog onCreateDialog(int id) {
 
        switch (id) {
            case DLG_EXAMPLE1:
                return createExampleDialog();
            default:
                return null;
        }
    }
   
private Dialog createExampleDialog() {
	// TODO Auto-generated method stub
	
	  AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Verfication Code");
        builder.setMessage("Please Enter Your Verification Code:");
 
         // Use an EditText view to get user input.
         final EditText input = new EditText(this);
         input.setId(TEXT_ID);
         builder.setView(input);
 
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
 
            @Override
            public void onClick(DialogInterface dialog, int whichButton) {
                String value = input.getText().toString();
            	Log.d(TAG, "User name: " + value);
            	String phoneno	= mobi.getText().toString();
            	TextView mob;
            	int success;
				
            	 if (value.equals(result))
            	 {
            	try {
					// Building Parameters
					List<NameValuePair> params = new ArrayList<NameValuePair>();
					params.add(new BasicNameValuePair("phoneno", phoneno));
					Log.d("valuephone",phoneno.toString());					// getting product details by making HTTP request
					// Note that product details url will use GET request
					JSONObject jsons = jsonParser.makeHttpRequest("http://10.0.2.2:8080/buyfresh/forget_password_retrieve.php","GET", params);
					// check your log for json response
					Log.d("Single Product Details", jsons.toString());

					// json success tag
					success = jsons.getInt(TAG_SUCCESS);
					if (success == 1) {
						// successfully received product details
						JSONArray productObj = jsons.getJSONArray(TAG_PRODUCT); // JSON Array

						// get first product object from JSON Array
						JSONObject product = productObj.getJSONObject(0);

						mob= (TextView) findViewById(R.id.textView3 );
						mob.setText(product.getString(tag_password));
						

						e2.setVisibility(View.VISIBLE);
						e3.setVisibility(View.VISIBLE);
						e4.setVisibility(View.VISIBLE);
						
						
					}else{
						// product with pid not found
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
            	}
            	else
            	{
            		 Toast.makeText(getApplicationContext(), "Invalid verification code" , Toast.LENGTH_SHORT).show();
            	}
            	 
            	
            	
            	return;
            }
        });
        
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
        	 
            @Override
            public void onClick(DialogInterface dialog, int which) {
                return;
            }
        });
 
        return builder.create();
    }

        
		
/**
 * If a dialog has already been created,
 * this is called to reset the dialog
 * before showing it a 2nd time. Optional.
 */

@Override
protected void onPrepareDialog(int id, Dialog dialog) {

    switch (id) {
        case DLG_EXAMPLE1:
            // Clear the input box.
            EditText text = (EditText) dialog.findViewById(TEXT_ID);
            text.setText("");
            break;
    }
}

	
	protected void sendvalue(String a) 
	{
		// TODO Auto-generated method stub
		result= a;
	}
}
