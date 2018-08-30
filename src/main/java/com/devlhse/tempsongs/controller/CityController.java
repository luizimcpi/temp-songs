package com.devlhse.tempsongs.controller;

import com.devlhse.tempsongs.dto.city.City;
import com.devlhse.tempsongs.exception.CityNotFoundException;
import com.devlhse.tempsongs.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Value("${weather.api.url}")
    private String weatherUrl;

    @Value("${weather.api.key}")
    private String weatherApiKey;

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/{cityName}/songs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> getCitySongsByWeather(@PathVariable("cityName") String cityName) throws CityNotFoundException {
        City city = cityService.getCitySongsByWeather(weatherUrl, weatherApiKey, cityName);
        return ResponseEntity.ok(city);
    }
}
