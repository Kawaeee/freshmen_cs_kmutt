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

$prefix =$_POST["prefix"];
$fname =$_POST["firstname"];
$sname =$_POST["lastname"];
$sex =$_POST["gender"];
$rel =$_POST["religion"];
$phone =$_POST["phone"];
$bd =$_POST["birthdate"];
$stu_id = $_GET["std_id"];

$conn->query("UPDATE `phpsession_student` SET `std_prefixname`='$prefix'  , `std_fname`='$fname',  `std_sname`='$sname', `std_sex`='$sex', `std_religion`='$rel', `std_phone`= '$phone' ,`std_birthdate`='$bd' WHERE `std_id` = '$stu_id'");

header("location: showall.php");
exit();
?>

