<?php

$location = "mysql.ilab.sit.kmutt.ac.th";
$username = "csc105_group16";
$password = "WpzSiT7472?";
$dbname = "csc105_group16";

$conn = new mysqli($location, $username, $password, $dbname);

if($conn->connect_error) {
	die("Connection failed: ". $conn->connect_error);
}

$res = $conn->query("SELECT amount FROM `db_total` WHERE 1");

while(($row=$res->fetch_assoc())!=null){
$total = $row["amount"];
}

$max = 500000;
$cal = (($total*100)/$max);
$currency = "USD";

?>

<html>
<head>

<title>Waterative : Changing life easier</title>

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

body{
font-family: Arial, Helvetica, sans-serif;
margin:0;
padding:0;
height:100%;
color:#FFF;
}

m{
  text-align: center;
  font-size: 40px;
}
#content {
	padding-bottom:100px; 
}
#wrapper {
	min-height:100%;
	position:relative;
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


.fullscreen-bg {
    position: fixed;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    overflow: hidden;
    z-index: -100;
}

h2{
font-size:20px;
font-family:"serif";
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
 img { 
     display:block; 
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
    
<div id = "content">   

<div class="flex-container">

<header>
<h1><center>Waterative : Changing life easier</center></h1>
</header>

</div>

<div align="center">
<img src="pic_1.png">

 <div class = "container">
    <br />
    <br />
 </div>

 <h1><center>Crowdfunding for new generation of drinking water</center></h1>
<div class = "container">

 <div class="progress">

   <div class="progress-bar progress-bar-striped active" role="progressbar" aria-valuenow="<?php echo $total ?>" aria-valuemin="0" aria-valuemax="<?php echo $max ?>" style="width:<?php echo $cal ?>%">
   <p><?php echo $total ?> / <?php echo $max ?> <?php echo $currency ?></p>
 </div>

</div>

<br/>

<div class = "text">
<m>Remaining Time</m>
</div>

<m id="demo"></m>

<script>
// Set the date we're counting down to
var countDownDate = new Date("May 10, 2020 15:00:00").getTime();

// Update the count down every 1 second
var x = setInterval(function() {

    // Get todays date and time
    var now = new Date().getTime();
    
    // Find the distance between now an the count down date
    var distance = countDownDate - now;
    
    // Time calculations for days, hours, minutes and seconds
    var days = Math.floor(distance / (1000 * 60 * 60 * 24));
    var hours = Math.floor((distance % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
    var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
    var seconds = Math.floor((distance % (1000 * 60)) / 1000);
    
    // Output the result in an element with id="demo"
    document.getElementById("demo").innerHTML = days + "d " + hours + "h "
    + minutes + "m " + seconds + "s ";
    
    // If the count down is over, write some text 
    if (distance < 0) {
        clearInterval(x);
        document.getElementById("demo").innerHTML = "EXPIRED";
    }
}, 1000);
</script>

<br />
<br />

 <div class = "container">
 <img src="pic_2.png" width="400" height="209" align="left">
 
 <div class = "w3-container"> </div>
 <div align = "left">
 
 <h1><font color="lightblue">&nbsp;  5 Preposterous Facts about Plastic Pollution.<br /></font></h1>
 <h2 class="serif">

  
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 1. Plastic accounts for around 10 percent of the total waste we generate. <br />
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 2. Annually approximately 500 billion plastic bags are used worldwide.<br />
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; More than one million bags are used every minute. <br />
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 3. 50 percent of the plastic we use, we use just once and throw away. <br />
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 4. It takes 500-1,000 years for plastic to degrade. <br />
 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 5. We currently recover only five percent of the plastics we produce.<br /> 
 <br />
 <br />
 
 </h2>

 </div>
 </div>

 <div class ="container">
 <img src="pic_3.png" width="400" height="266" align="left">

 <div align = "left">
 <h1><font color=lightblue>&nbsp;  3 Ways To “Rise Above Plastic.<br /></font></h1>
 <h2 class="serif">

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 1. Choose to reuse when it comes to shopping bags and bottled water. <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Cloth bags and metal or glass reusable bottles are available locally at <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; great prices.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 2. Refuse single-serving packaging, excess packaging, straws and <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; other "disposable" plastics. Carry reusable utensils in your purse,  <br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; backpack or car to use at bbq's, potlucks or take-out restaurants.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 3. Drink a water with new innovative, such as edible water ball, etc.<br />
<br />
<br />
<br />

 </h2>
</div>
</div>

<div align="center">

			<table class="table table-hover" style ="width:50%" >
				<thead>
						<tr>
							<th style="text-align:center">Name</th>
							<th style="text-align:center">Amount</th>
						</tr>
				</thead>
                <tbody>

			<?php
            $res = $conn->query("SELECT * FROM db_waterative,db_currency WHERE db_waterative.currency=db_currency.id ORDER BY db_waterative.amount DESC");
			while(($row = $res->fetch_assoc()) != null) {?>
						<div class="w3-container">
						<tr>
							<td style="text-align:center"><?php echo $row["name"];?></td>
							<td style="text-align:center"><?php echo $row["amount"];?><?php echo " "?><?php echo $row["cur_name"];?></td>    
						</tr>
						</div>
			<?php
			}
			?>     
				</tbody>

                 </div>
        <div align="center">
                 <label><a href="donate.php" class="btn btn-success btn-lg"><span class="glyphicon glyphicon-gift"></span> Donate</a></label>
        </div>


       <a href="#" onclick = "" class="float" data-toggle="modal" data-target="#myModal" ><i class="fa fa-hand-paper-o my-float" ></i></a>

       <div class="label-container">
       <div class="label-text">Any question?</div>
       <i class="fa fa-play label-arrow"></i>
       </div>
                 
  </div> 
  </div>

   <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      
      <div class="modal-content">
      <div style = "background-color:#191970">
      
      
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

  <div id = "footer">
  <footer>
  <p>Created by: Kawae & Joker [CS Hackathon 2nd]</p>
  </footer>
</div>

    </body>
</html>