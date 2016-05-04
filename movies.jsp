<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<c:choose>
			<c:when test="${empty movies}">
				<p>Sorry, there were no results.</p>
			</c:when>
			<c:otherwise>
				 <c:forEach var="movie" items="${movies}">
				 	<div class="movieList">
				 		<h2>${movie.title}</h2>
				 			<p>${movie.title} is directed by ${movie.director} and is ${movie.lengthInMinutes} minutes long.
				 			The link to the IMDB website is <a target="blank" href="${movie.imdbLink}">${movie.title}</a>.</p>
			 		</div>
				 </c:forEach>
			</c:otherwise>
		</c:choose>