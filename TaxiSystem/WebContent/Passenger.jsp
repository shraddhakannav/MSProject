<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Passenger Login</title>
</head>
<body>

	<form action="" align="center">

		<h1>Welcome User</h1>

		<table align="center">
			<tr>
				<td>
					<h2>Book A Taxi</h2>
				</td>
				<td>
					<h3>Phone details : 585 298 3940</h3>
				</td>
			</tr>
		
			<tr>
					<h2>Book an InstantCab</h2>
			</tr>
			<tr>
				<td><INPUT TYPE="radio" NAME="cabtime" VALUE="now" CHECKED>
					Now |</td>
				<td><INPUT TYPE="radio" NAME="cabtime" VALUE="later">
					Later <BR /></td>
			</tr>
			<tr>
				<td>
					<h2>Date:</h2>
				</td>
				<td><input type="date" id="datepicker" /></td>
			</tr>
			<tr>
				<td>
					<h2>Time:</h2>
				</td>
				<td><input type="time" id="timepicker" /></td>
			</tr>
			
			<tr>
			<h2>
			Cab Type:
			</h2>
			
		<INPUT TYPE="radio" NAME="cabtype"
			VALUE="instantcab" CHECKED> InstantCab | <INPUT TYPE="radio"
			NAME="cabtype" VALUE="luxurycab"> LuxuryCab <br />
			</tr>
		</table>

		<h4>
			Pickup Location: <select id="pickuplocations">
				<option>Location 1</option>
				<option>Location 2</option>
				<option>Location 3</option>
				<option>Location 4</option>
				<option>Location 5</option>
			</select>

		</h4>
		<h4>
			Destination:<select id="droplocations">
				<option>Location 1</option>
				<option>Location 2</option>
				<option>Location 3</option>
				<option>Location 4</option>
				<option>Location 5</option>
			</select>
		</h4>
		<h4>Cost Estimation:</h4>
		<input type="button" value="Cancel"> | <input type="submit"
			value="Log In">
	</form>
</body>
</html>