package com.zee.zee5app.repository.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.repository.SeriesRepository;

public class SeriesRepositoryImpl implements SeriesRepository {

	private SeriesRepositoryImpl() {

	}

	private static SeriesRepositoryImpl seriesRepository = null;
	private ArrayList<Series> seriess=new ArrayList<>();

	public static SeriesRepositoryImpl getInstance() {
		if (seriesRepository == null)
			seriesRepository = new SeriesRepositoryImpl();
		return seriesRepository;
	}

	@Override
	public String addSeries(Series series) {
		return (seriess.add(series))?"Success! Object added":"Failed! Object not added.";
	}

	@Override
	public String updateSeriesById(String id, Series series) {
		for(int i=0;i<seriess.size();i++)
			if(seriess.get(i).getId().equals(id)) {
				seriess.set(i, series);
				return "Success! Updated.";
			}
		return "Failed! No objects found.";
	}

	@Override
	public String deleteSeriesById(String id) {
		for(int i=0;i<seriess.size();i++)
			if(seriess.get(i).getId().equals(id)) {
				seriess.remove(i);
				return "Success! Deleted.";
			}
		return "Failed! No objects found.";
	}

	@Override
	public Optional<Series> getSeriesById(String id) {
		for(Series series:seriess)
			if(series.getId().equals(id))
				return Optional.of(series);
		return Optional.empty();
	}

	@Override
	public ArrayList<Series> getAllSeries() {
		return seriess;
	}

}
