package edu.cvtc.web.search;

import java.util.List;

import edu.cvtc.web.exceptions.MovieSearchException;
import edu.cvtc.web.model.Movie;

/**
 * @author Jason Friend-Fellows
 *
 */
public interface MovieSearch {
	
	List<Movie> findMoviesByTitle(String Title) throws MovieSearchException;
	
	List<Movie> findMoviesByDirector(String Title) throws MovieSearchException;
	
	List<Movie> retrieveMovies(String sortType) throws MovieSearchException;

}
