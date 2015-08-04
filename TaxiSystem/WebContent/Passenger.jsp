<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<script>
	$(function() {
		$("#datepicker").datepicker();
	});
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Passenger Login</title>
</head>
<body>
	<form action="login">
		<table align="center">
			<tr>
				<td>UserName:</td>
				<td><input type="text" id="username" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" id="password" /></td>
			</tr>
			<tr>
				<td><input type="button" value="Cancel"></td>
				<td><input type="submit" value="Log In"></td>
			</tr>
		</table>
	</form>

	<form action="" align="center">

		<h1>Welcome User</h1>
		<h2>Book A Taxi</h2>
		<h3>Phone details : 585 298 3940</h3>
		<br /> <br />

		<h2>Book an InstantCab</h2>
		<INPUT TYPE="radio" NAME="cabtime" VALUE="now" CHECKED> Now |
		<INPUT TYPE="radio" NAME="cabtime" VALUE="later"> Later <BR />
		<script>
			$("input[type=radio][checked]").each(function() {
		</script>
		Date: <input type="text" id="datepicker" /> |
		Time: <input type="text" id="timepicker" />
		<script>
			});
		</script>

		<br /> Car Type: <INPUT TYPE="radio" NAME="cabtype" VALUE="uberx"
			CHECKED> UberX | <INPUT TYPE="radio" NAME="cabtype"
			VALUE="uberlx"> UberLX <br />
		<h4>Pickup Location:</h4>
		<h4>Destination:</h4>
		<h4>Cost Estimation:</h4>
		<input type="button" value="Cancel"> | <input type="submit"
			value="Log In">
	</form>
</body>
</html>