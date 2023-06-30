package com.draconomicon.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.draconomicon.api.model.Weather;

public interface WeatherRepository extends CrudRepository<Weather, Long>  {

}
