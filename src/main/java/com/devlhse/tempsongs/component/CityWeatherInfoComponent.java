package com.devlhse.tempsongs.component;

import com.devlhse.tempsongs.dto.city.City;
import com.devlhse.tempsongs.exception.CityNotFoundException;
import com.devlhse.tempsongs.exception.ServiceUnavailbleException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

@Component
public class CityWeatherInfoComponent {

    private static final String CITY_PARAMETER = "?q={cityName}&appid=";
    private static final Logger log = LoggerFactory.getLogger(CityWeatherInfoComponent.class);

    @Value("${weather.api.url}")
    private String WEATHER_API_URL;

    @Value("${weather.api.key}")
    private String WEATHER_API_KEY;

    public City getCityWeatherInfo(String cityName) throws CityNotFoundException, ServiceUnavailbleException {
        RestTemplate restTemplate = new RestTemplate();
        City city = null;
        try{
            log.info("Searching weather info for city: " + cityName);
            city = restTemplate.getForObject(WEATHER_API_URL+CITY_PARAMETER+WEATHER_API_KEY, City.class, cityName);
        }catch (HttpClientErrorException e) {
            if (e.getMessage().contains(HttpStatus.NOT_FOUND.toString())) {
                throw new CityNotFoundException("City not found!");
            }
        }catch (ResourceAccessException e){
            throw new ServiceUnavailbleException("Sorry there is something wrong with Weather Service! Try again or later.");
        }
        return city;
    }
}
