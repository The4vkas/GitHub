package Object;

import android.widget.Toast;

public class GrandTotal {
	
	public double GradeTotal;
	CartList a = new CartList() ;
	
	public double getGradeTotal()
	{
	 for(int i=0;i<=a.GetCart().size()-1;i++)
	 {
		 GradeTotal= a.GetCart().get(i).getTotal_Price()+GradeTotal;
	 }
	// Toast.makeText(this, " "+GradeTotal  ,Toast.LENGTH_SHORT).show();	
	return this.GradeTotal;
	
	
	}
	
        
	


}
