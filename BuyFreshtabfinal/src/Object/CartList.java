package Object;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import com.BuyFresh.tab.R;
import com.vegCustomList.RowItem;



public class CartList extends Activity
{
	static List<RowItem> CartList = new ArrayList<RowItem>();
	
		public void a(String Name, int price, double d) {
			// TODO Auto-generated method stub
						
			  RowItem item = new RowItem(R.drawable.ic_launcher,Name, price,d);
			  CartList.add(item);
			
			  
	    //     Toast.makeText(this, " "+Name+price+  this.CartList.size(),Toast.LENGTH_SHORT).show();
	         
	         

			
		}
		public List<RowItem> GetCart()
		{
			return CartList;
		}

}
