package com.devlhse.tempsongs.service;

import com.devlhse.tempsongs.component.CityWeatherInfoComponent;
import com.devlhse.tempsongs.dto.city.City;
import com.devlhse.tempsongs.exception.CityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    private final CityWeatherInfoComponent cityWeatherInfoComponent;

    @Autowired
    public CityService(final CityWeatherInfoComponent cityWeatherInfoComponent) throws CityNotFoundException{
        this.cityWeatherInfoComponent = cityWeatherInfoComponent;
    }

    public City getCityWeather(String cityName) throws CityNotFoundException{
        return cityWeatherInfoComponent.getCityWeatherInfo(cityName);
    }

    public City getCitySongsByWeather(String cityName) throws CityNotFoundException{
        return cityWeatherInfoComponent.getCityWeatherInfo(cityName);
    }


}
