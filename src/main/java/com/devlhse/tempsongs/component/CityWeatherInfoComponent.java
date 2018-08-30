package com.devlhse.tempsongs.component;

import com.devlhse.tempsongs.dto.city.City;
import com.devlhse.tempsongs.exception.CityNotFoundException;
import com.devlhse.tempsongs.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CityWeatherInfoComponent {

    private static final String CITY_PARAMETER = "?q={cityName}&appid=";
    private static final Logger log = LoggerFactory.getLogger(CityWeatherInfoComponent.class);

    @Value("${weather.api.url}")
    private String weatherApiUrl;

    @Value("${weather.api.key}")
    private String weatherApiKey;

    public City getCityWeatherInfo(String cityName) throws CityNotFoundException {
        RestTemplate restTemplate = new RestTemplate();
        City city = null;
        try{
            log.info("Searching weather info for city: " + cityName);
            city = restTemplate.getForObject(weatherApiUrl+CITY_PARAMETER+weatherApiKey, City.class, cityName);
        }catch (Exception e) {
            if (e.getMessage().contains(HttpStatus.NOT_FOUND.toString())){
                throw new CityNotFoundException("City not found!");
            }
            e.printStackTrace();
        }
        return city;
    }
}
