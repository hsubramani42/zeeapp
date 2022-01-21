package com.zee.zee5app.service;

import java.util.ArrayList;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;

public interface MovieService {
	public String addMovie(Movie movie);

	public String updateMovieById(String id, Movie movie);

	public String deleteMovieById(String id);

	public Optional<Movie> getMovieById(String id);

	public ArrayList<Movie> getAllMovies();
}
