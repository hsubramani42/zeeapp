package com.zee.zee5app.repository;

import java.util.Arrays;

import com.zee.zee5app.dto.Series;

public class SeriesRepository {

	private SeriesRepository() {
		
	}
	
	private static SeriesRepository seriesRepository = null;
	private Series[] seriess = new Series[10];
	private static int counter = 0;
	
	
	public static SeriesRepository getInstance() {
		if (seriesRepository==null)
			seriesRepository=new SeriesRepository();
		return seriesRepository;
	}
	
	public String addSeries(Series series) {
		if(counter==seriess.length) {
			Series temp[]=new Series[2*seriess.length];
			System.arraycopy(seriess, 0, temp, 0, seriess.length);
		}
		seriess[counter++] = series;
		return "success";
	}
	
	public String deleteSeries(String id) {
		boolean found=false;
		for(int i=1;i<=this.counter;i++) {
			if(seriess[i-1]==null)
				break;
			if(seriess[i-1].getId().equals(id)) {
				found=true;
			}
			if(found) {
				if(i!=this.counter)
					seriess[i-1]=seriess[i];
			}
		}
		if(found) {
			seriess[--this.counter] = null;
			return "success";
		}
		return "failed! No objects found";
	}
	
	public String modifySeries(String id, Series series) {
		for(int i=0;i<this.counter;i++) {
			if(seriess[i].getId().equals(id)) {
				seriess[i]=series;
				return "success";
			}
		}
		return "failed";
	}
	
	public Series getSeriesById(String id) {
		for(Series series:seriess) {
			if(series==null)
				return null;
			if(series.getId().equals(id))
				return series;
		}
		return null;
	}
	
	public Series[] getAllSeries() {
		return Arrays.copyOf(seriess, this.counter);
	}
	
}
