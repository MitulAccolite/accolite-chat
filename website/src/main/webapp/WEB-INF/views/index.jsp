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

<link href="../css/login.css" rel="stylesheet">
<link href="../css/metro.css" rel="stylesheet">
<link href="../css/metro-icons.css" rel="stylesheet">
<link href="../css/metro-responsive.css" rel="stylesheet">

<script src="../js/jquery-2.1.3.min.js"></script>
<script src="../js/metro.js"></script>
<script src="../js/login.js"></script>
</head>
<body class="bg-darkTeal">
	<section class="block-shadow">
		<div class="login-form padding20">
			<form action="chatRoom" method="POST" data-role="validator"
				data-hint-mode="hint" data-hint-easing="easeOutBounce">
				<h1 class="text-light">Login to Accolite Chat</h1>
				<hr class="thin" />
				<br />
				<div class="input-control text full-size" data-role="input">
					<label for="user_login">User email:</label> 
					<span class="mif-mail prepend-icon"></span>
					<input type="text"
						name="user_login" id="user_login" data-validate-func="email"
						data-validate-hint="This field needs valid email"
						data-validate-hint-position="right">
					<span class="input-state-error mif-warning"></span>
					<span class="input-state-success mif-checkmark"></span>
					<button class="button helper-button clear">
						<span class="mif-cross"></span>
					</button>
				</div>
				<br /> <br />
				<div class="input-control password full-size" data-role="input">
					<label for="user_password">User password:</label>
					<span class="prepend-icon mif-lock"></span>
					<input type="password" name="user_password" id="user_password"
						data-validate-func="minlength" data-validate-arg="8"
						data-validate-hint="This field needs minimum 8 letters"
						data-validate-hint-position="right">
					<span class="input-state-error mif-warning"></span>
					<span class="input-state-success mif-checkmark"></span>
					<button class="button helper-button reveal">
						<span class="mif-looks"></span>
					</button>
				</div>
				<br /> <br />
				<div class="form-actions">
					<button type="submit" class="button primary login">Login</button>
					<button type="button" class="button link register">Register</button>
				</div>
			</form>
		</div>
	</section>
</body>
</html>