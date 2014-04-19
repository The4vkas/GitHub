package Object;
import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;

import com.BuyFresh.tab.R;
import com.vegCustomList.RowItem;



@SuppressLint("Registered") public class VegtableList extends Activity
{
	static List<RowItem> VegtableList = new ArrayList<RowItem>();
	
	
		public List<RowItem> Getvegtable()
		{
			final String[] VegName = new String[] 
	        		{ "Tomato",
	            	  "Carrot", 
	            	  "Onion", 
	            	  "Cabbage" ,
	            	  "Cauliflower"};
	        final int[] Veg_price = new int[] 
	           {30,
	            50, 
	            20,
	            60 
	            , 100
	            };
	      
	        VegtableList = new ArrayList<RowItem>();
		        for (int i = 0; i < VegName.length; i++) 
		        {
		        	Log.i("Data in", VegName[i]);
		        	
		            RowItem item = new RowItem(R.drawable.apple, VegName[i], Veg_price[i],(int) (Veg_price[i]*.5));
		            VegtableList.add(item);
		        	Log.i("Data in", VegName[i]);
		        }
			
			return VegtableList;
		}

}
