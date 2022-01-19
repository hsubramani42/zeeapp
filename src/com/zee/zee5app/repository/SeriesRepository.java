package com.zee.zee5app.repository;

import com.zee.zee5app.dto.Series;

public interface SeriesRepository {
	public String addSeries(Series series);

	public String updateSeriesById(String id, Series series);

	public String deleteSeriesById(String id);

	public Series getSeriesById(String id);

	public Series[] getAllSeries();
}
