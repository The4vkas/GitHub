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
import android.content.Intent;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class LoginActivity extends Activity {
	private static String TAG_GET = "getcode";
	static Integer code;
	TextView _forgot,_sign;
	
EditText _phone,_pass;
Button _btn,_btn1;
JSONParser jsonParser = new JSONParser();
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		StrictMode.ThreadPolicy _policy;
		 _policy= new StrictMode.ThreadPolicy.Builder().permitAll().build();
	    StrictMode.setThreadPolicy(_policy);

		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		
		_forgot=(TextView)findViewById(R.id.forgotpass);
		_forgot.setPaintFlags(_forgot.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
		_sign=(TextView)findViewById(R.id.signup);
		_sign.setPaintFlags(_sign.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
		
		_phone=(EditText)findViewById(R.id.editText1);
		_pass=(EditText)findViewById(R.id.editText2);
		_btn=(Button)findViewById(R.id.button2);
		_btn1=(Button) findViewById(R.id.login);
		conditions(); 
		conditions2();
		
	_forgot.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String phoneno= _phone.getText().toString();
			// startActivity(new Intent(LoginActivity.this, forgetpass.class));
			
			Intent inte= new Intent(getBaseContext(),forgetpass.class);
			inte.putExtra("tag", phoneno);
			startActivity(inte);
			
		}
	});
		
		
	}   
private void conditions2() {
		// TODO Auto-generated method stub
	_btn.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
		startActivity(new Intent(LoginActivity.this, MainActivity.class));
			
		}
	});
	}
public void conditions()   
{
	

	//_btn=(Button)findViewById(R.id.button1);
	_btn1.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			String phoneno	= _phone.getText().toString();
			String password =_pass.getText().toString();
			
			Log.d("inside", phoneno);
			Log.d("password", password);
			
			List<NameValuePair> param = new ArrayList<NameValuePair>();
			param.add(new BasicNameValuePair("phoneno",phoneno.trim()));
			
			param.add(new BasicNameValuePair("password",password.trim()));
			
			JSONObject jsons = jsonParser.makeHttpRequest("http://10.0.2.2:8080/buyfresh/user_verification.php","GET", param);
			Log.d("checking json",jsons.toString());
			try 
			{
				code= jsons.getInt(TAG_GET);
				Log.d("GET_CODE", code.toString());
				if (code==0) 
				{
				 			Toast.makeText(getApplicationContext(),"invalid user",Toast.LENGTH_LONG).show();
							
					}
						else
						{
							Toast.makeText(getApplicationContext(),"valid user",Toast.LENGTH_LONG).show();
						}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	})	;
	}




}