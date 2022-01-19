package com.zee.zee5app.service;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.repository.SeriesRepository;

public class SeriesService {
	
	private SeriesService() {
		
	}
	private SeriesRepository seriesRepository = SeriesRepository.getInstance();
	private static SeriesService seriesService = null;
	
	public static SeriesService getInstance() {
		if(seriesService==null)
			seriesService = new SeriesService();
		return seriesService;
	}
	
	public String addSeries(Series series) {
		return this.seriesRepository.addSeries(series);
	}
	
	public String modifyMovie(String id, Series series) {
		return this.seriesRepository.modifySeries(id, series);
	}
	
	public String deleteMovie(String id) {
		return this.seriesRepository.deleteSeries(id);
	}
	
	public Series getMovieById(String id) {
		return this.seriesRepository.getSeriesById(id);
	}
	public Series[] getAllMovies() {
		return this.seriesRepository.getAllSeries();
	}
}
