<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
	// set minutes
	var mins = 1;

	// calculate the seconds (don't change this! unless time progresses at a different speed for you...)
	var secs = mins * 60;
	function countdown() {
		setTimeout('Decrement()', 1000);
	}
	function Decrement() {
		if (document.getElementById) {
			minutes = document.getElementById("minutes");
			seconds = document.getElementById("seconds");
			// if less than a minute remaining
			if (seconds < 59) {
				seconds.value = secs;
			} else {
				minutes.value = getminutes();
				seconds.value = getseconds();
			}
			secs--;
			setTimeout('Decrement()', 1000);
		}
	}
	function getminutes() {
		// minutes is seconds divided by 60, rounded down
		mins = Math.floor(secs / 60);
		return mins;
	}
	function getseconds() {
		// take mins remaining (as seconds) away from total seconds remaining
		return secs - Math.round(mins * 60);
	}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Driver Dash-board</title>
</head>
<body>

	<form align="center" action="AcceptRequest">
		<h4>Taxi is hailed then click here...</h4>
		<input type="button" value="Hailed!!" /> <br />
		<h4>Please accept the request in 10 Seconds...</h4>
		<input type="button" value="Accept the request!"  onClick="EndOfRidePage()"/>
	</form>
	<div id="timer">
		This is only valid for the next <input id="minutes" type="text"
			style="width: 14px; border: none; background-color: none; font-size: 16px; font-weight: bold;">
		minutes and <input id="seconds" type="text"
			style="width: 26px; border: none; background-color: none; font-size: 16px; font-weight: bold;">
		seconds.
	</div>
	<script>
		countdown();
	</script>

</body>
</html>