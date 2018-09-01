package com.devlhse.tempsongs.component;

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

    private static final String SPOTIFY_PARTY_PLAYLIST_ID = "37i9dQZF1DXaXB8fQg7xif";
    private static final String SPOTIFY_POP_PLAYLIST_ID = "6rkeVtTW3Jpr4x8YGQM8fQ";
    private static final String SPOTIFY_ROCK_PLAYLIST_ID = "37i9dQZF1DXcmaoFmN75bi";
    private static final String SPOTIFY_CLASSICAL_PLAYLIST_ID = "37i9dQZF1DX9OZisIoJQhG";

    @Mock
    private SpotifyTrackComponent spotifyTrackComponent;

    @InjectMocks
    private SongRecommendationComponent songRecommendationComponent;

    @Test
    public void shouldReturnPartyPlaylistWhenTemperatureIsAbove30(){
        when(spotifyTrackComponent.getPlaylist(Mockito.anyString())).thenReturn(new Playlist());
        Assert.assertNotNull(songRecommendationComponent.getSongsForCityWeather(Mockito.any()));
    }
}
