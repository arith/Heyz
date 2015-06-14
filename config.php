<?php

$u = "root";
$p = "";
$db = "heyz";

$sql_details = array(
	'user' => 'root',
	'pass' => '',
	'db'   => 'heyz',
	'host' => 'localhost'
);

$con = mysqli_connect('localhost', $u, $p, $db);
if (mysqli_connect_errno())
  {
  echo "Failed to connect to MySQL: " . mysqli_connect_error();
}
?>