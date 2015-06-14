<?php
require('config.php');
?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
		<link rel="stylesheet" href="jquery-jvectormap-1.0.css" type="text/css" media="screen"/>
		<link rel="stylesheet" href="bootstrap.min.css" />
		<link rel="stylesheet" href="bootstrap-responsive.min.css" />
	    <link rel="stylesheet" type="text/css" media="all" href="stailo.css" />
    <script src="jquery-1.9.1.min.js"></script>


    	<!--[if lt IE 9]>
    	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
  		<![endif]-->

</head>

<body>

<?php
if(isset($_GET['id'])){
    $id = htmlspecialchars($_GET['id'], ENT_QUOTES);

$sql=("SELECT * FROM status WHERE district='$id'");
if ($result = mysqli_query($con,$sql))
  {
    $loc = array();
    $stat = array();
  while ($d=mysqli_fetch_object($result))
    {
    $lat = $d->lat;
    $long = $d->long;
    $status = $d->status;
    $stat[] = $d->status;
    $loc[] = "['$status<br>Lat: $lat, Lon: $long', $lat, $long]";
    }
        $loc = implode(', ', $loc);
        $stat = implode(', ', $stat);

}

}
else{
    header('Location:index.php');
}


?>

<script>

function initialize() {
    var locations = [
<?php echo $loc;?>
    ];

    window.map = new google.maps.Map(document.getElementById('map'), {
        mapTypeId: google.maps.MapTypeId.ROADMAP
    });

    var infowindow = new google.maps.InfoWindow();

    var bounds = new google.maps.LatLngBounds();


    for (i = 0; i < locations.length; i++) {
        marker = new google.maps.Marker({
            position: new google.maps.LatLng(locations[i][1], locations[i][2]),
            map: map
        });

        bounds.extend(marker.position);

        google.maps.event.addListener(marker, 'click', (function (marker, i) {
            return function () {
                infowindow.setContent(locations[i][0]);
                infowindow.open(map, marker);

            }
        })(marker, i));
    }

    map.fitBounds(bounds);

    var listener = google.maps.event.addListener(map, "idle", function () {
        map.setZoom(15);
        google.maps.event.removeListener(listener);
    });
}

function loadScript() {
    var script = document.createElement('script');
    script.type = 'text/javascript';
    script.src = 'http://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false&' + 'callback=initialize';
    document.body.appendChild(script);
}

window.onload = loadScript;
</script>

    <div id="wrap">
    	<div class="page-header" id="header">
            <img src="img/heyz.png" width="120px">
			<blockquote class="pull-right">
		</div>
        <div class="container-fluid">
			<div class="row-fluid" id="body">
                <div class="span2">
                    <div class="sidebar-nav">
                        <ul class="nav nav-list">
                            <li class="nav-header"><a href="index.php">MALAYSIA</a></li>
                            <li><a href="johor.php"><i class="icon-home"></i> Johor</a></li>
                            <li><a href="kedah.php"><i class="icon-home"></i> Kedah</a></li>
                            <li><a href="kelantan.php"><i class="icon-home"></i> Kelantan</a></li>
                            <li><a href="melaka.php"><i class="icon-home"></i> Melaka</a></li>
                            <li><a href="n9.php"><i class="icon-home"></i> Negeri Sembilan</a></li>
                            <li><a href="pahang.php"><i class="icon-home"></i> Pahang</a></li>
                            <li><a href="perak.php"><i class="icon-home"></i> Perak</a></li>
                            <li><a href="perlis.php"><i class="icon-home"></i> Perlis</a></li>
                            <li><a href="penang.php"><i class="icon-home"></i> Pulau Pinang</a></li>
                            <li><a href="sabah.php"><i class="icon-home"></i> Sabah</a></li>
                            <li><a href="sarawak.php"><i class="icon-home"></i> Sarawak</a></li>
                            <li><a href="sarawak.php"><i class="icon-home"></i> Sarawak</a></li>
                            <li><a href="selangor.php"><i class="icon-home"></i> Selangor</a></li>
                            <li><a href="terengganu.php"><i class="icon-home"></i> Terengganu</a></li>
                            <li><a href="kl.php"><i class="icon-home"></i> Kuala Lumpur</a></li>
                            <li><a href="putrajaya.php"><i class="icon-home"></i> Putrajaya</a></li>
                            <li><a href="labuan.php"><i class="icon-home"></i> Labuan</a></li>
                        </ul>
					</div>


				</div>
                <div class="container-fluid span10" id="content">
<a href="#" onclick="javascript:history.back();">
    <button type="button" class="btn btn-info" aria-label="Left Align">
  <i class="icon-circle-arrow-left" aria-hidden="true"></i>
  Back
</button>
</a>
<div style="margin:30px 50px;">
<?php

if(isset($_GET['id'])){
    $id = htmlspecialchars($_GET['id'], ENT_QUOTES);
    echo "<h4>$id</h4>";
    echo "<p>Opportunity: <b>ICT Sector</b></p>";
    echo "<p>Population: <b>1,812,633</b></p>";
}

?>

<div id="map" style="width: 100%; height: 300px;"></div>

<?php
echo "<p style=\"margin:10px; font-size:12px;\">Nearby Interest: <i>$stat</i></p>";
?>

</div>
                </div> <!-- end content -->
            </div>
        </div>

    </div>

</body>
</html>