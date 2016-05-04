package edu.cvtc.web.view;

/**
 * @author Jason Friend-Fellows
 *
 */
public class ErrorView {

	public static String buildHTML(final String errorMessage){
		final StringBuilder out = new StringBuilder();
		
		out.append("<!doctype html>");
		out.append("\n<html lang='en'>");
		out.append("\n<head>");
	    out.append("\n\t<meta charset='utf-8'>");
	    out.append("\n\t<meta name='Author' content='Jason Friend-Fellows' />");
	    out.append("\n\t<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
		out.append("\n\t<link href='./style/style.css' rel='stylesheet' type='text/css'>");
		out.append("\n\t<title>Error Page</title>");
		out.append("\n</head>");
		out.append("\n<body>");
		out.append("\n\t<div id='wrapper'>");
		out.append("\n\t\t<nav id='nav' role='navigation'>");
		out.append("\n\t\t\t<ul>");
		out.append("\n\t\t\t\t<li><a href=Home>Home</a></li>");
		out.append("\n\t\t\t\t<li><a href=Movies>Movies</a></li>");	
		out.append("\n\t\t\t</ul>");
		out.append("\n\t\t</nav>");
		out.append("\n\t\t<h1>Error Page</h1>");
		out.append("\n\t\t<section id='content'>");
				
		out.append("<p>" + errorMessage + "</p>");
		
		out.append("\n\t\t<footer><p>&copy; Copyright 2016 Jason Friend-Fellows</p></footer>");
		
		return out.toString();
	}
}
