package com.devlhse.tempsongs.service;

import com.devlhse.tempsongs.component.CityWeatherInfoComponent;
import com.devlhse.tempsongs.component.SongRecommendationComponent;
import com.devlhse.tempsongs.dto.city.City;
import com.devlhse.tempsongs.exception.CityNotFoundException;
import com.devlhse.tempsongs.exception.TrackNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.midi.Track;

@Service
public class CityService {

    private final CityWeatherInfoComponent cityWeatherInfoComponent;
    private final SongRecommendationComponent songRecommendationComponent;

    @Autowired
    public CityService(final CityWeatherInfoComponent cityWeatherInfoComponent,
                       final SongRecommendationComponent songRecommendationComponent) throws CityNotFoundException{
        this.cityWeatherInfoComponent = cityWeatherInfoComponent;
        this.songRecommendationComponent = songRecommendationComponent;
    }

    public City getCityWeather(String cityName) throws CityNotFoundException{
        return cityWeatherInfoComponent.getCityWeatherInfo(cityName);
    }

    public City getCitySongsByWeather(String cityName) throws CityNotFoundException, TrackNotFoundException {
        City cityWeatherInfo = cityWeatherInfoComponent.getCityWeatherInfo(cityName);
        return songRecommendationComponent.getSongsForCityWeather(cityWeatherInfo);
    }


}
