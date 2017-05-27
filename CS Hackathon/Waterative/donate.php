<?php

$location = "mysql.ilab.sit.kmutt.ac.th";
$username = "csc105_group16";
$password = "WpzSiT7472?";
$dbname = "csc105_group16";

$conn = new mysqli($location, $username, $password, $dbname);
if($conn->connect_error) {
	die("Connection failed: ". $conn->connect_error);
}

?>

<html>

<head>

<title>Waterative : Donation</title>
<meta charset="utf-8"><meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css" >

<style type="text/css">

*{padding:0;margin:0;}
footer {
    background-color:rgba(0,128,255,0.25);
	width:100%;
	height:30px;
	position:absolute;
	bottom:0;
	left:0;
}

h1{
color:white;
}

flex-container {
    display: -webkit-flex;
    display: flex;  
    -webkit-flex-flow: row wrap;
    flex-flow: row wrap;
    text-align: center;
}

.flex-container > * {
    padding: 15px;
    -webkit-flex: 1 100%;
    flex: 1 100%;
}

header {
    background-color:rgba(0,128,255,0.25);
    color:white;
    }

select option { 
        color: black;
       background:#FFFFFF;
}

body{
    margin:0;
    padding:0;
    height:100%;
    color:#FFF;
}

.label-container{
	position:fixed;
	bottom:48px;
	right:105px;
	display:table;
	visibility: hidden;
}

.label-text{
	color:#FFF;
	background:rgba(51,51,51,0.5);
	display:table-cell;
	vertical-align:middle;
	padding:10px;
	border-radius:3px;
}

.label-arrow{
	display:table-cell;
	vertical-align:middle;
	color:#333;
	opacity:0.5;
}

.float{
	position:fixed;
	width:60px;
	height:60px;
	bottom:40px;
	right:40px;
	background-color:#06C;
	color:#FFF;
	border-radius:50px;
	text-align:center;
	box-shadow: 2px 2px 3px #999;
}

.my-float{
	font-size:24px;
	margin-top:18px;
}

a.float + div.label-container {
  visibility: hidden;
  opacity: 0;
  transition: visibility 0s, opacity 0.5s ease;
}

a.float:hover + div.label-container{
  visibility: visible;
  opacity: 1;
}

#content {
	padding-bottom:100px; /* Height of the footer element */
}

#wrapper {
	min-height:100%;
	position:relative;
}

.fullscreen-bg {
    position: fixed;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    overflow: hidden;
    z-index: -100;
}

.fullscreen-bg__video {
    position: absolute;
    top: 50%;
    left: 50%;
    width: auto;
    height: auto;
    min-width: 100%;
    min-height: 100%;
    -webkit-transform: translate(-50%, -50%);
       -moz-transform: translate(-50%, -50%);
        -ms-transform: translate(-50%, -50%);
	    transform: translate(-50%, -50%);
}

@media (max-width: 767px) {
    .fullscreen-bg {
        background: url('wallpaper-web.png') center center / cover no-repeat;
    }

    .fullscreen-bg__video {
        display: none;
    }
}
}
</style>

<link rel="icon" href="icon.png" type="image/png" sizes="16x16">

</head>

<body>

<div id="wrapper">

<div class="fullscreen-bg">
    <video loop muted autoplay poster="wallpaper-web.png" class="fullscreen-bg__video">
        <source src="wallpaper.mp4" type="video/mp4">
    </video>
</div>

<div class="flex-container">
<header>
<h1 align="center" font-color="white">Donation</h1>
</header>
</div>

<div align="center">
<img src="paypal.png">

</div>

<div align="center">

   <form method="POST" action="donate_do.php">

<a href="#" onclick = "" class="float" data-toggle="modal" data-target="#myModal" ><i class="fa fa-hand-paper-o my-float" ></i></a>
<div class="label-container">
<div class="label-text">Any question?</div>
<i class="fa fa-play label-arrow"></i>
</div> 

   <div class="form-group">
   <label>Amount : <input type="text" class="form-control"  name="amount" required></label> 
   <label><select name = "currency" class = "form-control" required> 
   <!--<option value = "1">Baht</option> -->
   <option value = "2">US Dollar</option>
   <!--<option value = "3">Euro</option>-->
   <!--<option value = "4">Yen</option>-->
   </select>
   </label>
   </div>

   <div class="form-group"><label>Name : <input type="text" class="form-control" name="name" required></label></div>
   <div class="form-group"><label>Email : <input type="text" class="form-control" name="email" required></label></div>
   <button type = "submit" class="btn btn-danger"><span class="glyphicon glyphicon-heart"></span> Submit</button>
   <td><a href="main.php" class="btn btn-primary"><span class="glyphicon glyphicon-home"></span> Back</a></td>
   </form>
  
    </div>

 <a href="#" onclick = "" class="float" data-toggle="modal" data-target="#myModal" ><i class="fa fa-hand-paper-o my-float" ></i></a>

 <div class="label-container">
 <div class="label-text">Any question?</div>
 <i class="fa fa-play label-arrow"></i>
  </div>

       <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      
      <div class="modal-content">
      <div style = "background-color:#191970">
      
      <div align="center"> 

        <div class="modal-topic">
          
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <label>Topic <input type = "Topic" class="form-control"  name="topic" required></label> 
        </div>

        <div class="modal-header">
            <label>Name<input type ="Header" class="form-control" name="name"required></label>
            <label>Email<input type ="Header" class="form-control" name="email"required></label>
        </div>

        <div class="modal-body">
          <label>Detail</label>

         <div class="form-group">
    <textarea class="form-control" placeholder="Type something..."></textarea>
      </div>

        </div>

        <div class="modal-footer">
            <button type = "submit" class="btn btn-success" data-dismiss="modal"><span class="glyphicon glyphicon-envelope"></span> Submit</button>
          <button type="button" class="btn btn-primary" data-dismiss="modal"><span class="glyphicon glyphicon-home"></span> Close</button>
        </div>

        </div>
      </div>
</div>
    </div>
  </div>
     
<div id = "footer">

  <footer>
  <div align = "center">
  <p>Created by: Kawae & Joker [CS Hackathon 2nd]</p>
  </div>
  </footer>

</div>

    </body>
</html>