<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>
<title>Amusement Park | Book Ticket</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</head>
<body>

	<h1>Amusement Park : Book Ticket</h1>
	<h6>
		Logged in as:
		<%=session.getAttribute("cname")%></h6>

	<br>

	<nav class="navbar navbar-expand-sm bg-light">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link h5 " href="HomeServlet">Home</a>
			</li>
			<li class="nav-item"><a
				class="nav-link h5 text-white bg-primary" href="#">Book</a></li>
			<li class="nav-item"><a class="nav-link h5" href="AccountServlet">Account</a>
			</li>
			<li class="nav-item"><a class="nav-link h5 " href="About.jsp">About</a>
			</li>
			<li class="nav-item"><a class="nav-link h5" href="LogoutServlet">Logout</a>
			</li>
		</ul>
	</nav>

	<br>
	<center>
		<form action="EditBookings" method="post">
			<h1>Book Tickets</h1>
			<table class="table-sm table-bordered">
			<input type="hidden" value="edit" name="requesttype">
				<tr>
					<td>Booking Id:</td>
					<td><input type="text" readonly=readonly name="bid"
						value=${bobj.bid}></td>
				</tr>
				<tr>
					<td>Customer Id:</td>
					<td><input type="text" readonly=readonly name="custid"
						value=${bobj.cid}></td>
				</tr>
				<tr>
					<td>Booking Date:</td>
					<td><input type="date" name="bdate" value=${bobj.bookingdate}></td>
				</tr>
				<tr>
					<td>No of Tickets:</td>
					<td><input type="text" name="nooftickets"
						value=${bobj.nooftickets}></td>
				</tr>
				<td>Total Amount:</td>
				<td><input type="text" name="totalcost" value="100"
					readonly="readonly"></td>
				<tr>
				</tr>
				<tr>
					<td>Payment Type:</td>
					<td><select name="paymenttype" value=${bobj.paymenttype}>
							<option value=" "></option>
							<option value="cash">Cash (On that day)</option>
							<option value="card">Card Payment</option>
					</select></td>
				</tr>
				<tr>
					<td></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Save Changes"></td>
				</tr>
			</table>
		</form>
		<br>
		<form action="EditBookings" method="post">
		<input type="hidden" name="bid" value=${bobj.bid}> 
		<input type="hidden" name="requesttype" value="cancel">
		<input type="submit" value="Cancel Booking">

		</form>


		<h6 class="text-info">${updatestatus}</h6>
	</center>
</body>
</html>
