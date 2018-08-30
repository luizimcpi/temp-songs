package com.devlhse.tempsongs.service;

import com.devlhse.tempsongs.dto.City;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CityService {

    public City getCityInfoByName(String cityName){
        RestTemplate template = new RestTemplate();
        return template.getForObject("http://api.openweathermap.org/data/2.5/weather?q={cityName}&appid=130aab12fceacb0e3c68009f1e07b0ea", City.class, cityName);
    }
}
