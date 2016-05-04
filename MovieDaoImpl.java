package edu.cvtc.web.dao.impl;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.cvtc.web.dao.MovieDao;
import edu.cvtc.web.model.Movie;
import edu.cvtc.web.util.DBUtility;
import edu.cvtc.web.util.WorkbookUtility;

/**
 * @author Jason Friend-Fellows
 *
 */
public class MovieDaoImpl implements MovieDao {
	
	private static final String DROP_TABLE_MOVIE = "drop table if exists movie";
	private static final String CREATE_TABLE_MOVIE = "create table movie(id integer primary key autoincrement, title text, director text, lengthInMinutes integer, imdbLink text)";
	private static final String SELECT_ALL_FROM_MOVIE = "select * from movie";
	
	@Override
	public void populate(final String filePath) throws Exception {

		final Connection connection = DBUtility.createConnection();
		final Statement statement = connection.createStatement();
		
		try{
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			
			statement.executeUpdate(DROP_TABLE_MOVIE);
			statement.executeUpdate(CREATE_TABLE_MOVIE);
			
			final File inputFile = new File(filePath);
			final List<Movie> movies = WorkbookUtility.retrieveMoviesFromWorkbook(inputFile);
			
			for(final Movie movie : movies){
				String insertValues = "insert into movie (title, director, lengthInMinutes, imdbLink) values ('"
						+ movie.getTitle() + "', '"
								+ movie.getDirector() + "', "
										+ movie.getLengthInMinutes() + ", '"
												+ movie.getImdbLink() + "');";
				System.out.println(insertValues);
				
				statement.executeUpdate(insertValues);
			}
			
		} finally {
			DBUtility.closeConnections(connection, statement);
		}
	}

	@Override
	public List<Movie> retrieveMovies() throws Exception {
		
		final List<Movie> movies = new ArrayList<>();
		
		final Connection connection = DBUtility.createConnection();
		final Statement statement = connection.createStatement();
		
		try{
			statement.setQueryTimeout(DBUtility.TIMEOUT);
			
			final ResultSet resultSet = statement.executeQuery(SELECT_ALL_FROM_MOVIE);
			
			while(resultSet.next()){
				final String title = resultSet.getString("title");
				final String director = resultSet.getString("director");
				final int lengthInMinutes = resultSet.getInt("lengthInMinutes");
				final String imdbLink = resultSet.getString("imdbLink");
				
				final Movie movie = new Movie(title, director, lengthInMinutes, imdbLink);
				movies.add(movie);
			}
			
			resultSet.close();
			
		} finally {
			DBUtility.closeConnections(connection, statement);
		}
		
		return movies;
	}

	@Override
	public void insertMovie(final Movie movie) throws Exception {
		Connection connection = null;
		PreparedStatement insertStatement = null;
		
		try {
			connection = DBUtility.createConnection();
			
			final String insertValues = "insert into movie (title, director, lengthInMinutes, imdbLink) values (?,?,?,?)";
			insertStatement = connection.prepareStatement(insertValues);
			
			insertStatement.setString(1, movie.getTitle());
			insertStatement.setString(2, movie.getDirector());
			insertStatement.setInt(3, movie.getLengthInMinutes());
			insertStatement.setString(4, movie.getImdbLink());
			
			insertStatement.setQueryTimeout(DBUtility.TIMEOUT);
			
			insertStatement.executeUpdate();
			
		}finally{
			DBUtility.closeConnections(connection, insertStatement);
		}
		
	}

}
