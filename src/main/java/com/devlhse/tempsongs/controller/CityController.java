package com.devlhse.tempsongs.controller;

import com.devlhse.tempsongs.dto.city.City;
import com.devlhse.tempsongs.dto.track.Playlist;
import com.devlhse.tempsongs.exception.CityNotFoundException;
import com.devlhse.tempsongs.exception.ServiceUnavailbleException;
import com.devlhse.tempsongs.exception.TrackNotFoundException;
import com.devlhse.tempsongs.exception.UnauthorizedException;
import com.devlhse.tempsongs.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(final CityService cityService) {
        this.cityService = cityService;
    }

    @RequestMapping(value = "/{cityName}/weather", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> getCityWeather(@PathVariable("cityName") String cityName) throws CityNotFoundException, ServiceUnavailbleException {
        City city = cityService.getCityWeather(cityName);
        return ResponseEntity.ok(city);
    }

    @RequestMapping(value = "/{cityName}/weather/songs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Playlist> getCitySongsByWeather(@PathVariable("cityName") String cityName) throws CityNotFoundException, TrackNotFoundException, ServiceUnavailbleException, UnauthorizedException {
        Playlist playlist = cityService.getCitySongsByWeather(cityName);
        return ResponseEntity.ok(playlist);
    }
}
