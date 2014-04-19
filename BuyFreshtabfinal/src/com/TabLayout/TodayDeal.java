package com.TabLayout;

import com.BuyFresh.tab.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TodayDeal extends Fragment {
	@Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	 
	        View android = inflater.inflate(R.layout.todaydeal_list, container, false);
	 //       Toast.makeText(getActivity(),"todaydeal", Toast.LENGTH_LONG).show();	
	    //    ((TextView)android.findViewById(R.id.textView)).setText("TodayDeal");
	        return android;
}}
