<!DOCTYPE html>
<html class="no-js">
<head>
	<meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
		<link rel="stylesheet" href="jquery-jvectormap-1.0.css" type="text/css" media="screen"/>
		<link rel="stylesheet" href="bootstrap.min.css" />
		<link rel="stylesheet" href="bootstrap-responsive.min.css" />
	    <link rel="stylesheet" type="text/css" media="all" href="stailo.css" />
	    <script src="jquery-1.9.1.min.js"></script>
		  <script src="jquery-1.7.2.min.js"></script>
		  <script src="jquery.browser.js"></script>
    <link href="kendo.common.min.css" rel="stylesheet" />
    <link href="kendo.default.min.css" rel="stylesheet" />
    <script src="jquery-1.9.1.min.js"></script>
    <script src="kendo.all.min.js"></script>

        <link rel="stylesheet" type="text/css" href="jquery.easy-pie-chart.css" media="screen">

    	<!--[if lt IE 9]>
    	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
  		<![endif]-->


</head>

<body onload="initPieChart();">
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

<div id="chart" style="background: center no-repeat url('img/world-map.png');"></div>

            <script>
                function createChart() {
                    $("#chart").kendoChart({
                        title: {
                            position: "top",
                            text: "Top 10 Interest"
                        },
                        legend: {
                            visible: true,
                            position: "bottom"
                        },
                        chartArea: {
                            background: ""
                        },
                        seriesDefaults: {
                            labels: {
                                visible: true,
                                background: "transparent",
                                template: "#= category #: #= value#%"
                            }
                        },
                        series: [
                        {
                            type: "pie",
                            startAngle: 150,
                            data: [
                            { category: "IT Security", value: 20, color: "#0B3B0B" },
                            { category: "Programming", value: 10, color: "#0B610B" },
                            { category: "Designing", value: 10, color: "#088A08" },
                            { category: "Business", value: 10, color: "#04B404" },
                            { category: "Sex", value: 10, color: "#FF0000" },
                            { category: "Accounting", value: 0, color: "#00FF00" },
                            { category: "Management", value: 10, color: "#2EFE64" },
                            { category: "Shopping", value: 10, color: "#58FA82" },
                            { category: "Gaming", value: 10, color: "#81F781" },
                            { category: "Sports", value: 10, color: "#BCF5A9" },
                            ]
                        }],
                        tooltip: {
                            visible: true,
                            format: "{0}%"
                        }
                    });
                }

                $(document).ready(function() {
                    setTimeout(function() {
                        createChart();

                    }, 400);
                });
            </script>

                </div> <!-- end content -->
            </div>
        </div>

    </div>

</body>
</html>