package com.devlhse.tempsongs.service;

import com.devlhse.tempsongs.dto.City;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CityService {

    public City getCityInfoByName(String cityName){
        RestTemplate template = new RestTemplate();
        return template.getForObject("http://samples.openweathermap.org/data/2.5/weather?q={cityName}&appid=b6907d289e10d714a6e88b30761fae22", City.class, cityName);
    }
}
