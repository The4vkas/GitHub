<?php 

$response = array();
if (isset($_GET["phoneno"]) && isset($_GET["password"]))
{
    $mobileno = $_GET["phoneno"];
    $password=$_GET["password"];
    $sql = mysql_connect("localhost","root","")or die("could not connect to database"); 
    mysql_select_db("buyfresh",$sql) or die("cant use database"); 
    $result = mysql_query("SELECT * from new_registration where phone = '".$mobileno."' && password = '".$password."' ");
    if(mysql_num_rows($result) == 0) 
    {
       
		
        
		 
		 
		//sending verification to android app
        $response["getcode"]=0;
        $response["message"]="invaliduser";
       //pass to java
        echo json_encode($response);
		}
    else
    {   
       $response["getcode"]=1;
       $response["message"]="valid user";
       //pass to java
        echo json_encode($response);
    }
	 mysql_close($result);
     }
else
{
        $response["success"]=1;
        $response["message"]="no mobileno";
        echo json_encode($response); 
     
    
}
?>