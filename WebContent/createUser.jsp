<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Build-A-Puter</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div id="nav">
		<div id="navWrapper">
			<ul>
				<li><a href="index.jsp">Home</a></li>
				<li><a href="#">By Category</a>
					<ul>
						<li><a href="#">Business</a></li>
						<li><a href="#">Social</a></li>
						<li><a href="#">Gaming</a></li>
					</ul>
				</li>
				<li><a href="#">Saved Builds</a></li>
				<li><a href="#">Contact Us</a></li>
				<li><a href="#">Shopping Cart</a></li>
				<li><a href="login.jsp">Login</a></li>
			</ul>
		</div>
	</div>
	<h1>Create Accounts</h1>
	<form method="post" action="HomeController">
		<table>
			<tr><td><label>First Name:</label></td><td><input type="text" name="firstName"></td></tr>
			<tr><td><label>Last Name:</label></td><td><input type="text" name="lastName"></td></tr>
			<tr><td><label>Email:</label></td><td><input type="text" name="email"></td></tr>
			<tr><td><label>Address:</label></td><td><input type="text" name="address"></td></tr>
			<tr><td><label>Phone Number:</label></td><td><input type="text" name="phone"></td></tr>
			<tr><td><label>Username:</label></td><td><input type="text" name="userName"></td></tr>
			<tr><td><label>Password:</label></td><td><input type="password" name="password"></td></tr>
			<tr><td><label>Confirm Password:</label></td><td><input type="password" name="confirmPassword"></td></tr>
			<tr ><td colspan="2"><input type="submit" name="createAccount" value="Create Account"></td></tr>
		</table>
	</form>

</body>
</html>