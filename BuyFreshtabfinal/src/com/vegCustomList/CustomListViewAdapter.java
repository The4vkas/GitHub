package com.vegCustomList;
import java.util.ArrayList;
import java.util.List;

import com.BuyFresh.tab.R;
import com.Team4.BuyFresh.MainActivity;
import Object.CartList;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
 
public class CustomListViewAdapter extends ArrayAdapter<RowItem> {
 
	Context context;
    ViewHolder holder = null;
    List<RowItem> items;
    ArrayList<String> list = new ArrayList<String>();
    int postion1;
    View convertView1; ViewGroup parent1;
    public static CartList a = new CartList();
static  MainActivity b;
   double Totalprice = 0;
    int resourceId;
    
   
    
   int i=0;
	 List<RowItem> Cart = new ArrayList<RowItem>();;
	     public CustomListViewAdapter(Context context,int resourceId,List<RowItem> items) 
    {
	    super(context, resourceId, items);
        this.context = context;
        this.items=items;
        this.resourceId=resourceId;

    }
	     
	     
 
    /*private view holder class*/
    private class ViewHolder {
        ImageView imageView;
        TextView txtname;
        TextView txtprice;
        Spinner Qut_Spinner;
        TextView txtTotalPrice;
    }
 
    public View getView(final int position, View convertView, ViewGroup parent) 
    {
    	convertView1=convertView;
    	
       convertView = convertView1;parent1 =parent;
    	
    	try
    	{
       
         RowItem rowItem = getItem(position);
    //    final View convertView1 = convertView ;
      
       LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) 
        {
        
                convertView = mInflater.inflate(com.BuyFresh.tab.R.layout.friut_veg_lv, null);
            holder = new ViewHolder();
            holder.txtprice = (TextView) convertView.findViewById(R.id.lv_tv_price);
            holder.txtname = (TextView) convertView.findViewById(com.BuyFresh.tab.R.id.lv_tv_name);
            holder.imageView = (ImageView) convertView.findViewById(com.BuyFresh.tab.R.id.lv_img_icon);
         //   holder.Qut_Spinner = (Spinner)convertView.findViewById(com.BuyFresh.tab.R.id.Qut_Spinner);
         //   holder.txtTotalPrice= (TextView)convertView.findViewById(com.BuyFresh.tab.R.id.Lst_Totalprice);
           
            Typeface custom_font = Typeface.createFromAsset(context.getAssets(),"fonts/Roboto-BoldItalic.ttf");
            holder.txtname.setTypeface(custom_font);
            holder.txtprice.setTypeface(custom_font);


         
                  
                       
            convertView.setTag(holder);
        
        }
        else
        
        holder = (ViewHolder) convertView.getTag();
        holder.txtprice.setText(""+rowItem.getprice());
        holder.txtname.setText(rowItem.getname());
        holder.imageView.setImageResource(rowItem.getImageId());
        holder.txtTotalPrice.setText(""+rowItem.getTotal_Price());
   
       // holder.Qut_Spinner.setOnItemSelectedListener(new  AdapterView.OnItemSelectedListener() {

	//		@Override
	/*		public void onItemSelected( AdapterView<?> arg0, View arg1,
					int arg2, long arg3) 
			{	
				  RowItem rowItem = getItem(position);
				 if(arg2==0)
				{
					 Totalprice = rowItem.getprice()*.5;
					rowItem.setTotal_Price(Totalprice);
						 notifyDataSetChanged();
				//	 holder.txtTotalPrice.setText(""+Totalprice);
				
				}
		     	
		     	
		     	
				else if(arg2==1)
				{
					 Totalprice = rowItem.getprice()*1;
					 rowItem.setTotal_Price(Totalprice);
				 notifyDataSetChanged();
				}
				else if(arg2==2)
				{
					 Totalprice = rowItem.getprice()*2;
					 rowItem.setTotal_Price(Totalprice);
					 notifyDataSetChanged();
				}
				else if(arg2==3)
				{
					 Totalprice = rowItem.getprice()*3;
					 rowItem.setTotal_Price(Totalprice);
					 notifyDataSetChanged();
}
				else if(arg2==4)
				{
					 Totalprice = rowItem.getprice()*4;
					 rowItem.setTotal_Price(Totalprice);
					 notifyDataSetChanged();
				}
				else if(arg2==5)
				{
					 Totalprice = rowItem.getprice()*5;
					 rowItem.setTotal_Price(Totalprice);
					 notifyDataSetChanged();
				}
				
				
	
			}

	

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			} 
        });
        */
    	}
    	catch(Exception e)
    	{
    	 Log.i("error",e.toString() );
    	}
    	 Button addButton = (Button)convertView.findViewById(R.id.lv_bt_add);
         // 	add_Button.setVisibility(View.INVISIBLE);
          addButton.setOnClickListener(
                  new Button.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                        //  Integer index = (Integer) view.getTag();
                   try
                   {
                  	  RowItem rowItem = getItem(position);
       
                  	Toast.makeText(context, " "+a.GetCart().size()+ v.getId()  ,Toast.LENGTH_SHORT).show();
                  		a.a(rowItem.getname(),rowItem.getprice(),rowItem.getTotal_Price());
                 
                  	
                  	((MainActivity) context).cartcount();
                  	
                   }
                   catch(Exception e)
                   {
                  	 Log.i("Error",e.toString());
                   }
                      }
                  }
              );
              
              
              
      
          
   /*   Button deleteButton = (Button)convertView.findViewById(R.id.del_button);
     // 	add_Button.setVisibility(View.INVISIBLE);
      deleteButton.setOnClickListener(
              new Button.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                    //  Integer index = (Integer) view.getTag();
                  	new AlertDialog.Builder(context)
                      .setTitle("Delete entry")
                      .setMessage("Are you sure you want to delete this entry?")
                      .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                          public void onClick(DialogInterface dialog, int which) { 
                              // continue with delete
                          	
                         
                      	items.remove(items.get(position)); 
                          	   Toast.makeText(context, "position " + position,Toast.LENGTH_SHORT).show();
             					
                          	   
                         notifyDataSetChanged();
                          
                          }
                       })
                      .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                          public void onClick(DialogInterface dialog, int which) { 
                              // do nothing
                          }
                       })
                    .setIcon(R.drawable.ic_dialog_alert)
                       .show();
                  
                  	
                  }
              }
          );
          
          */
          
    	
    
        return convertView;
    }

	protected Context getBaseContext() {
		// TODO Auto-generated method stub
		return this.context;
	}	
    
}

    
