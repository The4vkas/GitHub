package com.Team4.BuyFresh;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.readystatesoftware.viewbadger.BadgeView;
import com.vegCustomList.*;
import com.BuyFresh.tab.R;
import com.MenuOptions.AboutUs;
import com.MenuOptions.PriceList;
import Object.CartList;
import Object.FruitsList;
import Object.VegtableList;
import android.os.Bundle;
import com.MenuOptions.Cart;
import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
public  class MainActivity extends FragmentActivity  {
	ViewPager Tab;
    TabPagerAdapter TabAdapter;
	private ActionBar actionBar;
	Intent _intent;
	Cart a;
	private BadgeView mBadgeView;
	List<RowItem> searchResults= new ArrayList<RowItem>();
//	final EditText searchBox=(EditText) findViewById(R.id.searchtextbox);
public static CartList b = new CartList();

	static Button notifCount;
	static int mNotifCount = 12;    
	// Refresh menu item
///	private MenuItem refreshMenuItem;
	

	@Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar = getActionBar();
     //   setContentView(R.layout.friut_veg_lv);
		// Hide the action bar title
		actionBar.setDisplayShowTitleEnabled(false);
		
		View inflatedView = getLayoutInflater().inflate(R.layout.friut_veg_lv, null);
		//TextView text = (TextView) inflatedView.findViewById(R.id.text_view);
	//	text.setText("Hello!");
		
      
		
		
		try
       {
        getOverflowMenu();
     //   vegatable();
     // order() ;
        
   
        
        
       }
       catch(Exception e)
       {
    	   Toast.makeText(getApplicationContext(),""+e,
					Toast.LENGTH_LONG).show();
  
       }
        TabAdapter = new TabPagerAdapter(getSupportFragmentManager());
        
        Tab = (ViewPager)findViewById(R.id.pager);
        Tab.setOnPageChangeListener(
                new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                       
                    	actionBar = getActionBar();
                    	actionBar.setSelectedNavigationItem(position);
                    	
                    
                    }
                });
        Tab.setAdapter(TabAdapter);
        
        actionBar = getActionBar();
        //Enable Tabs on Action Bar
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ActionBar.TabListener tabListener = new ActionBar.TabListener(){

			@Override
			public void onTabReselected(android.app.ActionBar.Tab tab,
					FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			}

			@Override
			 public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
	          
			   
	       if (tab.getPosition()==0)
	       {
	    	   Toast.makeText(getApplicationContext(),""+tab.getPosition(),
 						Toast.LENGTH_LONG).show();
	 
	    	   vegatable();
	       EditText searchBox=(EditText) findViewById(R.id.searchtextbox);
	    	   
	       searchBox.setText("");
	       searchBox.setVisibility(View.VISIBLE);
	    	   
	       }
	       else if (tab.getPosition()==1)
	       {
	    	   Toast.makeText(getApplicationContext(),""+tab.getPosition(),
						Toast.LENGTH_LONG).show();
	    	   fruit() ;
	    	   EditText searchBox=(EditText) findViewById(R.id.searchtextbox);
	    	   
		       searchBox.setText("");
		    	   
		       searchBox.setVisibility(View.VISIBLE);
	    	   
	    	   
	       }
	       else if (tab.getPosition()==2)
	       {
	    	
	    	   
	    	   EditText searchBox=(EditText) findViewById(R.id.searchtextbox);
	    	   
		       searchBox.setText("");
		    	
		     searchBox.setVisibility(View.GONE);
		       
	    	   
	    	   
	       }
	    
	           
	          Tab.setCurrentItem(tab.getPosition());   
	            
	 
			
			}
			

			@Override
			public void onTabUnselected(android.app.ActionBar.Tab tab,
					FragmentTransaction ft) {
				// TODO Auto-generated method stub
				
			}};
			//Add New Tab
			actionBar.addTab(actionBar.newTab().setText("Vegetables").setTabListener(tabListener));
			actionBar.addTab(actionBar.newTab().setText("Fruits").setTabListener(tabListener));
			actionBar.addTab(actionBar.newTab().setText("Today Deal").setTabListener(tabListener));
	
			//c	 	actionBar.addTab(actionBar.newTab().setText("Order").setTabListener(tabListener));
			try
			{
				cartcount();
			}
			catch(Exception e)
			{
				
			}
		
    }
	
  
    private void getOverflowMenu() {
		// TODO Auto-generated method stub
        try {
		       ViewConfiguration config = ViewConfiguration.get(this);
		       Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
		       if(menuKeyField != null) {
		    	menuKeyField.setAccessible(true);
		           menuKeyField.setBoolean(config, false);
		       }
		   } catch (Exception e) {
		       e.printStackTrace();
		   }
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		// MenuInflater inflater = getMenuInflater();
		getMenuInflater().inflate(R.menu.main, menu);
	//	 View count = menu.findItem(R.id.action_Cart2).getActionView();
		  //  notifCount = (Button) count.findViewById(R.id.);
		  //  notifCount.setText(String.valueOf(mNotifCount));
		 //   addListenerOnButton(); 
		MenuItem menuItem = menu.findItem(R.id.action_Cart2);
		
		ImageButton iconView = new ImageButton(this, null,
		          R.style.AppTheme);
	   
		 
		    iconView.setImageDrawable(menuItem.getIcon());
		    iconView.setOnClickListener(new View.OnClickListener() {
		        @Override
		        public void onClick(View v) {
		            // The thing is clicked, do something useful.
		        	hello();
		        	cartcount();
		        
		        }
		    });
		  
		    // The badge view requires target view (iconView in this case)
		    // to have a ViewGroup parent
		    LinearLayout container = new LinearLayout(this);
		    container.setLayoutParams(new LinearLayout.LayoutParams(
		        ViewGroup.LayoutParams.WRAP_CONTENT,
		        ViewGroup.LayoutParams.WRAP_CONTENT));
		    container.addView(iconView);
		  
		    mBadgeView = new BadgeView(this, iconView);

		    menuItem.setActionView(container);
		    cartcount();

		    return super.onCreateOptionsMenu(menu);
		
		   
		
		
	}
	public void cartcount()
	{
		
		if( b.GetCart().size() == 0 )
		{
			mBadgeView.setText("0");
		    mBadgeView.show();
		}
		else
		{
			mBadgeView.setText(""+ b.GetCart().size());
		    mBadgeView.show();
		}
		
	}
	
    
   public void hello() {
		// TODO Auto-generated method stub
    	_intent=new Intent(this,com.MenuOptions.Cart.class);
		startActivity(_intent);
		
	}

	/**
     * 
     */
    public void vegatable() 
	 {
    	  final ListView vegtable;
    	final VegtableList obj =  new VegtableList();
	 try
	 {
		 vegtable = (ListView)findViewById(R.id.listView1);
		// registerForContextMenu(vegtable);
		 searchResults= obj.Getvegtable();
		 final EditText searchBox=(EditText) findViewById(R.id.searchtextbox);		 
	         final CustomListViewAdapter adapter = new CustomListViewAdapter(this,R.layout.friut_veg_lv,searchResults);
	          vegtable.setAdapter(adapter);
	          
	          adapter.notifyDataSetChanged();
	          
	          
	          searchBox.addTextChangedListener(new TextWatcher() {
	        	  
	        	  public void onTextChanged(CharSequence s, int start, int before, int count) {
	        	    //get the text in the EditText
	        	    String searchString=searchBox.getText().toString();
	        		 
	        	      
	        	    
	        	    int textLength=searchString.length();
	        	  
	        	    Toast.makeText(getApplicationContext(),""+searchResults.size(),
	   						Toast.LENGTH_LONG).show();
	   	        	
	        	    
	        	           //clear the initial data set
	        	   searchResults.clear();
	        	  
	        	    for(int i=0;i< obj.Getvegtable().size();i++)
	        	    {
	        	   String playerName=obj.Getvegtable().get(i).getname().toString();
	        	//   Toast.makeText(getApplicationContext(),""+playerName ,
	   				//		Toast.LENGTH_LONG).show();

	        	   if(textLength<=playerName.length()){
	        	   //compare the String in EditText with Names in the ArrayList
	        	     if(searchString.equalsIgnoreCase(playerName.substring(0,textLength)))
	        	     searchResults.add(obj.Getvegtable().get(i));
	        	   }
	        	    }
	        	    Toast.makeText(getApplicationContext(),""+searchResults ,
	   						Toast.LENGTH_LONG).show();
	        	    vegtable.setAdapter(adapter);
	        	  }
	        	  
	        	  public void beforeTextChanged(CharSequence s, int start, int count,
	        	      int after) {
	        	  
	        	  
	        	    }
	        	  
	        	    public void afterTextChanged(Editable s) {
	        	  
	        	  
	        	    }
	        	   });
	 
	 
	 
	 }
	 catch(Exception e){
		 Log.i("Tryy error", e.toString());
	
	 }
	 
	 
	 

}

    
    
    public boolean onOptionsItemSelected(MenuItem item)
    {
       	
    	
    	switch(item.getItemId())
    	{
    	case R.id.action_pricelist:
    		_intent= new Intent(this,PriceList.class);
    		startActivity(_intent);
    		return true;
    	case R.id.action_aboutus:
    		_intent=new Intent(this,AboutUs.class);
    		startActivity(_intent);
    		return true;
    		
    	case R.id.action_Cart:
    		_intent=new Intent(this,com.MenuOptions.Cart.class);
    		startActivity(_intent);
    		return true;
    	case R.id.action_Cart2 :
    		_intent=new Intent(this,com.MenuOptions.Cart.class);
    		startActivity(_intent);
    		return true;
    		
		default:
			return super.onOptionsItemSelected(item);

    		
    	}
		
    	
    }
    
   
    
    public void fruit() 
  	 {
    
    	final FruitsList obj = new FruitsList();
  	 try
  	 {
  		searchResults= obj.Getfriut();
  		 final EditText searchBox=(EditText) findViewById(R.id.searchtextbox);
  	       final ListView listView;  
  	       listView = (ListView)findViewById(R.id.fruitlist);
  	     registerForContextMenu(listView);
  	          final CustomListViewAdapter adapter = new CustomListViewAdapter(this,R.layout.friut_veg_lv,searchResults);
  	       listView.setAdapter(adapter);
  	       
  	     searchBox.addTextChangedListener(new TextWatcher() {
       	  
       	  public void onTextChanged(CharSequence s, int start, int before, int count) {
       	    //get the text in the EditText
       	    String searchString=searchBox.getText().toString();
       		 
       	      
       	    
       	    int textLength=searchString.length();
       	  
       	    Toast.makeText(getApplicationContext(),""+searchResults.size(),
  						Toast.LENGTH_LONG).show();
  	        	
       	    
       	           //clear the initial data set
       	   searchResults.clear();
       	  
       	    for(int i=0;i< obj.Getfriut().size();i++)
       	    {
       	   String playerName=obj.Getfriut().get(i).getname().toString();
       	//   Toast.makeText(getApplicationContext(),""+playerName ,
  				//		Toast.LENGTH_LONG).show();

       	   if(textLength<=playerName.length()){
       	   //compare the String in EditText with Names in the ArrayList
       	     if(searchString.equalsIgnoreCase(playerName.substring(0,textLength)))
       	     searchResults.add(obj.Getfriut().get(i));
       	   }
       	    }
       	    Toast.makeText(getApplicationContext(),""+searchResults ,
  						Toast.LENGTH_LONG).show();
       	 listView.setAdapter(adapter);
       	  }
       	  
       	  public void beforeTextChanged(CharSequence s, int start, int count,
       	      int after) {
       	  
       	  
       	    }
       	  
       	    public void afterTextChanged(Editable s) {
       	  
       	  
       	    }
       	   });
  	       
  	       
  	       
  	 }
  	 catch(Exception e){
  		 Log.i("Tryy error", e.toString());
  		 
  	 }

  }



		
		
	}

    

