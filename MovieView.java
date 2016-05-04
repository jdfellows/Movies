package edu.cvtc.web.view;

import java.util.List;

import edu.cvtc.web.model.Movie;

/**
 * @author Jason Friend-Fellows
 *
 */
public class MovieView {
	
	public static String buildHTML(final List<Movie> movies){
		final StringBuilder out = new StringBuilder();
		
		out.append("<!doctype html>");
		out.append("\n<html lang='en'>");
		out.append("\n<head>");
	    out.append("\n\t<meta charset='utf-8'>");
	    out.append("\n\t<meta name='Author' content='Jason Friend-Fellows' />");
	    out.append("\n\t<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
		out.append("\n\t<link href='./style/style.css' rel='stylesheet' type='text/css'>");
		out.append("\n\t<title>Movies</title>");
		out.append("\n</head>");
		out.append("\n<body>");
		out.append("\n\t<div id='wrapper'>");
		out.append("\n\t\t<nav id='nav' role='navigation'>");
		out.append("\n\t\t\t<ul>");
		out.append("\n\t\t\t\t<li><a href=Home>Home</a></li>");
		out.append("\n\t\t\t\t<li><a href=Movies>Movies</a></li>");	
		out.append("\n\t\t\t</ul>");
		out.append("\n\t\t</nav>");
		out.append("\n\t\t<h1>Movies List</h1>");
		out.append("\n\t\t<section id='content'>");
		
		out.append(NavView.buildNavigation());
		
		if(movies.isEmpty()){
			out.append("\n\t\t<p>Sorry, we were unable to find any results.</p>");
		} else {
		
		for(final Movie movie : movies){
			out.append("\n\t\t<div class=\"movie\">\n\t\t\t<h2>" + movie.getTitle() + "</h2>");
			out.append("\n\t\t\t<p>" + movie.getTitle() + " is directed by " + movie.getDirector() + " and is " + movie.getLengthInMinutes() 
					+ " minutes long." + " The link to IMDB is <a target=\"blank\"a href=\"" + movie.getImdbLink() + "\">" + movie.getTitle() + "</a>." + "</p>\n\t\t</div>");
		}
	}
		
		out.append("\n\t\t</section'>");
		
		out.append("\n\t\t<footer><p>&copy; Copyright 2016 Jason Friend-Fellows</p></footer>");
		out.append("\n\t</div");
		out.append("\n</body>");
		out.append("\n</html>");
		
		return out.toString();
	}

}
