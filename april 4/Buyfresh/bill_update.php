<?php
$response = array();
if (isset($_GET["phoneno"])) {
    $phoneno = $_GET['phoneno'];
 $sql = mysql_connect("localhost","root","")or die("could not connect to database"); 
    mysql_select_db("buyfresh",$sql) or die("cant use database"); 
    // get a product from products table
    $result = mysql_query("SELECT *FROM bill_detail WHERE phone = $phoneno");

    if (!empty($result)) {
        // check for empty result
        if (mysql_num_rows($result) > 0) {

            $result = mysql_fetch_array($result);

            $product = array();
            $product["bill_num"] = $result["bill_num"];
            $product["name"] = $result["name"];
            $product["phone"] = $result["phone"];
            $product["address_no"] = $result["address_no"];
			$product["address_streetname"] = $result["address_streetname"];
			$product["address_city"] = $result["address_city"];
			$product["address_area"] = $result["address_area"];
			$product["delivery_point"] = $result["delivery_point"];
			$product["pincode"] = $result["pincode"];
			$product["amt"] = $result["amt"];
            $product["created_at"] = $result["created_at"];
            // success
            $response["success"] = 1;

            // user node
            $response["product"] = array();

            array_push($response["product"], $product);

            // echoing JSON response
            echo json_encode($response);
        } else {
            // no product found
            $response["success"] = 0;
            $response["message"] = "No product found";

            // echo no users JSON
            echo json_encode($response);
        }
    } else {
        // no product found
        $response["success"] = 0;
        $response["message"] = "No product found";

        // echo no users JSON
        echo json_encode($response);
    }
} else {
    // required field is missing
    $response["success"] = 0;
    $response["message"] = "Required field(s) is missing";

    // echoing JSON response
    echo json_encode($response);
}
?>
