<%@page import="edu.cvtc.web.model.Movie"%>
<%@page import="edu.cvtc.web.dao.MovieDao"%>
<%@page import="edu.cvtc.web.dao.impl.MovieDaoImpl"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html">
<html>
<head>
<title>Movies by Jason Friend-Fellows: Movie List</title>
<meta name="description" content="This page displays all of the movies that are in the database.">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, intial-scale=1.0">
<link href="assets/css/bootstrap.css" rel="stylesheet" type="text/css">
<link href="assets/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">
	<div class="hero-unit">
		<h1>Movie List</h1>
	</div>
<%@ include file="includes/navigation.jsp" %>
	<div class="container">
<%@ include file="includes/movieView.jsp" %>
		<p>Below is a list of all of the movies in the database.</p>
		
		<%
		final MovieDao movieDao = new MovieDaoImpl();
		final List<Movie> movies = movieDao.retrieveMovies();
		
		if(movies.isEmpty()) {
			%>
			<p>There aren't any movies yet. Please use the add movies page to add movies to the database.</p>
			<%
		} else {
			for(final Movie movie : movies) {
				%>
				<p class="movie"><b>Title:</b> <%=movie.getTitle() %> <%=movie.getDirector() %><br>
				<b>Length in minutes:</b> <%=movie.getLengthInMinutes() %><br>
				<b>IMDB Link:</b><a target="blank" a href=<%=movie.getImdbLink() %>> <%=movie.getTitle() %></a>.</p>
				<%
			}
		}
		%>		
		
	</div>
	<hr>
	<div class="hero-unit">&copy; Copyright 2016 Jason Friend-Fellows</div>
</div>
</body>
</html>