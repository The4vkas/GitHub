<?php 

$response = array();
if ( isset($_POST["phoneno"]) && isset($_POST["password"]))
{
    $phoneno=$_POST['phoneno'];
	$password=$_POST['password'];
	
    $sql = mysql_connect("localhost","root","")or die("could not connect to database"); 
    mysql_select_db("buyfresh",$sql) or die("cant use database"); 
    $result = mysql_query("UPDATE new_registration SET password = '$password' where phone = $phoneno");
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