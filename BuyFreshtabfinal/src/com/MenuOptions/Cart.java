package com.MenuOptions;

import java.util.List;

import Object.CartList;
import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.BuyFresh.tab.R;
import com.vegCustomList.CartListViewAdapter;
import com.vegCustomList.CustomListViewAdapter;
import com.vegCustomList.RowItem;

public class Cart  extends Activity {
	static List<RowItem> rowItems;
	
	CartList a = new CartList() ;
	 
	  
	 protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_list);
      
ActionBar actionBar = getActionBar();
		
		// Enabling Back navigation on Action Bar icon
		actionBar.setDisplayHomeAsUpEnabled(true);

            ListView listView;
           
    	 try
    	 {
    		 double totalprice=0;
    		

    	      listView = (ListView)findViewById(R.id.orderlist);
    	  
    	      CartListViewAdapter adapter = new CartListViewAdapter(this,R.layout.cart_lv,a.GetCart());
    	    
  		 listView.setAdapter(adapter);
    	adapter.notifyDataSetChanged();
    	
    	    	
    	  }
    	
    	 catch(Exception e){
    		 Log.i("Tryy error", e.toString());
    		 
    	 }

   


  }
    	
   	 
   	 
		

}
