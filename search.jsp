<!doctype html>
<html>
<head>
<title>Movies: Search</title>
<meta name="description" content="This is a movie website by Jason Friend-Fellows.">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="includes/styles.jsp" %>
</head>
<body>
<div class="container">
	<div class="hero-unit">
		<h1>Search</h1>
	</div>
<%@ include file="includes/navigation.jsp" %>
	<div class="container">
		<form action="Search">
			<label for="title"><strong>Search by Title:</strong></label>
			<input name="title">
			<input type="hidden" name="searchType" value="title">
			<input type="submit" value="Search!">
		</form>
		<form action="Search">
			<label for="director"><strong>Search by Director:</strong></label>
			<input name="director">
			<input type="hidden" name="searchType" value="director">
			<input type="submit" value="Search!">
		</form>
	</div>
	<hr>
<%@ include file="includes/footer.jsp" %>
</div>
<%@ include file="includes/scripts.jsp" %>
</body>
</html>