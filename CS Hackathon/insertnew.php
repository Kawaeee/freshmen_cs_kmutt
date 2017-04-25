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
?>
<html>
	<head>
		<title>Student Roster - Insert new student.</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
	  <body style = "background-color:#C8C8A9;">
	  			<div align="center">
				  <br><br>
			<form method="POST" action="insertnew_do.php">
				<div class="form-group"><label>Prefix Name : <input type="text" class="form-control" name="prefix" autofocus required></label></div>
				<div class="form-group"><label>First Name : <input type="text" class="form-control" name="firstname" required></label></div>
				<div class="form-group"><label>Surname : <input type="text" class="form-control" name="lastname" required></label></div>
				<div class="form-group"><label>Gender :  <label class="radio-inline"><input type="radio" name="gender" value="M" checked>Male</label>
				                                         <label class="radio-inline"><input type="radio" name="gender" value="F">Female</label><br></div>
				<div class="form-group"><label>Religion : <select class="form-control" name="religion" required>
				<?php
				$res = $conn->query("SELECT * FROM phpsession_religion");
				while(($row = $res->fetch_assoc()) != null) {?>
					<?php echo "<option value=".$row["rel_id"].">".$row["rel_name"]."</option>";?>
					</div>
				<?php
				}
				?>
					</select></label><br><br>
				<div class="form-group"><label>Phone : <input type="text" class="form-control" name="phone" required></label><br></div>
				<div class="form-group"><label>Birthdate : <input type="date" class="form-control"  name="birthdate" required></label><br></div>
				<br>
				<input type="submit" value="Submit" class="btn btn-success" onclick ="Insert()">
				<td><a href="showall.php" class="btn btn-primary"><span class="glyphicon glyphicon-home"></span> Back</a></td>
				<br><br>
			</form>
			<script>
	function Insert() {
    alert("Insert Complete !!");
    }
</script>
	</body>
</html>
