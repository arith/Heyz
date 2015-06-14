<?php
require('config.php');

function reverse_geocode($lat, $lon) {
    $url = "http://maps.google.com/maps/api/geocode/json?latlng=$lat,$lon&sensor=false";
    $data = json_decode(file_get_contents($url));
    if (!isset($data->results[0]->address_components)){
        return "unknown Place";
    }

    if ($data->results[0]->address_components[2]->types[0]=="locality") {


        //$long_name
        $return_array['sublocality_long_name']=$data->results[2]->address_components[0]->long_name;
        return $return_array;

        }

}

// DB table to use
$table = 'status';
 
// Table's primary key
$primaryKey = 'id';

$columns = array(
	array( 'db' => 'id', 'dt' => 0, 'field' => 'id'),
    array( 'db' => 'district', 'dt' => 0, 'field' => 'district'),
    array( 'db' => 'GROUP_CONCAT(DISTINCT status SEPARATOR \', \')', 'dt' => 1, 'field' => 'statuslist', 'as' => 'statuslist' ),
);


require( 'ssp.class.php' );

$joinQuery = "";
$joinQuery ="FROM {$table} AS statuslist";
$extraCondition = "";
$groupBy = ''; 

echo json_encode(
       SSP::simple( $_GET, $sql_details, $table, $primaryKey, $columns, $joinQuery, $extraCondition, $groupBy)
     );
