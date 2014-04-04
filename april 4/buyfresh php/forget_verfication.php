<?php 

$response = array();
if (isset($_GET["phoneno"]))
{
    $mobileno = $_GET["phoneno"];
    $sql = mysql_connect("localhost","root","")or die("could not connect to database"); 
    mysql_select_db("buyfresh",$sql) or die("cant use database"); 
    $result = mysql_query("SELECT * from new_registration where phone = '".$mobileno."' ");
    if(mysql_num_rows($result) == 1) 
    {
       /*$response["success"]=0;
		$response["message"]="enter vcode"; 
		echo json_encode($response);*/
		
         $a=generate_room_key($mobileno);//function calling 
		 
		 
		//sending verification to android app
        $response["getcode"]=$a;
        $response["message"] ="hello";
        echo json_encode($response);
		
    }
    else
    {   
       $response["getcode"]="1";
       $response["message"]="invalid user"; 
       //pass to java
        echo json_encode($response);
    }
     mysql_close($result);
}
 else{
        $response["success"]=1;
        $response["message"]="no mobileno";
        echo json_encode($response); 
}
    function generate_room_key($mobileno)
      
      {
        $chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"; 
        $length = 5; 
        $size = strlen( $chars );
        $str = ""; 
        for( $i = 0; $i < $length; $i++ ) 
        { 
          $str .= $chars[ rand( 0, $size - 1 ) ]; 
        } 
       
        //checking whether the verificationcode is already in table
        $query_verifycode = mysql_query("select * from new_registration where vcode = '".$str."' "); 
        $verifycode_count = mysql_num_rows($query_verifycode); 
        if($verifycode_count > 0) 
        { 
          generate_room_key();
        }
        elseif ($verifycode_count == 0) 
         {
         	sent_single_msg($mobileno ,$str); //function calling
          // $result = mysql_query("INSERT INTO new_registration(phone,vcode) VALUES('$mobileno', '$str')");
           //$v_code=mysql_query("SELECT follower_verify_code from tbl_follower where follower_mobile = $mobileno");
          // $sample="this is test message 2."; 
          //$v_key = mysql_fetch_assoc($v_code);    
          
         
          return $str;
        
        }
          
      } 
      function sent_single_msg($mob_no , $msg)
      {
  

 $request ="";
    //initialise the request variable 
 $param['method']= "sendMessage";
 $param['send_to'] = $mob_no; 
 $param['msg'] = $msg;
 $param['userid'] = "2000096108";
 $param['password'] = "Empire_1990"; 
 $param['v'] = "1.1";
 $param['msg_type'] = "TEXT";
     //Can be "FLASH"/"UNICODE_TEXT"/"BINARY" 
 $param['auth_scheme'] = "PLAIN";
    //Have to URL encode the values 
       foreach($param as $key=>$val) 
       { 
            $request.= $key."=".urlencode($val);
            //we have to urlencode the values 
            $request.= "&"; 
            //append the ampersand (&) sign after each parameter/value pair 
        }
 $request = substr($request, 0, strlen($request)-1); 
    //remove final (&) sign from the request  
 $url = "http://enterprise.smsgupshup.com/GatewayAPI/rest?".$request;
 $ch = curl_init($url); 
 curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
 $curl_scraped_page = curl_exec($ch);
 curl_close($ch);
 return true;
 }

?>