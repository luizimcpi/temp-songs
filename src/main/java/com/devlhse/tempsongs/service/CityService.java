package com.devlhse.tempsongs.service;

import com.devlhse.tempsongs.component.CityWeatherInfoComponent;
import com.devlhse.tempsongs.component.SongRecommendationComponent;
import com.devlhse.tempsongs.dto.city.City;
import com.devlhse.tempsongs.dto.track.Playlist;
import com.devlhse.tempsongs.exception.CityNotFoundException;
import com.devlhse.tempsongs.exception.ServiceUnavailbleException;
import com.devlhse.tempsongs.exception.TrackNotFoundException;
import com.devlhse.tempsongs.exception.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    private final CityWeatherInfoComponent cityWeatherInfoComponent;
    private final SongRecommendationComponent songRecommendationComponent;

    @Autowired
    public CityService(final CityWeatherInfoComponent cityWeatherInfoComponent,
                       final SongRecommendationComponent songRecommendationComponent){
        this.cityWeatherInfoComponent = cityWeatherInfoComponent;
        this.songRecommendationComponent = songRecommendationComponent;
    }

    public City getCityWeather(String cityName) throws CityNotFoundException, ServiceUnavailbleException {
        return cityWeatherInfoComponent.getCityWeatherInfoByName(cityName);
    }

    public Playlist getCitySongsByWeather(String cityName) throws CityNotFoundException, TrackNotFoundException, ServiceUnavailbleException, UnauthorizedException {
        City cityWeatherInfo = cityWeatherInfoComponent.getCityWeatherInfoByName(cityName);
        return songRecommendationComponent.getSongsForCityWeather(cityWeatherInfo);
    }

    public Playlist getCitySongsByWeatherByCoordinates(String latitude, String longitude) throws CityNotFoundException, TrackNotFoundException, ServiceUnavailbleException, UnauthorizedException {
        City cityWeatherInfo = cityWeatherInfoComponent.getCityWeatherInfoByCoordinates(latitude, longitude);
        return songRecommendationComponent.getSongsForCityWeather(cityWeatherInfo);
    }

}
