<?php 

$response = array();
if ( isset($_GET["name"]) && isset($_GET["phone"]) && isset($_GET["address_no"]) && isset($_GET["address_streetname"]) && isset($_GET["adddress_city"]) && isset($_GET["address_area"]) && isset($_GET["delivery_point"]) && isset($_GET["pincode"]) && isset($_GET["amt"]))
{
    $name=$_GET["name"];
    $phone =$_GET["phone"];
    $address_no=$_GET["address_no"];
    $address_streetname =$_GET["address_streetname"];
    $address_city=$_GET["addrss_city"];
    $address_area =$_GET["address_area"];
    $delivery_point=$_GET["delivery_point"];
    $pincode =$_GET["pincode"];
    $amt=$_GET["amt"];
    $sql = mysql_connect("localhost","root","")or die("could not connect to database"); 
    mysql_select_db("buyfresh",$sql) or die("cant use database"); 
    $result = mysql_query("INSERT INTO bill_detail(name,phone,address_no,address_streetname,address_city,address_area,delivery_point,pincode,amt) values ('".$name."',
                      '".$phone."',
                      '".$address_no."',
                      '".$address_streetname."',
                      '".$address_city."',
                      '".$address_area."',
                      '".$delivery_point."',
                      '".$pincode."',
                      '".$amt."')");
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