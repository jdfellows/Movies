package edu.cvtc.web.search.impl;

import java.util.Collections;
import java.util.List;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;

import edu.cvtc.web.comparators.DirectorComparator;
import edu.cvtc.web.comparators.LengthInMinutesComparator;
import edu.cvtc.web.comparators.SortBy;
import edu.cvtc.web.comparators.TitleComparator;
import edu.cvtc.web.dao.MovieDao;
import edu.cvtc.web.dao.impl.MovieDaoImpl;
import edu.cvtc.web.exceptions.MovieSearchException;
import edu.cvtc.web.model.Movie;
import edu.cvtc.web.predicate.DirectorPredicate;
import edu.cvtc.web.predicate.TitlePredicate;
import edu.cvtc.web.search.MovieSearch;

/**
 * @author Jason Friend-Fellows
 *
 */
public class MovieSearchImpl implements MovieSearch {
	
	private static final String EXCEPTION_MESSAGE = "List of movies could not be retrieved from the database.";

	@Override
	public List<Movie> findMoviesByTitle(final String Title) throws MovieSearchException {
		try {			
			final MovieDao movieDao = new MovieDaoImpl();
			final List<Movie> movies = movieDao.retrieveMovies();
			return Lists.newArrayList(Collections2.filter(movies, new TitlePredicate(Title)));
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new MovieSearchException(EXCEPTION_MESSAGE);
		}

	}

	@Override
	public List<Movie> findMoviesByDirector(final String Director) throws MovieSearchException {
		try {			
			final MovieDao movieDao = new MovieDaoImpl();
			final List<Movie> movies = movieDao.retrieveMovies();
			return Lists.newArrayList(Collections2.filter(movies, new DirectorPredicate(Director)));
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new MovieSearchException(EXCEPTION_MESSAGE);
		}

	}

	@Override
	public List<Movie> retrieveMovies(String sortType) throws MovieSearchException {
		try{
			final MovieDao MovieDao = new MovieDaoImpl();
			final List<Movie> Movies = MovieDao.retrieveMovies();
			
			if(null != sortType){
				sortMovies(Movies, sortType);
			}
			
			return Movies;
			
		}catch(Exception e){
			e.printStackTrace();
			throw new MovieSearchException(EXCEPTION_MESSAGE);
		}

	}

	private void sortMovies(final List<Movie> movie, final String sortType) {
		switch (sortType){
		case SortBy.DIRECTOR:
			Collections.sort(movie, new DirectorComparator());
			break;
		case SortBy.TITLE:
			Collections.sort(movie, new TitleComparator());
			break;
		case SortBy.LENGTH_IN_MINUTES:
			Collections.sort(movie, new LengthInMinutesComparator());
			break;		
			default:
				break;
		}
		
	}

}
