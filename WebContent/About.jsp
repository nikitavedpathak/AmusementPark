<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>Park Management | About</title>
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

	<h1>Amusement Park :  About Us</h1>
	<h6>Logged in as: <%=session.getAttribute("cname") %></h6>

	<br>

	<nav class="navbar navbar-expand-sm bg-light">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link h5 " href="HomeServlet">Home</a>
			</li>
			<li class="nav-item"><a class="nav-link h5" href="BookTicket.jsp">Book</a></li>
			<li class="nav-item"><a class="nav-link h5" href="AccountServlet">Account</a>
			</li>
			<li class="nav-item"><a
				class="nav-link h5 text-white bg-primary" href="#">About</a></li>
			<li class="nav-item"><a class="nav-link h5" href="LogoutServlet">Logout</a>
			</li>
		</ul>
	</nav>
<br><br>
<center>
	<div class="col-sm-8">
		<p>The park was established on a limited land of around 7
			acres where the animals used to be housed and displayed to the
			visitors in concrete cages behind the iron bars. It was a typical
			traditional zoo of that time wherein only the objective was a
			recreation for visitors.</p>
		<br>
	</div>
	<div class="jumbotron text-center" style="margin-bottom: 0">
		<p>Contact Us at: 
		Amusement Park
		1800-200-1200</p>
	</div>
</center>

</body>
</html>