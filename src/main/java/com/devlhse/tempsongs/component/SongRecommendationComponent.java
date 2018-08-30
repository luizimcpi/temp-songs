package com.devlhse.tempsongs.component;

import com.devlhse.tempsongs.ConversionUtils;
import com.devlhse.tempsongs.dto.city.City;
import com.devlhse.tempsongs.dto.track.Playlist;
import com.devlhse.tempsongs.exception.ServiceUnavailbleException;
import com.devlhse.tempsongs.exception.TrackNotFoundException;
import com.devlhse.tempsongs.exception.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SongRecommendationComponent {

    private static final String SPOTIFY_PARTY_PLAYLIST_ID = "37i9dQZF1DXaXB8fQg7xif";
    private static final String SPOTIFY_POP_PLAYLIST_ID = "6rkeVtTW3Jpr4x8YGQM8fQ";
    private static final String SPOTIFY_ROCK_PLAYLIST_ID = "37i9dQZF1DXcmaoFmN75bi";
    private static final String SPOTIFY_CLASSICAL_PLAYLIST_ID = "37i9dQZF1DX9OZisIoJQhG";
    private static final Logger log = LoggerFactory.getLogger(SongRecommendationComponent.class);


    private final SpotifyTrackComponent spotifyTrackComponent;

    @Autowired
    public SongRecommendationComponent(final SpotifyTrackComponent spotifyTrackComponent){
        this.spotifyTrackComponent = spotifyTrackComponent;
    }

    public Playlist getSongsForCityWeather(City cityWeatherInfo) throws TrackNotFoundException, ServiceUnavailbleException, UnauthorizedException {
        Double temperature = ConversionUtils.kelvinToCelsius(cityWeatherInfo.getMain().getTemp());

        if(temperature >= 30){
            log.info("Looking for Party music tracks at spotify...");
           return spotifyTrackComponent.getPlaylist(SPOTIFY_PARTY_PLAYLIST_ID);
        }else if(temperature >= 15 && temperature < 30){
            log.info("Looking for Pop music tracks at spotify...");
            return spotifyTrackComponent.getPlaylist(SPOTIFY_POP_PLAYLIST_ID);
        }else if(temperature >= 10 && temperature <= 14){
            log.info("Looking for Rock music tracks at spotify...");
            return spotifyTrackComponent.getPlaylist(SPOTIFY_ROCK_PLAYLIST_ID);
        }else if(temperature <= 9) {
            log.info("Looking for Classic music tracks at spotify...");
            return spotifyTrackComponent.getPlaylist(SPOTIFY_CLASSICAL_PLAYLIST_ID);
        }

        throw new TrackNotFoundException("Sorry! We can´t found tracks for your city/weather!");
    }
}
