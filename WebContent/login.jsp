<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<!-- <div id="nav">
		<div id="navWrapper">
			<ul>
				<li><a href="#">Menu</a>
					<ul>
						<li><a href="#">Saved Builds</a></li>
						<li><a href="#">Contact Us</a></li>
						<li><a href="#">Shopping Cart</a></li>
						<li><a href="login.jsp">Login</a></li>
					</ul>
				</li>
				<li id="title"><a href="index.jsp">Build-A-Pooter</a></li>
				<li><a href="login.jsp">Login</a></li>
			</ul>
			
		</div>
	</div> -->
	<form method="post" action="HomeController">
		<input type="text" name="userNameLogin"/> <input type="password" name="passwordLogin"/> <input type="submit"
			name="login" value="Login" />
	</form>
	<a href="createUser.jsp">Create Account</a>
</body>
</html>