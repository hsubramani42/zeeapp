package com.zee.zee5app.service.impl;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.repository.impl.MovieRepositoryImpl;
import com.zee.zee5app.service.MovieService;

public class MovieServiceImpl implements MovieService {
	private MovieServiceImpl() {

	}

	private MovieRepositoryImpl movieRepository = MovieRepositoryImpl.getInstance();
	private static MovieServiceImpl movieService = null;

	public static MovieServiceImpl getInstance() {
		if (movieService == null)
			movieService = new MovieServiceImpl();
		return movieService;
	}

	@Override
	public String addMovie(Movie movie) {
		return this.movieRepository.addMovie(movie);
	}

	@Override
	public String updateMovieById(String id, Movie movie) {
		return this.movieRepository.updateMovieById(id, movie);
	}

	@Override
	public String deleteMovieById(String id) {
		return this.movieRepository.deleteMovieById(id);
	}

	@Override
	public Movie getMovieById(String id) {
		return this.movieRepository.getMovieById(id);
	}

	@Override
	public Movie[] getAllMovies() {
		return this.movieRepository.getAllMovies();
	}
}
