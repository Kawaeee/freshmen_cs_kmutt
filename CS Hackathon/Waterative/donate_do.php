<?php
$location = "mysql.ilab.sit.kmutt.ac.th";
$username = "csc105_group16";
$password = "WpzSiT7472?";
$dbname = "csc105_group16";

$money = $_POST["amount"];

$conn = new mysqli($location, $username, $password, $dbname);
if($conn->connect_error) {
	die("Connection failed: ". $conn->connect_error);
}

$res = $conn->query("SELECT amount FROM `db_total` WHERE 1");
while(($row=$res->fetch_assoc())!=null){
$total = $row["amount"];

}
$all = $total+$money;
$conn->query("UPDATE `db_total` SET amount = $all");

$conn->query("INSERT INTO `db_waterative`(`amount`, `currency`, `name`, `email`) VALUES ( '".$_POST["amount"]."' , '".$_POST["currency"]."', '".$_POST["name"]."' , '".$_POST["email"]."' )");

header("location: main.php");
exit();
?>