package edu.cvtc.web.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.cvtc.web.exceptions.MovieSearchException;
import edu.cvtc.web.model.Movie;
import edu.cvtc.web.search.MovieSearch;
import edu.cvtc.web.search.impl.MovieSearchImpl;
import edu.cvtc.web.view.ErrorView;
import edu.cvtc.web.view.MovieView;

/**
 * Servlet implementation class SearchByDirectorServlet
 */
@WebServlet("/SearchByDirector")
public class SearchByDirectorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		final PrintWriter out = response.getWriter();
		
		try {
			// NOTES Search by director using the director parameter and the MovieSearch service
			// NOTES 1. Get the director from the request
			final String director = request.getParameter("director");
			
			// NOTES 2. Build the filePath using the INPUT_FILE constant
			final MovieSearch movieSearch = new MovieSearchImpl();
			
			// NOTES 3. use the MovieSearch service to retrieve a filtered List of Movie objects
			final List<Movie> Movies = movieSearch.findMoviesByDirector(director);
			
			// NOTES 4. Use the Movie object to build the HTML using the MovieView Class
			final String htmlOutput = MovieView.buildHTML(Movies);

			// NOTES 5. Use the String built using the MovieView class to provide our HTML output to the response
			out.append(htmlOutput);
			
		} catch (MovieSearchException e) {
			e.printStackTrace();
			out.append(ErrorView.buildHTML(e.getMessage()));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
