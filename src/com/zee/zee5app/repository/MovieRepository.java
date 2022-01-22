package com.zee.zee5app.repository;

import java.util.ArrayList;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.exception.IdNotFoundException;

public interface MovieRepository {
	public String addMovie(Movie movie);

	public String updateMovieById(String id, Movie movie);

	public String deleteMovieById(String id) throws IdNotFoundException;

	public Optional<Movie> getMovieById(String id) throws IdNotFoundException;

	public ArrayList<Movie> getAllMovies();
}
