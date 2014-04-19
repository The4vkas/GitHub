	 package com.vegCustomList;

public class RowItem {
    
	private int imageId;
    private String name;
    private int price;
    private double Total_price;
 
    public RowItem(int imageId, String name, int price,double d) {
        this.imageId = imageId;
        this.name = name;
        this.price = price;
        this.Total_price = d;
    }


    public double getTotal_Price() {
        return Total_price;
    }
    public void setTotal_Price(double totalprice) {
        this.Total_price = totalprice;
    }
    public int getImageId() {
        return imageId;
    }
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
    public int getprice() {
        return price;
    }
    public void setprice(int price) {
        this.price = price;
    }
    public String getname() {
        return name;
    }
    public void setname(String name) {
        this.name = name;
    }
    @Override
   
    public String toString() {
        return  "{"+name+","+price+","+Total_price+"}";
    }
    }