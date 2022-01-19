package com.zee.zee5app.service.impl;

import com.zee.zee5app.dto.Series;
import com.zee.zee5app.repository.impl.SeriesRepositoryImpl;
import com.zee.zee5app.service.SeriesService;

public class SeriesServiceImpl implements SeriesService {

	private SeriesServiceImpl() {

	}

	private SeriesRepositoryImpl seriesRepository = SeriesRepositoryImpl.getInstance();
	private static SeriesServiceImpl seriesService = null;

	public static SeriesServiceImpl getInstance() {
		if (seriesService == null)
			seriesService = new SeriesServiceImpl();
		return seriesService;
	}

	@Override
	public String addSeries(Series series) {
		return this.seriesRepository.addSeries(series);
	}

	@Override
	public String updateSeriesById(String id, Series series) {
		return this.seriesRepository.updateSeriesById(id, series);
	}

	@Override
	public String deleteSeriesById(String id) {
		return this.seriesRepository.deleteSeriesById(id);
	}

	@Override
	public Series getSeriesById(String id) {
		return this.seriesRepository.getSeriesById(id);
	}

	@Override
	public Series[] getAllSeries() {
		return this.seriesRepository.getAllSeries();
	}
}
