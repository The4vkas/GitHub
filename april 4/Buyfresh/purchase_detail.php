<?php 

$response = array();
if ( isset($_GET["bill_num"]) && isset($_GET["name"]) && isset($_GET["price"]) && isset($_GET["qty"]) && isset($_GET["total_price"]) && isset($_GET["prod_id"]) && isset($_GET["category"]))
{
    $bill_num=$_GET["bill_num"];
    $name =$_GET["name"];
    $price=$_GET["price"];
    $qty=$_GET["qty"];
    $total_price =$_GET["total_price"];
    $prod_id=$_GET["prod_id"];
    $category=$_GET["category"];
 
 
    $sql = mysql_connect("localhost","root","")or die("could not connect to database"); 
    mysql_select_db("buyfresh",$sql) or die("cant use database"); 
    $result = mysql_query("INSERT INTO purchase_detail(bill_num,name,price,qty,total_price,prod_id,category) values ('".$bill_num."',
    '".$name."',
    '".$price."',
    '".$qty."',
    '".$total_price."',
    '".$prod_id."',
    '".$category."')");
    
    if($result) 
    {
        
		//sending verification to android app
        $response["value"]=0;
        $response["message"]="value inserted";
       //pass to java
        echo json_encode($response);
		}
    else
    {   
       $response["value"]=1;
       $response["message"]="value not inserted";
       //pass to java
        echo json_encode($response);
    }
	 mysql_close($result);
     }
	   else
{
        $response["unsuccess"]=0;
        $response["message"]="required field missing";
        echo json_encode($response); 
     
    
}
?>