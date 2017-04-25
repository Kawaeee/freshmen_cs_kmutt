
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

$stu_id = $_GET["std_id"];
$conn->query("DELETE FROM`phpsession_student` WHERE std_id = '$stu_id'");

header("location: showall.php");
exit();
?>

