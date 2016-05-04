package edu.cvtc.web.view;

/**
 * @author Jason Friend-Fellows
 *
 */
public class NavView {
	
	
	public static String buildNavigation(){
		
		final StringBuilder out = new StringBuilder();
		
		out.append("\n\t\t<p> <a href=\"Movies\">Unsorted</a>"
				+ " - <a href=\"SortByTitle\">Sort By Title</a>"
				+ " - <a href=\"SortByDirector\">Sort By Director</a>"
				+ " - <a href=\"SortByLengthInMinutes\">Sort By Length In Minutes</a>"
				+ " - <a href=\"Search\">Search</a>"
				+ " - <a href=\"addMovies.jsp\">Add Movies</a></p>");	
		
		return out.toString();
	}

}
