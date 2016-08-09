<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Chat Application - Accolite</title>

    <!-- Bootstrap Core CSS -->
    <link href="/resources/theme1/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href=" /resources/theme1/vendor/font-awesome/css/font-awesome.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">

    <!-- Theme CSS -->
    <link href="/resources/theme1/css/grayscale.min.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	
	
	<script type="text/javascript" src="/resources/theme1/js/TweenLite.min.js"></script>
	<script type="text/javascript" src="/resources/theme1/js/TweenMax.min.js"></script>
	<script type="text/javascript" src="/resources/theme1/js/jquery-1.8.3.min.js"></script>
	
	<style>
	#btn1{
		background:#06F;
		height:150px;
		width:400px;
		position:relative;
		margin-left:10px;
		margin-top:50px;
		left:900px;
		
		color:#FFF;
		font-size:25px;
		font-family:"Lucida Sans Unicode", "Lucida Grande", sans-serif;
		line-height:300px;
		padding-left:10px;
		text-align:center;

	
	
	}
	#btn2{
		background:#C30;
		height:150px;
		width:400px;
		position:relative;
		margin-left:10px;
		margin-top:50px;
		left:900px;
		
		color:#FFF;
		font-size:25px;
		font-family:"Lucida Sans Unicode", "Lucida Grande", sans-serif;
		line-height:300px;
		padding-left:10px;
		text-align:center;
	}

	#btn3{
		background:#F60;
		border-color:#F60;
		height:150px;
		width:400px;
		position:relative;
		margin-left:10px;
		margin-top:50px;
		left:900px;
		
		color:#FFF;
		font-size:25px;
		font-family:"Lucida Sans Unicode", "Lucida Grande", sans-serif;
		line-height:300px;
		padding-left:10px;
		text-align:center;
	}

	#btn4{
		background:#C3C;
		border-color:#F60;
		height:150px;
		width:400px;
		position:relative;
		margin-left:10px;
		margin-top:50px;
		left:900px;
		
		color:#FFF;
		font-size:25px;
		font-family:"Lucida Sans Unicode", "Lucida Grande", sans-serif;
		line-height:300px;
		padding-left:10px;
		text-align:center;
	}
	</style>
	
</head>

<body id="page-top" data-spy="scroll" data-target=".navbar-fixed-top">

    <!-- Navigation -->
    <nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                    Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand page-scroll" href="#page-top">
                    <i class="fa fa-play-circle"></i> <span class="light">Start</span> Chatster
                </a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
                <ul class="nav navbar-nav">
                    <!-- Hidden li included to remove active class from about link when scrolled up past about section -->
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#about">Features</a>
                    </li>
        
                    <li>
                        <a class="page-scroll" href="#contact">Contact</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

    <!-- Intro Header -->
    <header class="intro">
        <div class="intro-body">
            <div class="container">
                <div class="row">
                    <div class="col-md-8 col-md-offset-2">
                        <h1 class="brand-heading">CHATSTER</h1>
						<br/>
						<br/>
                        <p class="intro-text">Chat Portal to Join, Share and Chat
                            <br>For Accolite Employees</p>
                        <form  action="/getstarted">
						<input type="submit" class="btn btn-default btn-lg" value="Let's Get Started"/>
						<br/>
                        </form>
                        <a href="#about" class="btn btn-circle page-scroll">
                            <i class="fa fa-angle-double-down animated"></i>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- Features Section -->
    <section id="about" class="container content-section text-center">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2">
                <h2>About Chat Application</h2>
                <p></p>
                <p></p>
                <p></p>
            </div>
        </div>
    </section>

    <!-- Contact Section -->
    <section id="contact" class="container content-section text-center">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2">
                <h2>Contact Us</h2>
                <div style="width:1000px; height:450px; overflow:hidden; margin: 0 auto; position:relative; margin-top:35px;">

					<div id="btn1" style="float:left"> <p style="-webkit-text-stroke-width: 0px;-webkit-text-stroke-color: none;"> DIKSHA <br/> Software Engineer <br/> diksha.garg@accoliteindia.com <br/> +91-8427110970 </p> </div> 
					<div id="btn2" style="float:left"> <p style="-webkit-text-stroke-width: 0px;-webkit-text-stroke-color: none;"> MITUL KAPOOR <br/> Software Engineer <br/> mitul.kapoor@accoliteindia.com <br/> +91-9899028606 </p> </div>
					<div id="btn3" style="float:left"> <p style="-webkit-text-stroke-width: 0px;-webkit-text-stroke-color: none;"> LOKESH K <br/> Software Engineer <br/> lokesh.k@accoliteindia.com <br/> +91-9944966067 </p> </div>
					<div id="btn4" style="float:left"> <p style="-webkit-text-stroke-width: 0px;-webkit-text-stroke-color: none;"> SACHIN GUPTA <br/> Software Engineer <br/> sachin.gupta@accoliteindia.com <br/> +91-8053516559 </p> </div>
					
				</div>

            </div>
        </div>
    </section>

    <!-- Map Section -->
    <div id="map"></div>

    <!-- Footer -->
    <footer>
        <div class="container text-center">
            
        </div>
    </footer>
	
	<script>
		$(document).ready(function(){
		  TweenLite.to($("#btn1"),2,{css:{left:0},delay:1, ease:Power2.easeOut});
		  TweenLite.to($("#btn2"),2,{css:{left:20},delay:1.5, ease:Power2.easeOut});
		  TweenLite.to($("#btn3"),2,{css:{left:0},delay:2, ease:Power2.easeOut});
		  TweenLite.to($("#btn4"),2,{css:{left:20},delay:2.5, ease:Power2.easeOut});
  
  });
	</script>
	
	
    <!-- jQuery -->
    <script src="/resources/theme1/vendor/jquery/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/resources/theme1/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

    <!-- Google Maps API Key - Use your own API key to enable the map feature. More information on the Google Maps API can be found at https://developers.google.com/maps/ -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCRngKslUGJTlibkQ3FkfTxj3Xss1UlZDA&sensor=false"></script>

    <!-- Theme JavaScript -->
    <script src="/resources/theme1/js/grayscale.min.js"></script>

</body>

</html>
