<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="form.css" rel="stylesheet" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Taxi Services</title>
</head>
<body>
	<form action="/HomePage" align="center">
		<h1 align="center">Welcome to the TAXI/Instant Cab Services.</h1>
	</form>

	<table align="center">
		<tr>
			<td>
				<form action="#" method="post" name="customer-login-form">
					<fieldset>
						<legend align="top">Customer Login</legend>
						<table border="0" align="center">
							<tr>
								<td><label>Customer Name:</label></td>
								<td><input type="text" name="customername" /></td>
							</tr>
							<tr>
								<td><label>Password:</label></td>
								<td><input type="password" name="password" /></td>
							</tr>
							<tr>
								<td><input type="submit" name="customersubmit" value="Login" />
								</td>
								<td><input type="button" name="cancel" value="Cancel" /></td>
							</tr>

						</table>
					</fieldset>
				</form>
			</td>
			<td>


				<form action="#" method="post" name="driver-login-form">
					<fieldset>
						<legend align="top">Driver Login</legend>
						<table border="0" align="center">
							<tr>
								<td><label>Driver Name:</label></td>
								<td><input type="text" name="drivername" /></td>
							</tr>
							<tr>
								<td><label>Password:</label></td>
								<td><input type="password" name="driverpassword" /></td>
							</tr>
							<tr>
								<td><input type="submit" name="driversubmit" value="Login" />
								</td>
								<td><input type="button" name="cancel" value="Cancel" /></td>
							</tr>

						</table>
					</fieldset>
				</form>

			</td>
		</tr>
		<tr>
			<h4 align="center">
				if you are a CabStaff <a href=""> go here!</a><br />
			</h4>
		</tr>
	</table>

</body>
</html>