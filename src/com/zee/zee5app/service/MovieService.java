package com.zee.zee5app.service;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.repository.MovieRepository;

public class MovieService {
	private MovieService() {
		
	}
	private MovieRepository movieRepository = MovieRepository.getInstance();
	private static MovieService movieService = null;
	
	public static MovieService getInstance() {
		if(movieService==null)
			movieService = new MovieService();
		return movieService;
	}
	
	public String addMovie(Movie movie) {
		return this.movieRepository.addMovie(movie);
	}
	
	public String modifyMovie(String id, Movie movie) {
		return this.movieRepository.modifyMovie(id, movie);
	}
	
	public String deleteMovie(String id) {
		return this.movieRepository.deleteMovie(id);
	}
	
	public Movie getMovieById(String id) {
		return this.movieRepository.getMovieById(id);
	}
	public Movie[] getAllMovies() {
		return this.movieRepository.getAllMovies();
	}
}
