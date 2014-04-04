<?php 

$response = array();
if ( isset($_GET["name"]) && isset($_GET["item_name"]) && isset($_GET["price"]))
{
    $name=$_GET["name"];
    $item_name =$_GET["item_name"];
    $price=$_GET["price"];
    $sql = mysql_connect("localhost","root","")or die("could not connect to database"); 
    mysql_select_db("buyfresh",$sql) or die("cant use database"); 
    $result = mysql_query("INSERT INTO deal(name,item_name,price) values ('".$name."','".$item_name."','".$price."')");
    
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