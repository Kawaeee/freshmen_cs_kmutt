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
  $strSQL = $conn->query("SELECT * FROM phpsession_student,phpsession_religion WHERE  phpsession_student.std_id = $stu_id");
  $rows = mysqli_fetch_array($strSQL);
  $check = $rows["std_religion"];
?>
<html>
	<head>
		<title>Student Roster - Edit your student.</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
				<div align="center">
				<br><br>
	  <body style = "background-color:#C8C8A9;">
			<form method="POST" action="up.php?std_id=<?php echo $stu_id;?>">
				<div class="form-group"><label>Prefix Name : <input type="text" class="form-control" name="prefix" value=<?php echo $rows["std_prefixname"];?>></label></div>
				<div class="form-group"><label>First Name : <input type="text"  class="form-control"name="firstname" value=<?php echo $rows["std_fname"];?> required></label></div>
				<div class="form-group"><label>Surname : <input type="text"  class="form-control" name="lastname" value=<?php echo $rows["std_sname"];?> required></label></div>
				<div class="form-group"><label>Gender : <label class="radio-inline"><input type="radio" name="gender" value="M" <?php if($rows["std_sex"]=='M' ) echo 'checked'?>>Male</label> 
                                                        <label class="radio-inline"><input type="radio" name="gender" value="F" <?php if($rows["std_sex"]=='F' ) echo 'checked'?>>Female</label><br></div>
				<div class="form-group"><label>Religion : <select class="form-control" name="religion">
				<?php
				$res = $conn->query("SELECT * FROM phpsession_religion");
				while(($row = $res->fetch_assoc()) != null) {?>
					<?php 
					echo "<option value=".$row["rel_id"].'';
                    if($check == $row["rel_id"]) echo ' selected';
					echo ">".$row["rel_name"]." </option>";?>
					</div>
				<?php
				}
				?>
					</select></label><br>
				<div class="form-group"><label>Phone : <input type="text" class="form-control" name="phone" value=<?php echo $rows["std_phone"];?> required></label><br></div>
				<div class="form-group"><label>Birthdate : <input type="date" class="form-control" name="birthdate" value=<?php echo $rows["std_birthdate"];?> required></label><br></div>
				<br><br>
				<input type="submit" value="Submit"  class="btn btn-success" onclick ="Update()">
				<td><a href="showall.php" class="btn btn-primary "><span class="glyphicon glyphicon-home"></span> Back</a></td>
				<br><br>
			</form>
	<script>
    function Update() {
    alert("Update Complete !!");
    }
</script>
	</body>
</html>
