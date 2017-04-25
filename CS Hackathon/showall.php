<?php
//error_reporting(E_ALL);
//ini_set('display_errors', 'On');
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
  <title>Student Roster</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</head>
		<body style = "background-color:#C8C8A9;">
		    <div class="container">
			<h1><center>Student Roster</center></h1>
			<div align="center">
			<table class="table table-hover">
				<thead>
						<tr>
							<th style="text-align:center">ID</th>
							<th style="text-align:center">Name</th>
							<th style="text-align:center">Gender</th>
							<th style="text-align:center">Religion</th>
							<th style="text-align:center">Phone</th>
							<th style="text-align:center">Birthdate</th>
						</tr>
				</thead>
				<tbody>
				</div>
			<?php
			//$res = $conn->query("SELECT phpsession_student.std_id,phpsession_student.std_prefixname,phpsession_student.std_fname, phpsession_student.std_sname, phpsession_student.std_sex,phpsession_religion.rel_name, phpsession_student.std_phone, phpsession_student.std_birthdate FROM phpsession_student,phpsession_religion WHERE  phpsession_student.std_religion = phpsession_religion.rel_id");
            $res = $conn->query("SELECT * FROM phpsession_student,phpsession_religion WHERE  phpsession_student.std_religion = phpsession_religion.rel_id");
			while(($row = $res->fetch_assoc()) != null) {?>
						<div class="w3-container">
						<tr>
							<td><?php echo $row["std_id"];?></td>
							<td><?php echo $row["std_prefixname"];?><?php echo $row["std_fname"];?> <?php echo $row["std_sname"];?></td>
							<td><?php echo $row["std_sex"];?></td>
							<td><?php echo $row["rel_name"];?></td>
							<td><?php echo $row["std_phone"];?></td>
							<td><?php echo $row["std_birthdate"];?></td>
							<td><a href="edit.php?std_id=<?php echo $row["std_id"];?>" class="btn btn-success">
							<span class="glyphicon glyphicon-question-sign"></span> Edit
							</a></td>
							<td><a href="delete.php?std_id=<?php echo $row["std_id"]; ?>" class="btn btn-danger" onclick ="Delete()">
							<span class="glyphicon glyphicon-remove-sign"></span> Delete</a><td>
						</tr>
						</div>
			<?php
			}
			?>
				</tbody>
			</table><br>
			<td><a href="insertnew.php" class="btn btn-primary btn-block"><span class="glyphicon glyphicon-plus-sign"></span> Add new Student</a></td>
	<script>
	function Delete() {
	alert("Delete Complete !!");
	}
</script>
	</body>
</html>