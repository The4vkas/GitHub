package com.TabLayout;

import com.BuyFresh.tab.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Fruits extends Fragment {
	
	
	
	@Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	//  Toast.makeText(getActivity(),"fir", Toast.LENGTH_LONG).show();	
	        View android = inflater.inflate(R.layout.fruits_list, container, false);
	       
	       // ((TextView)android.findViewById(R.id.textView)).setText("Fruits");
     
	        return android;
}

}
	



