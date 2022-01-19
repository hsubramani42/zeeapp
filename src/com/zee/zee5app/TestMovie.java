package com.zee.zee5app;

import java.time.LocalDate;
import java.util.Date;

import com.zee.zee5app.dto.Movie;
import com.zee.zee5app.dto.Register;
import com.zee.zee5app.service.MovieService;

public class TestMovie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MovieService movieService = MovieService.getInstance();
		
		for(int i=0;i<10;i++) {
			Movie movie = new Movie();
			movie.setId(i+"");
			movie.setName("Movie-"+i);
			movie.setLanguage("Language-"+i%3);
			movie.setReleaseDate(new Date());
			movieService.addMovie(movie);
		}
		
		String uid = 10+"";
		
		for(Movie movie: movieService.getAllMovies()) {
			System.out.println("\nMovie Object: "+movie);
		}
		
		System.out.println("\nCheck Movie: "+uid+"\nStatus: "+ (movieService.getMovieById(uid)!=null));
		
		System.out.println("\nDelete Movie: "+uid+"\nStatus: "+ movieService.deleteMovie(uid));
		
		System.out.println("\nCheck Movie: "+uid+"\nStatus: "+ (movieService.getMovieById(uid)!=null));
		
		for(int i=11;i<=21;i++) {
			Movie movie = new Movie();
			movie.setId(i+"");
			movie.setName("Movie-"+i);
			movie.setLanguage("Language-"+i%3);
			movie.setReleaseDate(new Date());
			movieService.addMovie(movie);
		}
		
		int mid=21;
		Movie modify = movieService.getMovieById(mid+"");
		modify.setId(10+"");
		System.out.println("\nModify User: "+mid+"\nStatus: "+ (movieService.modifyMovie(mid+"",modify)));
		
		for(Movie movie: movieService.getAllMovies()) {
			System.out.println("\nMovie Object: "+movie);
		}
		
	}

}
