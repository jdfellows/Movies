package edu.cvtc.web.comparators;

import java.util.Comparator;

import edu.cvtc.web.model.Movie;

/**
 * @author Jason Friend-Fellows
 *
 */
public class LengthInMinutesComparator implements Comparator<Movie> {
	
	@Override
	public int compare(Movie m1, Movie m2) {
		return m1.getLengthInMinutes().compareTo(m2.getLengthInMinutes());
	}

}
