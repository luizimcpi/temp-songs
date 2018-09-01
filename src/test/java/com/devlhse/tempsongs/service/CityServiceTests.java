package com.devlhse.tempsongs.service;

import com.devlhse.tempsongs.component.CityWeatherInfoComponent;
import com.devlhse.tempsongs.component.SongRecommendationComponent;
import com.devlhse.tempsongs.dto.city.City;
import com.devlhse.tempsongs.dto.track.Playlist;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CityServiceTests {

    @Mock
    CityWeatherInfoComponent cityWeatherInfoComponent;

    @Mock
    SongRecommendationComponent songRecommendationComponent;

    @InjectMocks
    private CityService cityService;

    @Test
    public void shouldGetCityWeatherWithSuccess(){
        when(cityWeatherInfoComponent.getCityWeatherInfoByName(Mockito.anyString())).thenReturn(new City());
        Assert.assertNotNull(cityService.getCityWeather(Mockito.anyString()));
    }

    @Test
    public void shouldGetCitySongsByWeatherWithSuccess(){
        when(cityWeatherInfoComponent.getCityWeatherInfoByName(Mockito.anyString())).thenReturn(new City());
        when(songRecommendationComponent.getSongsForCityWeather(Mockito.any())).thenReturn(new Playlist());
        Assert.assertNotNull(cityService.getCitySongsByWeather(Mockito.anyString()));
    }

    @Test
    public void shouldGetCitySongsByWeatherByCoordinatesWithSuccess(){
        when(cityWeatherInfoComponent.getCityWeatherInfoByCoordinates(Mockito.anyString(), Mockito.anyString())).thenReturn(new City());
        when(songRecommendationComponent.getSongsForCityWeather(Mockito.any())).thenReturn(new Playlist());
        Assert.assertNotNull(cityService.getCitySongsByWeatherByCoordinates(Mockito.anyString(), Mockito.anyString()));
    }
}
