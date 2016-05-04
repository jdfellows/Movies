<!doctype html>
<html>
<head>
<title>Movies: Index</title>
<meta name="description" content="This is a movie website by Jason Friend-Fellows.">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="includes/styles.jsp" %>
</head>
<body>
<div class="container">
	<div class="hero-unit">
		<h1>Welcome to my Movie site!</h1>
	</div>
<%@ include file="includes/navigation.jsp" %>
	<div class="container">
		<p>I've compiled a small list of my favorite films from my personal library. They range from Action, Comedy, Horror and Romance genres.</p>
		<p>Select the <a href="ViewAll">View All</a> to see the full list. It is sort able by Title of the movie, who Directed the movie and the length in minutes.  To re-populate the database,
		<a href="populateDatabase.jsp">click here</a>.</p>
	</div>
	<hr>
<%@ include file="includes/footer.jsp" %>
</div>
<%@ include file="includes/scripts.jsp" %>
</body>
</html>