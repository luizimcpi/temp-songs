package com.devlhse.tempsongs.service;

import com.devlhse.tempsongs.dto.city.City;
import com.devlhse.tempsongs.exception.CityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CityService {

    private static final String CITY_PARAMETER = "?q={cityName}&appid=";
    private static final Logger log = LoggerFactory.getLogger(CityService.class);

    public City getCitySongsByWeather(String weatherApiUrl, String weatherApiKey, String cityName) throws CityNotFoundException{

        RestTemplate restTemplate = new RestTemplate();
        City city = null;
        try{
            log.info("Searching weather info for city: " + cityName);
            city = restTemplate.getForObject(weatherApiUrl+CITY_PARAMETER+weatherApiKey, City.class, cityName);
        }catch (Exception e) {
            if (e.getMessage().contains(HttpStatus.NOT_FOUND.toString())){
                throw new CityNotFoundException("Can´t pull list of songs, City not found!");
            }
            e.printStackTrace();
        }
        return city;
    }
}
