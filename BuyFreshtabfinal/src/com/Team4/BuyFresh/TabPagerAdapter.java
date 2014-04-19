package com.Team4.BuyFresh;

import com.TabLayout.Fruits;

//import com.TabLayout.Order;
import com.TabLayout.TodayDeal;
import com.TabLayout.Vegetables;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

public class TabPagerAdapter extends  FragmentStatePagerAdapter {

	  public TabPagerAdapter context;
    public TabPagerAdapter(FragmentManager fm) {
		super(fm);
	 context = this;	// TODO Auto-generated constructor stub
	}

	@Override
	public Fragment getItem(int i) {
		switch (i) {
        case 0:
          	Log.i("Data in", "veg");
            return new Vegetables();
        case 1:
           //Fragment for Ios Tab
        	Log.i("Data in", "fru");
            return new Fruits();
        case 2:
            //Fragment for Windows Tab
        	Log.i("Data in", "todaydeal");
            return new TodayDeal();
    //    case 3:
        	//return new 
      //  	Log.i("Data in", "order");
        //	 return new Order();
        }
		return null;
		
	}

	@Override
	public int getCount() {
		
		return 3; //No of Tabs
	}


    }