package edu.cvtc.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/Home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// NOTES print out a home HTML doc
		// http://localhost:8080/Movies/Home
		final PrintWriter out = response.getWriter();
		out.append("<!doctype html>");
		out.append("\n<html lang='en'>");
		out.append("\n<head>");
	    out.append("\n\t<meta charset='utf-8'>");
	    out.append("\n\t<meta name='Author' content='Jason Friend-Fellows' />");
	    out.append("\n\t<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
		out.append("\n\t<link href='./assets/css/main.css' rel='stylesheet' type='text/css'>");
		out.append("\n\t<title>Home</title>");
		out.append("\n</head>");
		out.append("\n<body>");
		out.append("\n\t<div id='wrapper'>");
		out.append("\n\t\t<nav id='nav' role='navigation'>");
		out.append("\n\t\t\t<ul>");
		out.append("\n\t\t\t\t<li><a href=Home>Home</a></li>");
		out.append("\n\t\t\t\t<li><a href=Movies>Movies</a></li>");		
		out.append("\n\t\t\t</ul>");
		out.append("\n\t\t</nav>");
	
		out.append("\n\t\t<h1>Welcome to my site!</h1>");
		out.append("\n\t\t<section id='content'>");
		
		out.append("\n\t\t\t<p>I've compiled a small list of my favorite films from my personal library. They range from Action, Comedy, Horror and Romance genres."
				+ " Please view my <a href=Movies>Movies</a> page to see my list of movies.</p>");
		out.append("\n\t\t\t<p>The list is sortable by Title of the movie, who Directed the film and the length in minutes.</p>");

		out.append("\n\t\t</section'>");
				
		out.append("\n\t\t<footer><p>&copy; Copyright 2016 Jason Friend-Fellows</p></footer>");
		out.append("\n\t</div");
		out.append("\n</body>");
		out.append("\n</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
