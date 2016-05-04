package edu.cvtc.web.model;

/**
 * @author Jason Friend-Fellows
 *
 */
public class Movie {
	
	private String title;
	private String director;
	private int lengthInMinutes;
	private String imdbLink;
	
	public Movie(String title, final String director, final int lengthInMinutes, final String imdbLink) {
		this.title = title;
		this.director = director;
		this.lengthInMinutes = lengthInMinutes;
		this.imdbLink = imdbLink;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDirector() {
		return director;
	}
	
	public Integer getLengthInMinutes() {
		return lengthInMinutes;
	}
	
	public String getImdbLink() {
		return imdbLink;
	}
	
	@Override
	public String toString() {
		return "Movie [Title=" + title + ", Director=" + director + ", LengthInMinutes=" + lengthInMinutes
				+ ", imdbLink=" + imdbLink + "]";
	}
	
}
