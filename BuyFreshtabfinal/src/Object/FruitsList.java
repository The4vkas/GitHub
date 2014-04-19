package Object;

import java.util.ArrayList;
import java.util.List;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import com.BuyFresh.tab.R;
import com.vegCustomList.RowItem;
public class FruitsList extends Activity
{
	@SuppressLint("Registered")
	static List<RowItem> FruitsList = new ArrayList<RowItem>();
		public List<RowItem> Getfriut()
		{
	    	final String[] fruit_Name = new String[] 
	        		{ "Apple",
	            	  "Graphs", 
	            	  "Banana", 
	            	  "Cherry" };
	        final int[] fruit_Price = new int[] 
	           {500,
	            350, 
	            400,
	            200 };
	        FruitsList = new ArrayList<RowItem>();
	  	        for (int i = 0; i < fruit_Name.length; i++) 
	  	        {
	  	        	Log.i("Data in", fruit_Name[i]);
	  	            RowItem item = new RowItem(R.drawable.apple, fruit_Name[i], fruit_Price[i],(int) (fruit_Price[i]*.5)) ;
	  	          FruitsList.add(item);
	  	        }
			return FruitsList;
		}

}
