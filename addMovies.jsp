<!doctype html>
<html>
<head>
<title>Movies: Add Movie</title>
<meta name="description" content="This is a movie website by Jason Friend-Fellows.">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="includes/styles.jsp" %>
</head>
<body>
<div class="container">
	<div class="hero-unit">
		<h1>Add a Movie!</h1>
	</div>
<%@ include file="includes/navigation.jsp" %>
	<div class="container">
		<form action="AddMovie">
			<label for="title"><strong>Title:</strong></label>
			<input name="title" id=title><br><br>
			
			<label for="director"><strong>Director:</strong></label>
			<input name="director" id=director><br><br>
		
			<label for="lengthInMinutes"><strong>Length in minutes:</strong></label>
			<input name="lengthInMinutes" id=lengthInMinutes><br><br>
			
			<label for="imdbLink"><strong>IMDB Link:</strong></label>
			<input name="imdbLink" id=imdbLink><br><br>
			
			<input class="addButton" name="submit" type="submit" value="Add Movie!">
		</form>
	</div>
	<hr>
<%@ include file="includes/footer.jsp" %>
</div>
<%@ include file="includes/scripts.jsp" %>
</body>
</html>