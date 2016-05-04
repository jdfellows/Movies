package edu.cvtc.web.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import edu.cvtc.web.model.Movie;

/**
 * @author Jason Friend-Fellows
 *
 */
public class WorkbookUtility {
	
	public static final String INPUT_FILE = "/assets/spreadsheets/JavaWebProgrammingMovies.xlsx";
	
	public static List<Movie> retrieveMoviesFromWorkbook(final File inputFile) throws InvalidFormatException, IOException{
		final List<Movie> movies = new ArrayList<>();
		
		final Workbook workbook = WorkbookFactory.create(inputFile);
		
		final Sheet sheet = workbook.getSheetAt(0);
		
		for (final Row row : sheet){
			final Cell TitleCell = row.getCell(0);
		    final Cell DirectorCell = row.getCell(1);
		    final Cell LengthInMinutesCell = row.getCell(2);
		    final Cell iMDBLinkCell = row.getCell(3);
		    
		    final Movie movie = new Movie(
		    		TitleCell.getStringCellValue().trim(),
		    		DirectorCell.getStringCellValue().trim(),
		    		(int) LengthInMinutesCell.getNumericCellValue(),
		    		iMDBLinkCell.getStringCellValue().trim());
		    			
		    movies.add(movie);
		    
		}
		
		return movies;
	}

}
