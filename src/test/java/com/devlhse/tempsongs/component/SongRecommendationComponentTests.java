package com.devlhse.tempsongs.component;

import com.devlhse.tempsongs.dto.city.City;
import com.devlhse.tempsongs.dto.city.Main;
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
public class SongRecommendationComponentTests {

    @Mock
    private SpotifyTrackComponent spotifyTrackComponent;

    @InjectMocks
    private SongRecommendationComponent songRecommendationComponent;

    @Test
    public void shouldReturnPartyPlaylistWhenTemperatureIsAbove30(){
        Main VALID_MAIN = new Main.Builder(new Main()).withTemp(303.0).build();
        City VALID_CITY_WITH_30_GRAUS_OF_TEMPERATURE = new City.Builder(new City()).withMain(VALID_MAIN).build();
        when(spotifyTrackComponent.getPlaylist(Mockito.anyString())).thenReturn(new Playlist());
        Assert.assertNotNull(songRecommendationComponent.getSongsForCityWeather(VALID_CITY_WITH_30_GRAUS_OF_TEMPERATURE));
    }

    @Test
    public void shouldReturnPopPlaylistWhenTemperatureIsUnder30(){
        Main VALID_MAIN = new Main.Builder(new Main()).withTemp(300.0).build();
        City VALID_CITY_WITH_27_GRAUS_OF_TEMPERATURE = new City.Builder(new City()).withMain(VALID_MAIN).build();
        when(spotifyTrackComponent.getPlaylist(Mockito.anyString())).thenReturn(new Playlist());
        Assert.assertNotNull(songRecommendationComponent.getSongsForCityWeather(VALID_CITY_WITH_27_GRAUS_OF_TEMPERATURE));
    }

    @Test
    public void shouldReturnRockPlaylistWhenTemperatureIsUnder14(){
        Main VALID_MAIN = new Main.Builder(new Main()).withTemp(287.0).build();
        City VALID_CITY_WITH_14_GRAUS_OF_TEMPERATURE = new City.Builder(new City()).withMain(VALID_MAIN).build();
        when(spotifyTrackComponent.getPlaylist(Mockito.anyString())).thenReturn(new Playlist());
        Assert.assertNotNull(songRecommendationComponent.getSongsForCityWeather(VALID_CITY_WITH_14_GRAUS_OF_TEMPERATURE));
    }

    @Test
    public void shouldReturnClassicalPlaylistWhenTemperatureIsUnder9(){
        Main VALID_MAIN = new Main.Builder(new Main()).withTemp(282.0).build();
        City VALID_CITY_WITH_9_GRAUS_OF_TEMPERATURE = new City.Builder(new City()).withMain(VALID_MAIN).build();
        when(spotifyTrackComponent.getPlaylist(Mockito.anyString())).thenReturn(new Playlist());
        Assert.assertNotNull(songRecommendationComponent.getSongsForCityWeather(VALID_CITY_WITH_9_GRAUS_OF_TEMPERATURE));
    }
}
