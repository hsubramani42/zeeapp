package com.zee.zee5app.repository.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.MovieRepository;

public class MovieRepositoryImpl implements MovieRepository {

	private MovieRepositoryImpl() {

	}

	private static MovieRepositoryImpl movieRepository = null;
	private Set<Movie> movies=new HashSet<>();

	public static MovieRepositoryImpl getInstance() {
		if (movieRepository == null)
			movieRepository = new MovieRepositoryImpl();
		return movieRepository;
	}

	@Override
	public String addMovie(Movie movie) {
		return (movies.add(movie))?"Success! Object added":"Failed! Object not added.";
	}

	@Override
	public String updateMovieById(String id, Movie movie) {
		
		return "Failed! No objects found.";
	}

	@Override
	public String deleteMovieById(String id) throws IdNotFoundException {
		boolean status = movies.remove(this.getMovieById(id).get());
		return status?"success":"failed";
	}

	@Override
	public Optional<Movie> getMovieById(String id) throws IdNotFoundException {
		for(Movie movie:movies)
			if(movie.getId().equals(id))
				return Optional.of(movie);
		Movie notFound = null;
		return Optional.of(Optional.ofNullable(notFound).orElseThrow(() -> new IdNotFoundException("Invalid Id")));
	}

	@Override
	public ArrayList<Movie> getAllMovies() {
		return movies;
	}
}