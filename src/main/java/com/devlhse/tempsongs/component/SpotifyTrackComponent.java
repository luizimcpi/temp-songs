package com.devlhse.tempsongs.component;

import com.devlhse.tempsongs.dto.spotify.SecurityResponse;
import com.devlhse.tempsongs.dto.track.Playlist;
import com.devlhse.tempsongs.exception.ServiceUnavailbleException;
import com.devlhse.tempsongs.exception.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Component
public class SpotifyTrackComponent {

    private static final Logger log = LoggerFactory.getLogger(SpotifyTrackComponent.class);

    @Value("${spotify.client.credentials}")
    private String SPOTIFY_CLIENT_CREDENTIALS;

    @Value("${spotify.api.login.url}")
    private String SPOTIFY_API_LOGIN_URL;

    @Value("${spotify.api.playslists.url}")
    private String SPOTIFY_API_PLAYLISTS_URL;

    private RestTemplate restTemplate = new RestTemplate();


    public Playlist getPlaylist(String playlistId) throws ServiceUnavailbleException, UnauthorizedException {

        try {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Bearer "+this.getSpotifyTokenAuthorization());
            HttpEntity<String> request = new HttpEntity<>(headers);
            ResponseEntity<Playlist> response = restTemplate.exchange(SPOTIFY_API_PLAYLISTS_URL+"/"+playlistId+"/tracks", HttpMethod.GET, request, Playlist.class);
            return response.getBody();
        }catch (ResourceAccessException e){
            throw new ServiceUnavailbleException("Sorry there is something wrong with spotify playlists service! Try again or later.");
        }catch (HttpClientErrorException e){
            if (e.getMessage().contains(HttpStatus.UNAUTHORIZED.toString())) {
                throw new UnauthorizedException("Token credentials has been expired! Please verify with admin.");
            }
        }
        return null;
    }

    private String getSpotifyTokenAuthorization() throws ServiceUnavailbleException {

        try {
            log.info("Requesting Spotify authorization token...");

            MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
            body.add("grant_type", "client_credentials");

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            headers.add("Authorization", "Basic " + SPOTIFY_CLIENT_CREDENTIALS);
            HttpEntity<?> request = new HttpEntity<Object>(body,headers);
            ResponseEntity<SecurityResponse> response = restTemplate.exchange(SPOTIFY_API_LOGIN_URL, HttpMethod.POST, request, SecurityResponse.class);

            return response.getBody().getAccessToken();
        }catch (ResourceAccessException e){
            throw new ServiceUnavailbleException("Sorry there is something wrong with spotify authentication service! Try again or later.");
        }
    }
}
