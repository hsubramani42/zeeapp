package com.zee.zee5app.service;

import java.util.ArrayList;
import java.util.Optional;

import com.zee.zee5app.dto.Series;

public interface SeriesService {
	public String addSeries(Series series);

	public String updateSeriesById(String id, Series series);

	public String deleteSeriesById(String id);

	public Optional<Series> getSeriesById(String id);

	public ArrayList<Series> getAllSeries();
}
