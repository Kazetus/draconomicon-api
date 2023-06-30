package com.draconomicon.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.draconomicon.api.model.Weather;
import com.draconomicon.api.repository.WeatherRepository;

import lombok.Data;

@Data
@Service
public class WeatherService {
	@Autowired
	private WeatherRepository weatherRepository;
	
	public Optional<Weather> getWeather(final Long id){
		return weatherRepository.findById(id);
	}
	public Iterable<Weather> getWeather() {
		return weatherRepository.findAll();
	}
	public void deleteWeather(final Long id) {
		weatherRepository.deleteById(id);
	}
	public Weather saveWeather(Weather weather) {
		Weather savedWeather = weatherRepository.save(weather);
		return savedWeather;
	}
}
