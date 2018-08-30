package com.devlhse.tempsongs.controller;

import com.devlhse.tempsongs.dto.City;
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

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/{cityName}/songs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> getCityInfoByName(@PathVariable("cityName") String cityName){
        City city = cityService.getCityInfoByName(cityName);
        return ResponseEntity.ok(city);
    }
}
