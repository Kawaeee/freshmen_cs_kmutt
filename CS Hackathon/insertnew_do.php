<?php
error_reporting(E_ALL);
ini_set('display_errors', 'On');
$location = "mysql.ilab.sit.kmutt.ac.th";
$username = "csc105_group3";
$password = "ComputerProgramming105!";
$dbname = "csc105_group3";

$conn = new mysqli($location, $username, $password, $dbname);

if($conn->connect_error) {
	die("Connection failed: ". $conn->connect_error);
}
$conn->query("INSERT INTO `phpsession_student` (`std_id`, `std_prefixname`, `std_fname`, `std_sname`, `std_sex`, `std_religion`, `std_phone`, `std_birthdate`) VALUES (NULL, '".$_POST["prefix"]."', '".$_POST["firstname"]."', '".$_POST["lastname"]."', '".$_POST["gender"]."', '".$_POST["religion"]."', '".$_POST["phone"]."', '".$_POST["birthdate"]."');");

header("location: showall.php");
exit();
?>