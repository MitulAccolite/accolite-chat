<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport"
		  content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<meta name="description"
		  content="Accolite office chat, a sleek, intuitive, and powerful framework for faster and easier communication.">
	<meta name="keywords"
		  content="Accolite, chat, office-chat, message, connect, team, communicate">
	<meta name="author" content="Lokesh, Sachin, Diksha and Mitul">

	<!-- <link rel='shortcut icon' type='image/x-icon' href='../favicon.ico' /> -->

	<title>Login form :: Accolite office chat</title>

	<link href="<c:url value="/resources/css/login.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/metro.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/metro.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/metro-colors.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/css/metro-colors.min.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/css/metro-icons.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/css/metro-icons.min.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/css/metro-responsive.min.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/css/metro-responsive.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/css/metro-rtl.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/css/metro-rtl.min.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/css/metro-schemes.css"/>" rel="stylesheet">
	<link href="<c:url value="/resources/css/metro-schemes.min.css"/>" rel="stylesheet">

	<script src="<c:url value="/resources/js/jquery-2.1.3.min.js"/>"></script>
	<script src="<c:url value="/resources/js/metro.js"/>"></script>
	<script src="<c:url value="/resources/js/login.js"/>"></script>
	<script src="<c:url value="/resources/js/customMetro.js"/>"></script>
	<script src="<c:url value="/resources/js/metro.min.js"/>"></script>


</head>
<body class="bg-darkTeal">
<section class="block-shadow">
	<div class="wizard2" data-role="wizard2"
		 data-button-labels='{"help": "?", "prev": "<span class=\"mif-arrow-left\"></span>", "next": "<span class=\"mif-arrow-right\"></span>", "finish": "<span class=\"mif-checkmark\"></span>"}'>

		<div class="step">
			<div class="step-content">
				<p class="text-small lowercase no-margin">User Registration</p>
				<h1 class="no-margin-top sub-leader">Enter Credentials</h1>
				<div class="grid">
					<div class="row">
						<div class="cell">
							<div class="input-control modern text iconic" data-role="input">
								<input id="userMail" name="userMail" type="text" style="padding-right: 5px;">
								<span class="label">Your login</span>
								<span class="informer">Please enter your email</span>
								<span class="placeholder" style="display: block;">Input login</span>
								<span class="icon mif-mail"></span>
								<span class="input-state-error mif-warning"></span>
								<span class="input-state-success mif-checkmark"></span>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="cell">
							<div class="input-control modern text iconic" data-role="input">
								<input id="userPassword" name="userPassword" type="password" style="padding-right: 5px;">
								<span class="label">Your Password</span>
								<span class="informer">Please enter your password</span>
								<span class="placeholder" style="display: block;">Login Password</span>
								<span class="icon mif-lock"></span>
								<span class="input-state-error mif-warning"></span>
								<span class="input-state-success mif-checkmark"></span>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="cell">
							<div class="input-control modern text iconic" data-role="input">
								<input id="confirmPassword" type="password" style="padding-right: 5px;" >
								<span class="label">Confirm Your Password</span>
								<span class="informer">Please re-enter your password</span>
								<span class="placeholder" style="display: block;">Confirm Password</span>
								<span class="icon mif-lock"></span>
								<span class="input-state-error mif-warning"></span>
								<span class="input-state-success mif-checkmark"></span>
							</div>
						</div>
					</div>
				</div>
				<div class="text-small padding20 bg-grayLighter">
					Enter your valid mail Id and choose your password such that it should be of at least 8 characters. Then press next.
				</div>
			</div>
		</div>
		<div class="step">
			<div class="step-content">
				<p class="text-small lowercase no-margin">User Registration</p>
				<h1 class="no-margin-top sub-leader">Name</h1>
				<div class="grid">
					<div class="row">
						<div class="cell">
							<div class="input-control modern text iconic" data-role="input">
								<input id="firstName" name="firstName" type="text" style="padding-right: 5px;">
								<span class="label">Your First Name</span>
								<span class="informer">Please enter your first name</span>
								<span class="placeholder" style="display: block;">Harry</span>
								<!-- <span class="input-state-error mif-warning"></span>
                                <span class="input-state-success mif-checkmark"></span> -->
							</div>
						</div>
					</div>
					<div class="row">
						<div class="cell">
							<div class="input-control modern text iconic" data-role="input">
								<input id="middleName" name="middleName" type="text" style="padding-right: 5px;">
								<span class="label">Your Middle Name</span>
								<span class="informer">Please enter your middle name</span>
								<span class="placeholder" style="display: block;">James</span>
								<!-- <span class="input-state-error mif-warning"></span>
                                <span class="input-state-success mif-checkmark"></span> -->
							</div>
						</div>
					</div>
					<div class="row">
						<div class="cell">
							<div class="input-control modern text iconic" data-role="input">
								<input id="lastName" name="lastName" type="text" style="padding-right: 5px;">
								<span class="label">Your last Name</span>
								<span class="informer">Please enter your last name</span>
								<span class="placeholder" style="display: block;">Potter</span>
								<!-- <span class="input-state-error mif-warning"></span>
                                <span class="input-state-success mif-checkmark"></span> -->
							</div>
						</div>
					</div>
					<div class="row">
						<div class="cell">
							<div class="input-control modern text iconic" data-role="input">
								<input id="nickName" name="nickName" type="text" style="padding-right: 5px;">
								<span class="label">Your nick Name</span>
								<span class="informer">Please enter your nick name</span>
								<span class="placeholder" style="display: block;">Parry Hotter</span>
								<!-- <span class="input-state-error mif-warning"></span>
                                <span class="input-state-success mif-checkmark"></span> -->
							</div>
						</div>
					</div>
				</div>
				<div class="text-small padding20 bg-grayLighter">
					Enter your First Name, Middle Name, Last Name and Nick Name. Then press next.
				</div>
			</div>
		</div>
		<div class="step">
			<div class="step-content">
				<p class="text-small lowercase no-margin">User Registration</p>
				<h1 class="no-margin-top sub-leader">Contact</h1>
				<div class="grid">
					<div class="row">
						<div class="cell">
							<div class="input-control modern text iconic" data-role="input">
								<input id="userMobile" name="userMobile" type="number" style="padding-right: 5px;">
								<span class="label">Your Mobile Number</span>
								<span class="informer">Please enter 10 digit mobile no.</span>
								<span class="input-state-error mif-warning"></span>
								<span class="input-state-success mif-checkmark"></span>
							</div>
						</div>
					</div>
				</div>
				<div class="text-small padding20 bg-grayLighter">
					Enter your contact number and press finish.
				</div>
			</div>
		</div>
	</div>	</section>
</body>
</html>

