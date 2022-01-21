package com.zee.zee5app.repository.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.repository.MovieRepository;

public class MovieRepositoryImpl implements MovieRepository {

	private MovieRepositoryImpl() {

	}

	private static MovieRepositoryImpl movieRepository = null;
	private ArrayList<Movie> movies=new ArrayList<>();

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
		System.out.println(movie);
		for(int i=0;i<movies.size();i++)
			if(movies.get(i).getId().equals(id)) {
				movies.set(i, movie);
				return "Success! Updated.";
			}
		return "Failed! No objects found.";
	}

	@Override
	public String deleteMovieById(String id) {
		for(int i=0;i<movies.size();i++)
			if(movies.get(i).getId().equals(id)) {
				movies.remove(i);
				return "Success! Deleted.";
			}
		return "Failed! No objects found.";
	}

	@Override
	public Optional<Movie> getMovieById(String id) {
		for(Movie movie:movies)
			if(movie.getId().equals(id))
				return Optional.of(movie);
		return Optional.empty();
	}

	@Override
	public ArrayList<Movie> getAllMovies() {
		return movies;
	}
}