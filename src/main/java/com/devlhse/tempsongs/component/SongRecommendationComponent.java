package com.devlhse.tempsongs.component;

import com.devlhse.tempsongs.ConversionUtils;
import com.devlhse.tempsongs.dto.city.City;
import com.devlhse.tempsongs.exception.TrackNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SongRecommendationComponent {

    private final SpotifyTrackComponent spotifyTrackComponent;

    @Autowired
    public SongRecommendationComponent(final SpotifyTrackComponent spotifyTrackComponent){
        this.spotifyTrackComponent = spotifyTrackComponent;
    }

    public City getSongsForCityWeather(City cityWeatherInfo) throws TrackNotFoundException {
        Double temperature = ConversionUtils.kelvinToCelsius(cityWeatherInfo.getMain().getTemp());

        if(temperature >= 30){
            return cityWeatherInfo;
//           return spotifyTrackComponent.getPartyTracks();
        }else if(temperature >= 15 && temperature < 30){
            return cityWeatherInfo;
//            return spotifyTrackComponent.getPopMusicTracks();
        }else if(temperature >= 10 && temperature <= 14){
            return cityWeatherInfo;
//            return spotifyTrackComponent.getRockMusicTracks();
        }else if(temperature <= 9) {
            return cityWeatherInfo;
//            return spotifyTrackComponent.getRockMusicTracks();
        }

        throw new TrackNotFoundException("Sorry! We can´t found tracks for your city/weather!");
    }
}
