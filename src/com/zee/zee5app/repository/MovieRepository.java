package com.zee.zee5app.repository;

import com.zee.zee5app.dto.Movie;

public interface MovieRepository {
	public String addMovie(Movie movie);

	public String updateMovieById(String id, Movie movie);

	public String deleteMovieById(String id);

	public Movie getMovieById(String id);

	public Movie[] getAllMovies();
}
