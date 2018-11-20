<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="en">

<head>
<title>Amusement Park | HomePage</title>
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

	<h1>Amusement Park : HomePage</h1>
	<h6>
		Logged in as:
		<%=session.getAttribute("cname")%>
	</h6>

	<br>

	<nav class="navbar navbar-expand-sm bg-light">
		<ul class="navbar-nav">
			<li class="nav-item"><a
				class="nav-link h5 text-white bg-primary" href="#">Home</a></li>
			<li class="nav-item"><a class="nav-link h5"
				href="BookTicket.jsp">Book</a></li>
			<li class="nav-item"><a class="nav-link h5" href="AccountServlet">Account</a>
			</li>
			<li class="nav-item"><a class="nav-link h5 " href="About.jsp ">About</a>
			</li>
			<li class="nav-item"><a class="nav-link h5" href="LogoutServlet">Logout</a>
			</li>
		</ul>
	</nav>
<br>
<center>
	<div id="trips">

		<h4>Upcoming Tickets</h4><br>
		<table class="table-sm table-bordered">
			<thead>

				<th>Booking Date</th>
				<th>Operation</th>
			</thead>
			<c:forEach var="x" items="${blist}">
				<tbody>

					<tr>
						<td>${x.bookingdate}</td>
						<td><a href="EditBookings?bid=${x.bid}">Edit</a></td>
					</tr>

				</tbody>
			</c:forEach>
		</table>

	</div>

</center>
</body>
</html>
