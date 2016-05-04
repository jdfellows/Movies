package edu.cvtc.web.predicate;

import com.google.common.base.Predicate;

import edu.cvtc.web.model.Movie;

/**
 * @author Jason Friend-Fellows
 *
 */
public class DirectorPredicate implements Predicate<Movie> {

	private String director;
	
	public DirectorPredicate(final String director){
		this.director = director;
	}

	@Override
	public boolean apply(final Movie movie) {
		return movie.getDirector().equalsIgnoreCase(director);
	}

}
