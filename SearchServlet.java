package edu.cvtc.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cvtc.web.view.NavView;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/Search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final PrintWriter out = response.getWriter();
		
		out.append("<!doctype html>");
		out.append("\n<html lang='en'>");
		out.append("\n<head>");
	    out.append("\n\t<meta charset='utf-8'>");
	    out.append("\n\t<meta name='Author' content='Jason Friend-Fellows' />");
	    out.append("\n\t<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
		out.append("\n\t<link href='./assets/css/main.css' rel='stylesheet' type='text/css'>");
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
		
		out.append("\n\t\t\t</section'>");
		
		// NOTES: Create a new web form for searching by title and director
		out.append("\n\t<div class=\"containerTitle\">\n\t\t<form action=\"SearchByTitle\">"
				+ "\n\t\t\t<label for=\"title\"><strong>Search by Title:</strong></label>"
				+ "\n\t\t\t<input name=\"title\" />"
				+ "\n\t\t\t<input type=\"submit\" value=\"Search\" />"
				+ "\n\t\t</form>\n\t</div>");
		
		out.append("\n\t<div class=\"containerDirector\">\n\t\t<form action=\"SearchByDirector\">"
				+ "\n\t\t\t<label for=\"director\"><strong>Search by Director:</strong></label>"
				+ "\n\t\t\t<input name=\"director\" />"
				+ "\n\t\t\t<input type=\"submit\" value=\"Search\" />"
				+ "\n\t\t</form>\n\t</div>");
		
		
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
