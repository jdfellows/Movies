<%@page import="edu.cvtc.web.dao.impl.MovieDaoImpl"%>
<%@page import="edu.cvtc.web.dao.MovieDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<title>Create Database</title>
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

	<%
	if(null != request.getParameter("create")){
		
		try{
			final MovieDao movieDao = new MovieDaoImpl();
			movieDao.createDatabase();	
			
			%>
			<p>Success! The database was created.</p>
			<%
			
		} catch (Exception e){
			%>
			<p>Sorry, there was a problem creating the database.</p>
			<p>Error: <%=e.getMessage() %>
			<%
		}

	} else {
		%>
		<p>To create the Movie database use the create button below.</p>
		<form method ="post">
			<div class="form-group">
				<input type="submit" name="create" value="Create!">
			</div>	
		</form>
		<%
	}
	%>
	</div>
	<hr>
<%@ include file="includes/footer.jsp" %>
</div>
<%@ include file="includes/scripts.jsp" %>
</body>
</html>