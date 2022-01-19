package com.zee.zee5app.repository.impl;

import java.util.Arrays;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.repository.MovieRepository;

public class MovieRepositoryImpl implements MovieRepository {

	private MovieRepositoryImpl() {

	}

	private static MovieRepositoryImpl movieRepository = null;
	private Movie[] movies = new Movie[10];
	private static int counter = 0;

	public static MovieRepositoryImpl getInstance() {
		if (movieRepository == null)
			movieRepository = new MovieRepositoryImpl();
		return movieRepository;
	}

	@Override
	public String addMovie(Movie movie) {
		if (counter == movies.length) {
			Movie temp[] = new Movie[2 * movies.length];
			System.arraycopy(movies, 0, temp, 0, movies.length);
			movies = temp;
		}
		movies[counter++] = movie;
		return "success";
	}

	@Override
	public String deleteMovieById(String id) {
		boolean found = false;
		for (int i = 1; i <= this.counter; i++) {
			if (movies[i - 1] == null)
				break;
			if (movies[i - 1].getId().equals(id)) {
				found = true;
			}
			if (found) {
				if (i != this.counter)
					movies[i - 1] = movies[i];
			}
		}
		if (found) {
			movies[--this.counter] = null;
			return "success";
		}
		return "failed! No objects found";
	}

	@Override
	public String updateMovieById(String id, Movie movie) {
		for (int i = 0; i < this.counter; i++) {
			if (movies[i].getId().equals(id)) {
				movies[i] = movie;
				return "success";
			}
		}
		return "failed";
	}

	@Override
	public Movie getMovieById(String id) {
		for (Movie movie : movies) {
			if (movie == null)
				return null;
			if (movie.getId().equals(id))
				return movie;
		}
		return null;
	}

	@Override
	public Movie[] getAllMovies() {
		return Arrays.copyOf(movies, this.counter);
	}

}
