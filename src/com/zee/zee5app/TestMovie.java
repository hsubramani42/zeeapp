package com.zee.zee5app;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.service.impl.MovieServiceImpl;

public class TestMovie {

	public static void main(String[] args) {

		MovieServiceImpl movieService = MovieServiceImpl.getInstance();

		for (int i = 1; i <= 10; i++) {
			Movie movie = new Movie();
			movie.setId(i + "");
			movie.setName("Movie-" + i);
			movie.setLanguage("Language-" + i % 3);
			movie.setReleaseDate(new Date());
			movieService.addMovie(movie);
		}

		String uid = 10 + "";

		for (Movie movie : movieService.getAllMovies()) {
			System.out.println("\nMovie Object: " + movie);
		}

		System.out.println("\nCheck Movie: " + uid + "\nStatus: " + movieService.getMovieById(uid).isPresent());

		System.out.println("\nDelete Movie: " + uid + "\nStatus: " + movieService.deleteMovieById(uid));

		System.out.println("\nCheck Movie: " + uid + "\nStatus: " + movieService.getMovieById(uid).isPresent());

		for (int i = 11; i <= 21; i++) {
			Movie movie = new Movie();
			movie.setId(i + "");
			movie.setName("Movie-" + i);
			movie.setLanguage("Language-" + i % 3);
			movie.setReleaseDate(new Date());
			movieService.addMovie(movie);
		}

		int i=10;
		Movie movie = new Movie();
		movie.setId(i + "");
		movie.setName("Movie-" + i);
		movie.setLanguage("Language-" + i % 3);
		movie.setReleaseDate(new Date());
		movieService.addMovie(movie);
		System.out.println(
				"\nModify User: " + i + "\nStatus: " + movieService.updateMovieById(21+"" + "", movie));

		for (Movie movie1 : movieService.getAllMovies()) {
			System.out.println("\nMovie Object: " + movie1);
		}

	}

}
